/*
File: MqttPub.ino

This example simply publishes analog data into a MQTT topic. Before use it,
please configure the MQTT server address via Uno WiFi Web Panel. Topics are
automatically created (or subscribed) via api calls into the sketch. You can use
a maximum of 3 topics.

Note: works only with Arduino Uno WiFi Developer Edition.
*/

#include <Wire.h>
#include <UnoWiFiDevEd.h>

#define CONNECTOR "mqtt"
#define TOPIC "arduino/analog/A1"

void setup() {
	Ciao.begin();
}


void loop(){

	delay(5000);
	int data_value = analogRead(A1); // data value from analog pin 1
	Ciao.write(CONNECTOR, TOPIC, String(data_value)); // pushes data into a channel called PIN_A1

}
