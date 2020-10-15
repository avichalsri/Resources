/*
File: RestServer.ino
This example for the Arduino Uno WiFi shows how to access the digital and analog pins
of the board through REST calls. It demonstrates how you can create your own API using
REST style.

Possible commands created in this shetch:

	"/arduino/digital/13"     -> digitalRead(13)
	"/arduino/digital/13/1"   -> digitalWrite(13, HIGH)
	"/arduino/analog/2/123"   -> analogWrite(2, 123)
	"/arduino/analog/2"       -> analogRead(2)
	"/arduino/mode/13/input"  -> pinMode(13, INPUT)
	"/arduino/mode/13/output" -> pinMode(13, OUTPUT)

This example code is part of the public domain

Note: works only with Arduino Uno WiFi Developer Edition.

http://www.arduino.org/learning/tutorials/boards-tutorials/restserver-and-restclient
*/

#include <Wire.h>
#include <UnoWiFiDevEd.h>


void setup() {
    Wifi.begin();
    Wifi.println("REST Server is up");
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

  // is "digital" command?
  if (command == "digital") {
    digitalCommand(client);
  }

  // is "analog" command?
  if (command == "analog") {
    analogCommand(client);
  }

  // is "mode" command?
  if (command == "mode") {
    modeCommand(client);
  }
}

void digitalCommand(WifiData client) {
  int pin, value;

  // Read pin number
  pin = client.parseInt();

  // If the next character is a '/' it means we have an URL
  // with a value like: "/digital/13/1"
  if (client.read() == '/') {
    value = client.parseInt();
    digitalWrite(pin, value);
  }
  else {
    value = digitalRead(pin);
  }

  // Send feedback to client
  client.println("HTTP/1.1 200 OK\n");
  client.print(F("Pin D"));
  client.print(pin);
  client.print(F(" set to "));
  client.println(value);
  client.print(EOL);    //char terminator

}

void analogCommand(WifiData client) {
  int pin, value;

  // Read pin number
  pin = client.parseInt();

  // If the next character is a '/' it means we have an URL
  // with a value like: "/analog/5/120"
  if (client.read() == '/') {
    // Read value and execute command
    value = client.parseInt();
    analogWrite(pin, value);

    // Send feedback to client
    client.println("HTTP/1.1 200 OK\n");
    client.print(F("Pin D"));
    client.print(pin);
    client.print(F(" set to analog "));
    client.println(value);
    client.print(EOL);    //char terminator

  }
  else {
    // Read analog pin
    value = analogRead(pin);

    // Send feedback to client
    client.println("HTTP/1.1 200 OK\n");
    client.print(F("Pin A"));
    client.print(pin);
    client.print(F(" reads analog "));
    client.println(value);
    client.print(EOL);    //char terminator

  }
}

void modeCommand(WifiData client) {
  int pin;

  // Read pin number
  pin = client.parseInt();

  // If the next character is not a '/' we have a malformed URL
  if (client.read() != '/') {
    client.println(F("error"));
    client.print(EOL);    //char terminator
    return;
  }

  String mode = client.readStringUntil('\r');

  if (mode == "input") {
    pinMode(pin, INPUT);
    // Send feedback to client
    client.println("HTTP/1.1 200 OK\n");
    client.print(F("Pin D"));
    client.print(pin);
    client.println(F(" configured as INPUT!"));
    client.print(EOL);    //char terminator
    return;
  }

  if (mode == "output") {
    pinMode(pin, OUTPUT);
    // Send feedback to client
    client.println("HTTP/1.1 200 OK\n");
    client.print(F("Pin D"));
    client.print(pin);
    client.println(F(" configured as OUTPUT!"));
    client.print(EOL);    //char terminator
    return;
  }

  client.print(F("error: invalid mode "));
  client.println(mode);
  client.print(EOL);    //char terminator
}
