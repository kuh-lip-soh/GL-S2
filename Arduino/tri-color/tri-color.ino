int red;
int orange;
int green;

void setup() {
  red = 10;
  orange = 9;
  green = 8;
  pinMode(red, OUTPUT);
  pinMode(orange, OUTPUT);
  pinMode(green, OUTPUT);
}

void loop() {
  digitalWrite(red, HIGH);
  delay(3000);
  digitalWrite(red, LOW);
  digitalWrite(green, HIGH);
  delay(3000);
  digitalWrite(green, LOW);
  digitalWrite(orange, HIGH);
  delay(500);
  digitalWrite(orange, LOW);
}
