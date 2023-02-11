#inlude <Servo.h>
Servo ms;

void setup() {
  Serial.begin(9600);
  ms attach(7);
}

void loop() {
  int L1 = analogRead(A0);
  int L2 = analogRead(A1);

  Serial.print("A0 : ");
  Serial.print(L1);
  Serial.print("   A1 : ");
  Serial.println(L2);  
  delay(1000);
  ms.write(90);
  ms.write(0);
}
