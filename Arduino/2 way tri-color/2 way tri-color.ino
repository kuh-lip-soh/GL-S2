int red;
int orange;
int green;
int red2;
int orange2;
int green2;

void setup() {
  red = 10;
  orange = 9;
  green = 8;
  red2 = 0;
  orange2 = 1;
  green2 = 2;
  pinMode(red, OUTPUT);
  pinMode(orange, OUTPUT);
  pinMode(green, OUTPUT);
  pinMode(red2, OUTPUT);
  pinMode(orange2, OUTPUT);
  pinMode(green2, OUTPUT);
}

void loop() {
  digitalWrite(red, HIGH);
  digitalWrite(green2, HIGH);  
  delay(3000);
  digitalWrite(green2, LOW);
  digitalWrite(orange2, HIGH);
  delay(500);
  digitalWrite(red, LOW);
  digitalWrite(orange2, LOW);
  digitalWrite(green, HIGH);
  digitalWrite(red2, HIGH);
  delay(3000);
  digitalWrite(green, LOW);
  digitalWrite(orange, HIGH);
  delay(500);
  digitalWrite(orange, LOW);
  digitalWrite(red2, LOW);
}
