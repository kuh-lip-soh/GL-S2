#define Pin7  7
char caracter;

void setup() { 
  Serial.begin(9600);
  pinMode(Pin7, OUTPUT);
}

void loop() { 
  
  if(Serial.available()) {
  caracter = Serial.read();
  
    if(caracter == 'a'){ digitalWrite(Pin7, HIGH);}
    if(caracter == 'b'){ digitalWrite(Pin7, LOW);} 
  } 

} 
