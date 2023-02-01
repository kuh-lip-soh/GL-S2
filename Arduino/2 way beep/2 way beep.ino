int red;
int orange;
int green;
int red2;
int orange2;
int green2;
int beep;

void setup() {
  red = 10;
  orange = 9;
  green = 8;
  red2 = 0;
  orange2 = 1;
  green2 = 2;
  beep = 5;
  pinMode(beep, OUTPUT);
  pinMode(red, OUTPUT);
  pinMode(orange, OUTPUT);
  pinMode(green, OUTPUT);
  pinMode(red2, OUTPUT);
  pinMode(orange2, OUTPUT);
  pinMode(green2, OUTPUT);
}

void beep(int i, int t){
int j;
for (j=0; j<i; j++)
  {
  tone(beep,t);
  delay(100);
  noTone(beep);
  }
}

void loop() {
  digitalWrite(red, HIGH);
  digitalWrite(green2, HIGH);
  beep(30,100);
  digitalWrite(green2, LOW);
  digitalWrite(orange2, HIGH);
  delay(500);
  digitalWrite(red, LOW);
  digitalWrite(orange2, LOW);
  digitalWrite(green, HIGH);
  digitalWrite(red2, HIGH);
  beep(30,250);
  digitalWrite(green, LOW);
  digitalWrite(orange, HIGH);
  delay(500);
  digitalWrite(orange, LOW);
  digitalWrite(red2, LOW);
}
