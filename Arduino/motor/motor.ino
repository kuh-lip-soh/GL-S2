#include <Servo.h>
Servo ms;
int p = 6;
bool e = false;
bool s = false;

void setup() {
  Serial.begin(9600);
  ms.attach(7);
  ms.write(0);
}

void ouvrir(int v){
  ms.write(90);
  if(v==1)
    {e=true;}
  else
    {s=true;}
}

void fermer(int v){
  ms.write(0);
  p=p+v;
  e=false;
  s=false;
}

void loop() {
  int L1 = analogRead(A0);
  int L2 = analogRead(A1);

if (e)
{
  if(L2<30)
  {
  fermer(-1);
 // delay(1000);
  }
}
else if (s)
{
  if(L1<30)
  {
  fermer(1);  
  //delay(1000);
  }
}
else if(L2<30 && p<9)
{
  ouvrir(2);
  //delay(1000);
}
else if(L1<30 && p>0)
{
  ouvrir(1);
  //delay(1000);
}
delay(500);
Serial.println(p);
Serial.print(L1);
Serial.print("  -  ");
Serial.println(L2);
Serial.print("E: ");
Serial.print(e);
Serial.print("  -  S: ");
Serial.println(s);

}
