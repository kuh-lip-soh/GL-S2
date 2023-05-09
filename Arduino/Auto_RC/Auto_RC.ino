int L=2;
int R=3;
int Speed=150;


void setup() {
  Serial.begin(9600);
  pinMode(0,INPUT);
  pinMode(1,OUTPUT);
  pinMode(10,OUTPUT);
  pinMode(11,OUTPUT);
  pinMode(L,INPUT);
  pinMode(R,INPUT);
  send_message("test");
}

void send_message(String s)
{
  int m=millis();
  String x=m+" : "+s;
  
  for(int i=0; i<x.length();i++)
  {
    Serial.write(x.charAt(i));
    digitalWrite(1,LOW);
    digitalWrite(1,HIGH);
    delay(10);
  }
  Serial.println('\n');

}

void loop() {
  
  if(digitalRead(L) && digitalRead(R))
  {
    digitalWrite(10,LOW);
    digitalWrite(11,LOW);
    delay(2000);
    send_message("Arrivé");
  }
  else if (digitalRead(R))
  {
    digitalWrite(11, LOW);
    analogWrite(10, Speed);
    send_message("Virage a droite");
  }
  else if (digitalRead(L))
  {
    digitalWrite(10,LOW);
    analogWrite(11, Speed);
    send_message("Virage a gauche");
  }
  else
  {
    analogWrite(10, Speed);
    analogWrite(11, Speed);
  }

}
