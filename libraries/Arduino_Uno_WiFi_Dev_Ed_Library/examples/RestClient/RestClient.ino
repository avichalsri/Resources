/*
File: RestClient.ino
This example makes an HTTP request after 10 seconds and shows the result both in
serial monitor and in the wifi console of the Arduino Uno WiFi.

Note: works only with Arduino Uno WiFi Developer Edition.

http://www.arduino.org/learning/tutorials/boards-tutorials/restserver-and-restclient
*/

#include <Wire.h>
#include <UnoWiFiDevEd.h>

void setup() {

	const char* connector = "rest";
	const char* server = "download.arduino.org";
	const char* method = "GET";
	const char* resource = "/latest.txt";

	Serial.begin(9600);
	Ciao.begin();

	pinMode(2, INPUT);

	delay(10000);
	doRequest(connector, server, resource, method);
}

void loop() {

}

void doRequest(const char* conn, const char* server, const char* command, const char* method){
	CiaoData data = Ciao.write(conn, server, command, method);
	if (!data.isEmpty()){
		Ciao.println( "State: " + String (data.get(1)) );
		Ciao.println( "Response: " + String (data.get(2)) );
		Serial.println( "State: " + String (data.get(1)) );
		Serial.println( "Response: " + String (data.get(2)) );
	}
	else{
		Ciao.println ("Write Error");
		Serial.println ("Write Error");
	}
}
