/*
File: MqttPub.ino

This example subscribes a MQTT channel and reads published data, then prints it
into the serial monitor. Please configure the MQTT server address via Uno WiFi
Web Panel. Topics are automatically created (or subscribed) via api calls into
the sketch. You can use a maximum of 3 topics.

Note: works only with Arduino Uno WiFi Developer Edition.
*/

#include <Wire.h>
#include <UnoWiFiDevEd.h>

#define CONNECTOR "mqtt"
#define TOPIC "arduino/data"

void setup() {
	Ciao.begin();
	Serial.begin(9600);
}

void loop(){
	CiaoData data = Ciao.read(CONNECTOR, TOPIC);
	if (!data.isEmpty()){
		const char* value = data.get(2);
		Serial.println(value);
	}
}
