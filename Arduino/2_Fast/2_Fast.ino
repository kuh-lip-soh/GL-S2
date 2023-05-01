char t;
int LED = 9;
int Buzzer = 8;

bool LED_State=false;

void setup() { 
  pinMode(13,OUTPUT); //left motors forward
  pinMode(12,OUTPUT); //left motors reverse
  pinMode(11,OUTPUT); //right motors forward
  pinMode(10,OUTPUT); //right motors reverse
  pinMode(LED,OUTPUT);
  pinMode(Buzzer,OUTPUT);
  test();
  Serial.begin(9600);
  }

void test () {
  digitalWrite(13,HIGH);
  delay(100);
  digitalWrite(13,LOW);
  digitalWrite(12,HIGH);
  delay(100);
  digitalWrite(12,LOW);
  digitalWrite(11,HIGH);
  delay(100);
  digitalWrite(11,LOW);
  digitalWrite(10,HIGH);
  delay(100);
  digitalWrite(10,LOW);
  digitalWrite(LED,HIGH);
  delay(100);
  digitalWrite(LED,LOW);
  tone(Buzzer, 1500, 100);
  }  

void loop() {
  if(Serial.available()){ 
    t = Serial.read();
    Serial.println(t);
    }
    switch (t) {
      case 'U' :
        digitalWrite(13,HIGH);
        digitalWrite(11,HIGH);
      break;
      case 'D' :
        digitalWrite(12,HIGH);
        digitalWrite(10,HIGH);
      break;
      case 'L' :
        digitalWrite(11,HIGH);
      break;
      case 'R' :
        digitalWrite(13,HIGH);
      break;
      case 'H' :
        tone(Buzzer,300,50);
        delay(100);
        tone(Buzzer,700,150);
      break;
      case 'L' :
        if(LED_State)
          {
            digitalWrite(LED,LOW);
            LED_State=false;
          }
        else
          {
            digitalWrite(LED,HIGH);
            LED_State=true;
          }
      break;
      case 'T' :
        digitalWrite(12,HIGH);
        digitalWrite(11,HIGH);
        delay(250);
      break;
      case 'O' :
        digitalWrite(LED,LOW);
        tone(Buzzer,700,50);
        digitalWrite(LED,HIGH);
        tone(Buzzer,900,50);
        digitalWrite(LED,LOW);
        tone(Buzzer,1500,150);
        digitalWrite(LED,HIGH);
        LED_State=true;
      break;
      case 'S' :
        digitalWrite(13,LOW);
        digitalWrite(12,LOW);
        digitalWrite(11,LOW);
        digitalWrite(10,LOW);
      break;
    }
}