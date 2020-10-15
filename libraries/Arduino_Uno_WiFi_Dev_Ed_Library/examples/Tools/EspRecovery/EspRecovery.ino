#include <Wire.h>
#include <UnoWiFiDevEd.h>

#define BAUD 9600
WifiData ESPSerial;

void setup()
{
  Serial.begin(BAUD);
  pinMode(13, OUTPUT);
  digitalWrite(13, LOW);

  ESPSerial.begin(BAUD);
}

void loop()
{
  while (Serial.available()) {
    char inChar = (char)Serial.read();
    ESPSerial.write(inChar);
  }

  while (ESPSerial.available()) {
    char inChar = (char)ESPSerial.read();
    Serial.write(inChar);
  }

}
