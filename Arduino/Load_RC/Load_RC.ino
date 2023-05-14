#include <Servo.h>

int L=2;
int R=3;
int Speed=150;
Servo ms;
bool loadState=false;


void setup() {
  Serial.begin(9600);
  pinMode(13,OUTPUT); // Right Backwards
  pinMode(12,OUTPUT); // Left Backwards
  pinMode(11,OUTPUT); // Left forward
  pinMode(10,OUTPUT); // Right Forward
  pinMode(L,INPUT);
  pinMode(R,INPUT);
  ms.attach(1);
}

void uturn() {
  digitalWrite(10,HIGH);
  digitalWrite(12,HIGH);
  delay(1500);
  stop();
}

void stop() {
  digitalWrite(13,LOW);
  digitalWrite(12,LOW);
  digitalWrite(11,LOW);
  digitalWrite(10,LOW);
}


void loop() {
  // without detector
  int L1 = analogRead(A0);
  Serial.println(L1);
  if(loadState)
  {
  analogWrite(10, Speed);
  analogWrite(11, Speed);
  delay(2000);
  ms.write(90);
  delay(1000);
  ms.write(0);
  uturn();
  analogWrite(10, Speed);
  analogWrite(11, Speed);
  delay(2000);
  uturn();
  loadState=false;
  }
  else if(L1<30)
      loadState=true;

  // with detector
  /*
  if(digitalRead(L) && digitalRead(R))
  {
    digitalWrite(10,LOW);
    digitalWrite(11,LOW);
    delay(2000);
  }
  else if (digitalRead(R))
  {
    digitalWrite(11, LOW);
    analogWrite(10, Speed);
  }
  else if (digitalRead(L))
  {
    digitalWrite(10,LOW);
    analogWrite(11, Speed);
  }
  else
  {
    analogWrite(10, Speed);
    analogWrite(11, Speed);
  }
  */

}
