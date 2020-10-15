/*
Description:
This is a example code for Sandbox Electronics' I2C/SPI to UART bridge module.
You can get one of those products on
http://sandboxelectronics.com

Version:
V0.1

Release Date:
2014-02-16

Author:
Tiequan Shao          info@sandboxelectronics.com

Lisence:
CC BY-NC-SA 3.0

Please keep the above information when you use this code in your project.
*/

#if defined(__AVR_ATmega328P__)

#include "SC16IS750.h"
#include <Wire.h>

#define WIRE Wire

WifiData::WifiData()
{
    device_address_sspin = (SC16IS750_ADDRESS_AA >> 1);
    peek_flag = 0;
}

void WifiData::begin(uint32_t baud)
{

    if ( protocol == SC16IS750_PROTOCOL_I2C) {
        WIRE.begin();
    }
    ResetDevice();
    FIFOEnable(1);
    SetBaudrate(baud);
    SetLine(8,0,1);
}

int WifiData::available(void)
{
    return FIFOAvailableData();
}

int WifiData::read(void)
{
    if ( peek_flag == 0) {
        return ReadByte();
    } else {
        peek_flag = 0;
        return peek_buf;
    }
}

size_t WifiData::write(uint8_t val)
{
    WriteByte(val);
}

void WifiData::pinMode(uint8_t pin, uint8_t i_o)
{
    GPIOSetPinMode(pin, i_o);
}

void WifiData::digitalWrite(uint8_t pin, uint8_t value)
{
    GPIOSetPinState(pin, value);
}

uint8_t WifiData::digitalRead(uint8_t pin)
{
   return GPIOGetPinState(pin);
}


uint8_t WifiData::ReadRegister(uint8_t reg_addr)
{
    uint8_t result = 0;
    if ( protocol == SC16IS750_PROTOCOL_I2C ) {  // register read operation via I2C

        WIRE.beginTransmission(device_address_sspin);
        WIRE.write((reg_addr<<3));
        WIRE.endTransmission(0);
        WIRE.requestFrom(device_address_sspin,(uint8_t)1);
        result = WIRE.read();
    }

    return result;

}

void WifiData::WriteRegister(uint8_t reg_addr, uint8_t val)
{
    if ( protocol == SC16IS750_PROTOCOL_I2C ) {  // register read operation via I2C
        WIRE.beginTransmission(device_address_sspin);
        WIRE.write((reg_addr<<3));
        WIRE.write(val);
        WIRE.endTransmission(1);
    }


    return ;
}

int16_t WifiData::SetBaudrate(uint32_t baudrate) //return error of baudrate parts per thousand
{
    uint16_t divisor;
    uint8_t prescaler;
    uint32_t actual_baudrate;
    int16_t error;
    uint8_t temp_lcr;
    if ( (ReadRegister(SC16IS750_REG_MCR)&0x80) == 0) { //if prescaler==1
        prescaler = 1;
    } else {
        prescaler = 4;
    }

    divisor = (SC16IS750_CRYSTCAL_FREQ/prescaler)/(baudrate*16);

    temp_lcr = ReadRegister(SC16IS750_REG_LCR);
    temp_lcr |= 0x80;
    WriteRegister(SC16IS750_REG_LCR,temp_lcr);
    //write to DLL
    WriteRegister(SC16IS750_REG_DLL,(uint8_t)divisor);
    //write to DLH
    WriteRegister(SC16IS750_REG_DLH,(uint8_t)(divisor>>8));
    temp_lcr &= 0x7F;
    WriteRegister(SC16IS750_REG_LCR,temp_lcr);


    actual_baudrate = (SC16IS750_CRYSTCAL_FREQ/prescaler)/(16*divisor);
    error = ((float)actual_baudrate-baudrate)*1000/baudrate;

    return error;

}

void WifiData::SetLine(uint8_t data_length, uint8_t parity_select, uint8_t stop_length )
{
    uint8_t temp_lcr;
    temp_lcr = ReadRegister(SC16IS750_REG_LCR);
    temp_lcr &= 0xC0; //Clear the lower six bit of LCR (LCR[0] to LCR[5]

    switch (data_length) {            //data length settings
        case 5:
            break;
        case 6:
            temp_lcr |= 0x01;
            break;
        case 7:
            temp_lcr |= 0x02;
            break;
        case 8:
            temp_lcr |= 0x03;
            break;
        default:
            temp_lcr |= 0x03;
            break;
    }

    if ( stop_length == 2 ) {
        temp_lcr |= 0x04;
    }

    switch (parity_select) {            //parity selection length settings
        case 0:                         //no parity
             break;
        case 1:                         //odd parity
            temp_lcr |= 0x08;
            break;
        case 2:                         //even parity
            temp_lcr |= 0x18;
            break;
        case 3:                         //force '1' parity
            temp_lcr |= 0x03;
            break;
        case 4:                         //force '0' parity
            break;
        default:
            break;
    }

    WriteRegister(SC16IS750_REG_LCR,temp_lcr);
}

void WifiData::GPIOSetPinMode(uint8_t pin_number, uint8_t i_o)
{
    uint8_t temp_iodir;

    temp_iodir = ReadRegister(SC16IS750_REG_IODIR);
    if ( i_o == OUTPUT ) {
      temp_iodir |= (0x01 << pin_number);
    } else {
      temp_iodir &= (uint8_t)~(0x01 << pin_number);
    }

    WriteRegister(SC16IS750_REG_IODIR, temp_iodir);
    return;
}

void WifiData::GPIOSetPinState(uint8_t pin_number, uint8_t pin_state)
{
    uint8_t temp_iostate;

    temp_iostate = ReadRegister(SC16IS750_REG_IOSTATE);
    if ( pin_state == 1 ) {
      temp_iostate |= (0x01 << pin_number);
    } else {
      temp_iostate &= (uint8_t)~(0x01 << pin_number);
    }

    WriteRegister(SC16IS750_REG_IOSTATE, temp_iostate);
    return;
}


uint8_t WifiData::GPIOGetPinState(uint8_t pin_number)
{
    uint8_t temp_iostate;

    temp_iostate = ReadRegister(SC16IS750_REG_IOSTATE);
    if ( (temp_iostate) & ((0x01 << pin_number)== 0) ) {
      return 0;
    }
    return 1;
}

uint8_t WifiData::GPIOGetPortState(void)
{

    return ReadRegister(SC16IS750_REG_IOSTATE);

}

void WifiData::GPIOSetPortMode(uint8_t port_io)
{
    WriteRegister(SC16IS750_REG_IODIR, port_io);
    return;
}

void WifiData::GPIOSetPortState(uint8_t port_state)
{
    WriteRegister(SC16IS750_REG_IOSTATE, port_state);
    return;
}

void WifiData::SetPinInterrupt(uint8_t io_int_ena)
{
    WriteRegister(SC16IS750_REG_IOINTENA, io_int_ena);
    return;
}

void WifiData::ResetDevice(void)
{
    uint8_t reg;

    reg = ReadRegister(SC16IS750_REG_IOCONTROL);
    reg |= 0x08;
    WriteRegister(SC16IS750_REG_IOCONTROL, reg);

    return;
}

void WifiData::ModemPin(uint8_t gpio) //gpio == 0, gpio[7:4] are modem pins, gpio == 1 gpio[7:4] are gpios
{
    uint8_t temp_iocontrol;

    temp_iocontrol = ReadRegister(SC16IS750_REG_IOCONTROL);
    if ( gpio == 0 ) {
        temp_iocontrol |= 0x02;
    } else {
        temp_iocontrol &= 0xFD;
    }
    WriteRegister(SC16IS750_REG_IOCONTROL, temp_iocontrol);

    return;
}

void WifiData::GPIOLatch(uint8_t latch)
{
    uint8_t temp_iocontrol;

    temp_iocontrol = ReadRegister(SC16IS750_REG_IOCONTROL);
    if ( latch == 0 ) {
        temp_iocontrol &= 0xFE;
    } else {
        temp_iocontrol |= 0x01;
    }
    WriteRegister(SC16IS750_REG_IOCONTROL, temp_iocontrol);

    return;
}

void WifiData::InterruptControl(uint8_t int_ena)
{
    WriteRegister(SC16IS750_REG_IER, int_ena);
}

uint8_t WifiData::InterruptPendingTest(void)
{
    return (ReadRegister(SC16IS750_REG_IIR) & 0x01);
}

void WifiData::__isr(void)
{
    uint8_t irq_src;

    irq_src = ReadRegister(SC16IS750_REG_IIR);
    irq_src = (irq_src >> 1);
    irq_src &= 0x3F;

    switch (irq_src) {
        case 0x06:                  //Receiver Line Status Error
            break;
        case 0x0c:               //Receiver time-out interrupt
            break;
        case 0x04:               //RHR interrupt
            break;
        case 0x02:               //THR interrupt
            break;
        case 0x00:                  //modem interrupt;
            break;
        case 0x30:                  //input pin change of state
            break;
        case 0x10:                  //XOFF
            break;
        case 0x20:                  //CTS,RTS
            break;
        default:
            break;
    }
    return;
}

void WifiData::FIFOEnable(uint8_t fifo_enable)
{
    uint8_t temp_fcr;

    temp_fcr = ReadRegister(SC16IS750_REG_FCR);

    if (fifo_enable == 0){
        temp_fcr &= 0xFE;
    } else {
        temp_fcr |= 0x01;
    }
    WriteRegister(SC16IS750_REG_FCR,temp_fcr);

    return;
}

void WifiData::FIFOReset(uint8_t rx_fifo)
{
     uint8_t temp_fcr;

    temp_fcr = ReadRegister(SC16IS750_REG_FCR);

    if (rx_fifo == 0){
        temp_fcr |= 0x04;
    } else {
        temp_fcr |= 0x02;
    }
    WriteRegister(SC16IS750_REG_FCR,temp_fcr);

    return;

}

void WifiData::FIFOSetTriggerLevel(uint8_t rx_fifo, uint8_t length)
{
    uint8_t temp_reg;

    temp_reg = ReadRegister(SC16IS750_REG_MCR);
    temp_reg |= 0x04;
    WriteRegister(SC16IS750_REG_MCR,temp_reg); //SET MCR[2] to '1' to use TLR register or trigger level control in FCR register

    temp_reg = ReadRegister(SC16IS750_REG_EFR);
    WriteRegister(SC16IS750_REG_EFR, temp_reg|0x10); //set ERF[4] to '1' to use the  enhanced features
    if (rx_fifo == 0) {
        WriteRegister(SC16IS750_REG_TLR, length<<4); //Tx FIFO trigger level setting
    } else {
        WriteRegister(SC16IS750_REG_TLR, length);    //Rx FIFO Trigger level setting
    }
    WriteRegister(SC16IS750_REG_EFR, temp_reg); //restore EFR register

    return;
}

uint8_t WifiData::FIFOAvailableData(void)
{
   return ReadRegister(SC16IS750_REG_RXLVL);

}

uint8_t WifiData::FIFOAvailableSpace(void)
{
   return ReadRegister(SC16IS750_REG_TXLVL);

}

void WifiData::WriteByte(uint8_t val)
{
    uint8_t tmp_lsr;
    do {
        tmp_lsr = ReadRegister(SC16IS750_REG_LSR);
    } while ((tmp_lsr&0x20) ==0);

    WriteRegister(SC16IS750_REG_THR,val);

}

int WifiData::ReadByte(void)
{
    volatile uint8_t val;
    if (FIFOAvailableData() == 0) {

        return -1;

    } else {

      val = ReadRegister(SC16IS750_REG_RHR);
      return val;
    }

}

void WifiData::EnableTransmit(uint8_t tx_enable)
{
    uint8_t temp_efcr;
    temp_efcr = ReadRegister(SC16IS750_REG_EFCR);
    if ( tx_enable == 0) {
        temp_efcr |= 0x04;
    } else {
        temp_efcr &= 0xFB;
    }
    WriteRegister(SC16IS750_REG_EFCR,temp_efcr);

    return;
}

uint8_t WifiData::ping()
{
    WriteRegister(SC16IS750_REG_SPR,0x55);
    if (ReadRegister(SC16IS750_REG_SPR) !=0x55) {
        return 0;
    }

    WriteRegister(SC16IS750_REG_SPR,0xAA);
    if (ReadRegister(SC16IS750_REG_SPR) !=0xAA) {
        return 0;
    }

    return 1;

}

void WifiData::flush()
{
    uint8_t tmp_lsr;

    do {
        tmp_lsr = ReadRegister(SC16IS750_REG_LSR);
    } while ((tmp_lsr&0x20) ==0);


}

int WifiData::peek()
{
    if ( peek_flag == 0 ) {
        peek_buf =ReadByte();
        if (  peek_buf >= 0 ) {
            peek_flag = 1;
        }
    }

    return peek_buf;

}

#endif
