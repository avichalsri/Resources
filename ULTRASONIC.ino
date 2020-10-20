int trigpin=9;
int echopin=10;
long dur;
int dis;
int trigpin2=5;
int echopin2=6;
long dur2;
int dis2;
void setup(){
  pinMode(trigpin,OUTPUT);
  pinMode(echopin,INPUT);  
   pinMode(trigpin2,OUTPUT);
  pinMode(echopin2,INPUT);
Serial.begin(9600);}
void loop(){
 digitalWrite(trigpin,LOW);
  delayMicroseconds(2);
  digitalWrite(trigpin,HIGH);
  dur = pulseIn (echopin,HIGH);
dis =(dur*0.034)/2;
Serial
Serial.println(dis);
 digitalWrite(trigpin2,LOW);
  delayMicroseconds(2);
 digitalWrite(trigpin2,HIGH);
  dur2 = pulseIn (echopin2,HIGH);
dis2 =(dur2*0.034)/2;
Serial.println("dis2");
Serial.println(dis2);
}
