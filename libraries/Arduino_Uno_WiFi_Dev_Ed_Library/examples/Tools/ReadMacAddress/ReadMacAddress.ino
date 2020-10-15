/*
This sketch Read the MAC Address from the ESP8266EX and print the code in the console.
*/

#include <Wire.h>
#include <UnoWiFiDevEd.h>

#define BAUD 9600
WifiData EspSerial;
String mac = "";         // a string to hold incoming data
String ssid="";
String espresponse="";
boolean flag=false;

//These commands, in SLIP protocol, get the MAC Address from the ESP8266.
char command1[]={0xc0,0x0,0xa,0x4,0x0,0x0,0x0,0x0,0x0,0x50,0x0,0xf0,0x3f,0xc0};
char command2[]={0xc0,0x0,0xa,0x4,0x0,0x0,0x0,0x0,0x0,0x54,0x0,0xf0,0x3f,0xc0};


void setup()
{
  Serial.begin(BAUD);
  pinMode(13, OUTPUT);
  digitalWrite(13, LOW);
  // UART to Serial Bridge Initialization
  EspSerial.begin(BAUD);               //baudrate setting
  mac.reserve(2000);
  while(!Serial);
}

void loop()
{
  read_mac();
}

void read_mac(){
  int i;
  //Send the command1 to the ESP char by char
  for(i=0; i<sizeof(command1); i++)
      EspSerial.write(command1[i]);

  //Read the reply but the response is not useful
  while (EspSerial.available()) {
    EspSerial.read();
  }

  //Send the command2 to the ESP char by char
  for(i=0; i<sizeof(command2); i++)
      EspSerial.write(command2[i]);

  //Read the reply
  while (EspSerial.available()) {
    int inChar = (int)EspSerial.read();
    espresponse+=String(inChar, HEX);
  }
  //Debug
  //Serial.println("");
  //Serial.println(espresponse);
  if(espresponse.length()==0)
    Serial.println("Please, push the  ESP B/L button on the board and plug the USB cable before run the sketch");
  else{
    //In according to the SLIP protocol, here the parsing of the ESP8266 response
    int pos1= espresponse.lastIndexOf("c01a20");
    mac=String(espresponse.charAt(pos1+8))+String(espresponse.charAt(pos1+9))+":"+String(espresponse.charAt(pos1+6))+String(espresponse.charAt(pos1+7));
    ssid=String(espresponse.charAt(pos1+8))+String(espresponse.charAt(pos1+9))+String(espresponse.charAt(pos1+6))+String(espresponse.charAt(pos1+7));
    String last_char_mac="";
    int dbpos=espresponse.lastIndexOf("db");
    if (dbpos!=-1){
      if(espresponse.length()==32){
        last_char_mac="ff";
      }else{
        if(espresponse.charAt(dbpos+2)=='d' && espresponse.charAt(dbpos+3)=='d'){
          if(espresponse.charAt(dbpos+4)=='0' && espresponse.charAt(dbpos+5)=='0')
            last_char_mac="db";
          else
            last_char_mac=String(espresponse.charAt(dbpos+4)) + String(espresponse.charAt(dbpos+5));
        }
        if(espresponse.charAt(dbpos+2)=='d' && espresponse.charAt(dbpos+3)=='c'){
          if(espresponse.charAt(dbpos+4)=='0' && espresponse.charAt(dbpos+5)=='0')
            last_char_mac=String(espresponse.charAt(dbpos+6)) + String(espresponse.charAt(dbpos+7));
          else
            last_char_mac=String(espresponse.charAt(dbpos+4)) + String(espresponse.charAt(dbpos+5));
        }
      }
    }else{
      if(espresponse.length()==31){
         last_char_mac=String(espresponse.charAt(9))+String(espresponse.charAt(10));
       }else{
         last_char_mac=String(espresponse.charAt(10))+String(espresponse.charAt(11));
       }
    }
    mac+=":" + last_char_mac;
    ssid+=last_char_mac;

    Serial.println("\nMAC:");
    String mac_complete="5c:cf:7f:" + mac;
    Serial.println(mac_complete);

    Serial.println("\nSSID:");
    Serial.println("Arduino-Uno-WiFi-" + ssid);

    Serial.println("You need to replug your board to work with the Wi-Fi");
  }

  while(1);

};
