/*
File: WebServer.ino
This example creates a simple web server on your Arduino Uno WiFi. It serves a
simple web page which shows values of the analog pins, and refreshes every 20 seconds.
Please type on your browser http://<IP>/arduino/webserver/ or http://<hostname>.local/arduino/webserver/

Note: works only with Arduino Uno WiFi Developer Edition.

http://www.arduino.org/learning/tutorials/boards-tutorials/webserver
*/

#include <Wire.h>
#include <UnoWiFiDevEd.h>

void setup() {
  Wifi.begin();
  Wifi.println("Web Server is up");
}
void loop() {

  while(Wifi.available()){
    process(Wifi);
  }
  delay(50);
}

void process(WifiData client) {
  // read the command
  String command = client.readStringUntil('/');

  if (command == "webserver") {
    WebServer(client);
  }
}
void WebServer(WifiData client) {
  client.println("HTTP/1.1 200 OK");
  client.println("Content-Type: text/html");
  client.println("Connection: close");
  client.println("Refresh: 20");  // refresh the page automatically every  sec
  client.println();
  client.println("<html>");
  client.println("<head> <title>UNO WIFI Example</title> </head>");
  client.print("<body>");

  for(int analogChannel = 0; analogChannel < 4; analogChannel++) {
    int sensorReading = analogRead(analogChannel);
    client.print("analog input ");
    client.print(analogChannel);
    client.print(" is ");
    client.print(sensorReading);
    client.print("<br/>");
  }

  client.print("</body>");
  client.println("</html>");
  client.print(DELIMITER); // very important to end the communication !!!
}
