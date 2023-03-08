int G = 2;
int R = 3;
int BtG = 4;
int BtR = 5;
int GState = 0;
int RState = 0;
int BtGState = 0;
int BtRState = 0;
char c;

void setup() {
  Serial.begin(9600);
  pinMode(G,OUTPUT);
  pinMode(R,OUTPUT);
  pinMode(BtG,INPUT);
  pinMode(BtR,INPUT);
}

void loop() {

    if(Serial.available())
    {
      c = Serial.read();
      if(c == 'a') { digitalWrite(R, HIGH);}
      if(c == 'b') { digitalWrite(R, LOW);} 
      if(c == 'c') { digitalWrite(G, HIGH);}
      if(c == 'd') { digitalWrite(G, LOW);} 
      Serial.println(c);
    } 

/*
  if(digitalRead(BtG) && !BtGState)
    {
      if(GState)
      {
        GState--;
      digitalWrite(G,HIGH);
      }
    else
    {
      GState++;
      digitalWrite(G,LOW);
    }
    }
  if(digitalRead(BtR) && !BtRState)
    {
    if(RState)
      {
      RState--;
      digitalWrite(R,HIGH);
      }
    else
      {
      RState++;
      digitalWrite(R,LOW);
      }
    }
*/

}
