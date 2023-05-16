#include <Servo.h>

Servo ms;
int p = 1;
bool e = false;
bool s = false;
int beep = 12;

void setup() {
  Serial.begin(9600);
  pinMode(2,OUTPUT);
  pinMode(3,OUTPUT);
  pinMode(4,OUTPUT);
  pinMode(5,OUTPUT);
  pinMode(8,OUTPUT);
  pinMode(9,OUTPUT);
  pinMode(10,OUTPUT);
  pinMode(11,OUTPUT);
  pinMode(13,INPUT);
  pinMode(beep,OUTPUT);
  //mario();
  ms.attach(7);
  ms.write(0);
}

void ouvrir(int v) {
  ms.write(90);
  if(v==1)
    {e=true;}
  else
    {s=true;}
}

void fermer(int v) {
  ms.write(0);
  p=p+v;
  e=false;
  s=false;
}

void number(int v) {
  switch(v) {
  case 0 :
  digitalWrite(2,LOW);
  digitalWrite(3,LOW);
  digitalWrite(4,LOW);
  digitalWrite(5,HIGH);
  digitalWrite(8,LOW);
  digitalWrite(9,LOW);
  digitalWrite(10,LOW);
  break;
  case 1 :
  digitalWrite(2,LOW);
  digitalWrite(3,HIGH);
  digitalWrite(4,HIGH);
  digitalWrite(5,HIGH);
  digitalWrite(8,HIGH);
  digitalWrite(9,LOW);
  digitalWrite(10,HIGH);
  break;
  case 2 :
  digitalWrite(2,LOW);
  digitalWrite(3,LOW);
  digitalWrite(4,HIGH);
  digitalWrite(5,LOW);
  digitalWrite(8,LOW);
  digitalWrite(9,HIGH);
  digitalWrite(10,LOW);
  break;
  case 3 :
  digitalWrite(2,LOW);
  digitalWrite(3,LOW);
  digitalWrite(4,HIGH);
  digitalWrite(5,LOW);
  digitalWrite(8,HIGH);
  digitalWrite(9,LOW);
  digitalWrite(10,LOW);
  break;
  case 4 :
  digitalWrite(2,LOW);
  digitalWrite(3,HIGH);
  digitalWrite(4,LOW);
  digitalWrite(5,LOW);
  digitalWrite(8,HIGH);
  digitalWrite(9,LOW);
  digitalWrite(10,HIGH);
  break;
  case 5 :
  digitalWrite(2,HIGH);
  digitalWrite(3,LOW);
  digitalWrite(4,LOW);
  digitalWrite(5,LOW);
  digitalWrite(8,HIGH);
  digitalWrite(9,LOW);
  digitalWrite(10,LOW);
  break;
  case 6 :
  digitalWrite(2,HIGH);
  digitalWrite(3,LOW);
  digitalWrite(4,LOW);
  digitalWrite(5,LOW);
  digitalWrite(8,LOW);
  digitalWrite(9,LOW);
  digitalWrite(10,LOW);
  break;
  case 7 :
  digitalWrite(2,LOW);
  digitalWrite(3,LOW);
  digitalWrite(4,HIGH);
  digitalWrite(5,HIGH);
  digitalWrite(8,HIGH);
  digitalWrite(9,LOW);
  digitalWrite(10,HIGH);
  break;
  case 8 :
  digitalWrite(2,LOW);
  digitalWrite(3,LOW);
  digitalWrite(4,LOW);
  digitalWrite(5,LOW);
  digitalWrite(8,LOW);
  digitalWrite(9,LOW);
  digitalWrite(10,LOW);
  break;
  case 9 :
  digitalWrite(2,LOW);
  digitalWrite(3,LOW);
  digitalWrite(4,LOW);
  digitalWrite(5,LOW);
  digitalWrite(8,HIGH);
  digitalWrite(9,LOW);
  digitalWrite(10,LOW);
  break;

}
}

void mario() {
tone(beep,660,100);
delay(150);
tone(beep,660,100);
delay(300);
tone(beep,660,100);
delay(300);
tone(beep,510,100);
delay(100);
tone(beep,660,100);
delay(300);
tone(beep,770,100);
delay(550);
tone(beep,380,100);
delay(575);

tone(beep,510,100);
delay(450);
tone(beep,380,100);
delay(400);
tone(beep,320,100);
delay(500);
tone(beep,440,100);
delay(300);
tone(beep,480,80);
delay(330);
tone(beep,450,100);
delay(150);
tone(beep,430,100);
delay(300);
tone(beep,380,100);
delay(200);
tone(beep,660,80);
delay(200);
tone(beep,760,50);
delay(150);
tone(beep,860,100);
delay(300);
tone(beep,700,80);
delay(150);
tone(beep,760,50);
delay(350);
tone(beep,660,80);
delay(300);
tone(beep,520,80);
delay(150);
tone(beep,580,80);
delay(150);
tone(beep,480,80);
delay(500);

tone(beep,510,100);
delay(450);
tone(beep,380,100);
delay(400);
tone(beep,320,100);
delay(500);
tone(beep,440,100);
delay(300);
tone(beep,480,80);
delay(330);
tone(beep,450,100);
delay(150);
tone(beep,430,100);
delay(300);
tone(beep,380,100);
delay(200);
tone(beep,660,80);
delay(200);
tone(beep,760,50);
delay(150);
tone(beep,860,100);
delay(300);
tone(beep,700,80);
delay(150);
tone(beep,760,50);
delay(350);
tone(beep,660,80);
delay(300);
tone(beep,520,80);
delay(150);
tone(beep,580,80);
delay(150);
tone(beep,480,80);
delay(500);

tone(beep,500,100);
delay(300);

tone(beep,760,100);
delay(100);
tone(beep,720,100);
delay(150);
tone(beep,680,100);
delay(150);
tone(beep,620,150);
delay(300);

tone(beep,650,150);
delay(300);
tone(beep,380,100);
delay(150);
tone(beep,430,100);
delay(150);

tone(beep,500,100);
delay(300);
tone(beep,430,100);
delay(150);
tone(beep,500,100);
delay(100);
tone(beep,570,100);
delay(220);

tone(beep,500,100);
delay(300);

tone(beep,760,100);
delay(100);
tone(beep,720,100);
delay(150);
tone(beep,680,100);
delay(150);
tone(beep,620,150);
delay(300);

tone(beep,650,200);
delay(300);

tone(beep,1020,80);
delay(300);
tone(beep,1020,80);
delay(150);
tone(beep,1020,80);
delay(300);

tone(beep,380,100);
delay(300);
tone(beep,500,100);
delay(300);

tone(beep,760,100);
delay(100);
tone(beep,720,100);
delay(150);
tone(beep,680,100);
delay(150);
tone(beep,620,150);
delay(300);

tone(beep,650,150);
delay(300);
tone(beep,380,100);
delay(150);
tone(beep,430,100);
delay(150);

tone(beep,500,100);
delay(300);
tone(beep,430,100);
delay(150);
tone(beep,500,100);
delay(100);
tone(beep,570,100);
delay(420);

tone(beep,585,100);
delay(450);

tone(beep,550,100);
delay(420);

tone(beep,500,100);
delay(360);

tone(beep,380,100);
delay(300);
tone(beep,500,100);
delay(300);
tone(beep,500,100);
delay(150);
tone(beep,500,100);
delay(300);

tone(beep,500,100);
delay(300);

tone(beep,760,100);
delay(100);
tone(beep,720,100);
delay(150);
tone(beep,680,100);
delay(150);
tone(beep,620,150);
delay(300);

tone(beep,650,150);
delay(300);
tone(beep,380,100);
delay(150);
tone(beep,430,100);
delay(150);

tone(beep,500,100);
delay(300);
tone(beep,430,100);
delay(150);
tone(beep,500,100);
delay(100);
tone(beep,570,100);
delay(220);

tone(beep,500,100);
delay(300);

tone(beep,760,100);
delay(100);
tone(beep,720,100);
delay(150);
tone(beep,680,100);
delay(150);
tone(beep,620,150);
delay(300);

tone(beep,650,200);
delay(300);

tone(beep,1020,80);
delay(300);
tone(beep,1020,80);
delay(150);
tone(beep,1020,80);
delay(300);

tone(beep,380,100);
delay(300);
tone(beep,500,100);
delay(300);

tone(beep,760,100);
delay(100);
tone(beep,720,100);
delay(150);
tone(beep,680,100);
delay(150);
tone(beep,620,150);
delay(300);

tone(beep,650,150);
delay(300);
tone(beep,380,100);
delay(150);
tone(beep,430,100);
delay(150);

tone(beep,500,100);
delay(300);
tone(beep,430,100);
delay(150);
tone(beep,500,100);
delay(100);
tone(beep,570,100);
delay(420);

tone(beep,585,100);
delay(450);

tone(beep,550,100);
delay(420);

tone(beep,500,100);
delay(360);

tone(beep,380,100);
delay(300);
tone(beep,500,100);
delay(300);
tone(beep,500,100);
delay(150);
tone(beep,500,100);
delay(300);

tone(beep,500,60);
delay(150);
tone(beep,500,80);
delay(300);
tone(beep,500,60);
delay(350);
tone(beep,500,80);
delay(150);
tone(beep,580,80);
delay(350);
tone(beep,660,80);
delay(150);
tone(beep,500,80);
delay(300);
tone(beep,430,80);
delay(150);
tone(beep,380,80);
delay(600);

tone(beep,500,60);
delay(150);
tone(beep,500,80);
delay(300);
tone(beep,500,60);
delay(350);
tone(beep,500,80);
delay(150);
tone(beep,580,80);
delay(150);
tone(beep,660,80);
delay(550);

tone(beep,870,80);
delay(325);
tone(beep,760,80);
delay(600);

tone(beep,500,60);
delay(150);
tone(beep,500,80);
delay(300);
tone(beep,500,60);
delay(350);
tone(beep,500,80);
delay(150);
tone(beep,580,80);
delay(350);
tone(beep,660,80);
delay(150);
tone(beep,500,80);
delay(300);
tone(beep,430,80);
delay(150);
tone(beep,380,80);
delay(600);

tone(beep,660,100);
delay(150);
tone(beep,660,100);
delay(300);
tone(beep,660,100);
delay(300);
tone(beep,510,100);
delay(100);
tone(beep,660,100);
delay(300);
tone(beep,770,100);
delay(550);
tone(beep,380,100);
delay(575);
}

void loop() {

  int L1 = analogRead(A0);
  int L2 = analogRead(A1);
  
  if(digitalRead(13))
    {
      ms.write(90);
      delay(3000);
      ms.write(0);
    }

if (e)
{
  if(L2<30)
  {
  fermer(-1);
  //delay(1000);
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
else if(p==0 && L1<30)
{
  tone(beep,380,50);
}

delay(500);
Serial.println(p);
number(p);
Serial.print(L1);
Serial.print("  -  ");
Serial.println(L2);
Serial.print("E: ");
Serial.print(e);
Serial.print("  -  S: ");
Serial.println(s);

}
