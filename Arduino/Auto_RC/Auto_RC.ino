int L=2;
int R=3;
int Speed=150;

bool loadState=false;


void setup() {
  Serial.begin(9600);
  pinMode(13,OUTPUT); // Right Backwards
  pinMode(12,OUTPUT); // Left Backwards
  pinMode(10,OUTPUT); // Right Forward
  pinMode(11,OUTPUT); // Left forward
  pinMode(L,INPUT);
  pinMode(R,INPUT);
}

void uturn() {

}


void loop() {
  // without detector
  if(loadState)
  {
  analogWrite(10, Speed);
  analogWrite(11, Speed);
  delay(2000);
  }
  else if ()

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
  */}
}
