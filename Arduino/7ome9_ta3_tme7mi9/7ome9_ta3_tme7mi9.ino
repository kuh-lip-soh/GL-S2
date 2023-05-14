#include <Stepper.h>
#include <Servo.h>



double spr=2048;
int BT1=5;
int BT2=6;
int BT3=7;
int beep=13;
int l=0;

Servo ms;
Stepper s(spr,8,10,9,11);

void setup() {
  Serial.begin(9600);
  s.setSpeed(10);
  pinMode(2,OUTPUT);
  pinMode(3,OUTPUT);
  pinMode(4,OUTPUT);
  pinMode(BT1,INPUT);
  pinMode(BT2,INPUT);
  pinMode(BT3,INPUT);
  pinMode(beep,OUTPUT);
  ms.attach(12);
  ms.write(0);
  number(0);
}

void changeTo(int v)
{
  if(v>l)
  {
    s.step((v-l)*3000);
    update(v);
  }
  else if(v<l)
  {
    s.step((v-l)*2600);
    update(v);
  } 
  else
  {
    tone(beep,100,50);
  }
 
}
void update(int v)
{
  number(v);
  gate();
  l=v; 
}

void number(int v)
{
   switch(v)
{
  case 0 :
  digitalWrite(2,HIGH);
  digitalWrite(3,HIGH);
  digitalWrite(4,LOW);
  break;
  case 1 :
  digitalWrite(2,HIGH);
  digitalWrite(3,LOW);
  digitalWrite(4,HIGH);
  break;
  case 2 :
  digitalWrite(2,LOW);
  digitalWrite(3,HIGH);
  digitalWrite(4,HIGH);
  break;
}
}

void gate()
{
  ms.write(90);
  delay(1000);
  tone(beep,380,50);
  delay(1000);
  tone(beep,380,50);
  delay(1000);
  tone(beep,380,50);
  ms.write(0);
}

void loop() {


if(digitalRead(BT1))
  changeTo(0);
if(digitalRead(BT2))
  changeTo(1);
if(digitalRead(BT3))
  changeTo(2);


/*  
  Serial.print("BT1 ");
  Serial.print(digitalRead(BT1));
  Serial.print("-  BT2 ");
  Serial.print(digitalRead(BT2));
  Serial.print("-  BT3 ");
  Serial.println(digitalRead(BT3));
*/


}
