/*
****************************************************************************
* Copyright (c) 2015 Arduino srl. All right reserved.
*
* File : CiaoData.h
* Date : 2016/02/16
* Author: andrea[at]arduino[dot]org - rev. 0.0.2
*
* Modified: 02 Feb 2017 - sergio@arduino.org - rev. 0.0.3
*
* Revision: 0.0.3
*
****************************************************************************

  This library is free software; you can redistribute it and/or
  modify it under the terms of the GNU Lesser General Public
  License as published by the Free Software Foundation; either
  version 2.1 of the License, or (at your option) any later version.

  This library is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
  Lesser General Public License for more details.

  You should have received a copy of the GNU Lesser General Public
  License along with this library; if not, write to the Free Software
  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
*/

#include <Arduino.h>

#define ID_ERROR		String(-1)
#define ID_EMPTY		String(0)
#define ID_READY		String(1)
#define END_TX_CHAR		(char)4
#define DATA_SPLIT_CHAR	(char)30
#define ID_SIZE_TX		25

class CiaoData {
	public:

		const char* msg_split[3];

		const char* get(int index){
			return msg_split[index];
		}

		bool isEmpty(){
			//if (atoi( get(1) ) > 0)
			//if (get(2) != "")
			if ( strncmp(get(2), "", 1) != 0)
				return false;
			else
				return true;
		}
};
