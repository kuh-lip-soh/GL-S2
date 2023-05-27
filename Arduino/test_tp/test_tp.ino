#include <Servo.h>

int red = 12;
int green = 13;

Servo ms;

int btn1 = 9;
int btn2 = 8;
int btn3 = 7;
int btn4 = 6;

int btnState1 = LOW;
int btnState2 = LOW;
int btnState3 = LOW;
int btnState4 = LOW;

int beep = 10;

int pw[6]={1,2,3,3,1};
int i=0;
int t[50];

void setup() {
  Serial.begin(9600);
  pinMode(red, OUTPUT);
  pinMode(green, OUTPUT);
  pinMode(btn1, INPUT);
  pinMode(btn2, INPUT);
  pinMode(btn3, INPUT);
  pinMode(btn4, INPUT);
  pinMode(beep, OUTPUT);
  ms.attach(3);
  ms.write(0);
}

void test() {
  digitalWrite(red, HIGH);
  digitalWrite(green, HIGH);
  tone(beep,500);
  delay(100);
  noTone(beep);
  digitalWrite(red, LOW);
  digitalWrite(green, LOW);
}

void validate() {
  int k = 0;
  for(k; t[k]!=0; k++) //length ta3 wish
  if(k>5)
    {
      Vfalse();
      return;
    }

  for(int j=0; j<5; j++) {
    if(pw[j]!=t[j])
      {
        Vfalse();
        return;
      }
  }
  Vtrue();
  return;
}
void Vdelete()
 {
   for(int i=0; i<6; i++)
    t[i]=0;
 }

void Vfalse() {
  Vdelete();
  digitalWrite(red, HIGH);
  tone(beep,850);
  delay(2000);
  noTone(beep);
  digitalWrite(red, LOW);
  t[5]=0;
}

void Vtrue() {
  Vdelete();
  digitalWrite(green, HIGH);
  ms.write(90);
  delay(4000);
  ms.write(0);
  digitalWrite(green, LOW);
}

void loop() {

if (digitalRead(btn1) != btnState1) {
    if (digitalRead(btn1) == HIGH) {
      tone(beep,550,50);
      t[i]=1;
      i++;
      Serial.println("1 appuyé");
    } else {
      Serial.println("1 relâché");
    }
    btnState1 = digitalRead(btn1);
  }

if (digitalRead(btn2) != btnState2) {
    if (digitalRead(btn2) == HIGH) {
      tone(beep,550,50);
      t[i]=2;
      i++;
      Serial.println("2 appuyé");
    } else {
      Serial.println("2 relâché");
    }
    btnState2 = digitalRead(btn2);
  }

if (digitalRead(btn3) != btnState3) {
    if (digitalRead(btn3) == HIGH) {
      tone(beep,550,50);
      t[i]=3;
      i++;
      Serial.println("3 appuyé");
    } else {
      Serial.println("3 relâché");
    }
    btnState3 = digitalRead(btn3);
  }

if (digitalRead(btn4) != btnState4) {
    if (digitalRead(btn4) == HIGH) {
      tone(beep,650,100);
      validate();
      i=0;
      Serial.println("4 appuyé");
    } else {
      Serial.println("4 relâché");
    }
    btnState4 = digitalRead(btn4);
  }

if(analogRead(A0)<10) {
  i=0;
  Vdelete();
  tone(beep,350,100);
}

}
