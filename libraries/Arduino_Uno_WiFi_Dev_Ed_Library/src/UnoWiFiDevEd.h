#if defined(__AVR_ATmega328P__)
#ifndef UNOWIFI_DEVED_H_
#define UNOWIFI_DEVED_H_

#include <Arduino.h>

#include <Stream.h>
#include "lib/crc16.h"
#include "lib/rest.h"
#include "lib/mqtt.h"
#include "lib/espduino.h"
#include "lib/ringbuf.h"
#include "lib/FP.h"
#include "lib/SC16IS750.h"
#include "lib/CiaoData.h"
#include <string.h>

class ArduinoWifiClass : public WifiData
{

	public:
		void begin();
		boolean connected();
		void connect(char* , char*);
		
};

class CiaoClass : public WifiData
{
	public:
		void begin();
		CiaoData read( const char* connector, const char* hostname, const char* data, const char* method = "GET");
		CiaoData write( const char* connector, const char* hostname, const char* data, const char* method = "GET");

		CiaoData read( const char* connector, const char* hostname, String data, String method = "GET");
		CiaoData write( const char* connector, const char* hostname, String data, String method = "GET");

		CiaoData read( const char* connector, const char* hostname){
			return read(connector, hostname, "", "GET");
		}
		CiaoData write( const char* connector, const char* hostname){
			return write(connector, hostname, "", "GET");
		}

		CiaoData read( String connector, String hostname){
			return read(connector.c_str(), hostname.c_str(), "", "GET");
		}
		CiaoData write( String connector, String hostname){
			return write(connector.c_str(), hostname.c_str(), "", "GET");
		}
};



extern CiaoClass Ciao;
extern ArduinoWifiClass Wifi;

#endif

#endif /* WIFI_H_ */
