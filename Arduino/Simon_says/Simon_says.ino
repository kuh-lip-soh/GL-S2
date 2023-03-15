int R = 3;
int G = 4;
int B = 5;
int W = 6;

int BtnR = 8;
int BtnG = 9;
int BtnB = 10;
int BtnW = 11;

int beep = 7;

char sequence [10];
int rounds = 10;
int pause = 500;

char color [] = {'R','G','B','W'};
int beeps [] = {250,450,650,850};

int over[] = {262, 196, 196, 220, 196, 0, 247, 262};
int overDurations[] = {4, 8, 8, 4, 4, 4, 4, 4};


void setup() {
  Serial.begin(9600);
  randomSeed(25);

  pinMode(R, OUTPUT);
  pinMode(G, OUTPUT);
  pinMode(B, OUTPUT);
  pinMode(W, OUTPUT);

  pinMode(BtnR,INPUT_PULLUP);
  pinMode(BtnG,INPUT_PULLUP);
  pinMode(BtnB,INPUT_PULLUP);
  pinMode(BtnW,INPUT_PULLUP);

  pinMode(beep, OUTPUT);

}

void play(char c) {
  switch (c)
  {
  case 'R':
    tone(beep,beeps[0],50);
    digitalWrite(R, HIGH);
    delay(pause);
    digitalWrite(R, LOW);
  break;
  case 'G':
    tone(beep,beeps[1],50);
    digitalWrite(G, HIGH);
    delay(pause);
    digitalWrite(G, LOW);
  break;
  case 'B':
    tone(beep,beeps[2],50);
    digitalWrite(B, HIGH);
    delay(pause);
    digitalWrite(B, LOW);
  break;
  case 'W':
    tone(beep,beeps[3],50);
    digitalWrite(W, HIGH);
    delay(pause);
    digitalWrite(W, LOW);
  break;
  }
}

void preview(char sequence[], int j) {
  for(int i=0; i<=j;i++)
  {
    play(sequence[i]);
  }
}

char input() {
  while(true)
  {
    delay(250);
  //Serial.println("Waiting input");
  if(digitalRead(BtnR))
    return 'R';
  if(digitalRead(BtnG))  
    return 'G';
  if(digitalRead(BtnB))  
    return 'B';
  if(digitalRead(BtnW))  
    return 'W';
  }
}

void gameover() {
  for (int thisNote = 0; thisNote < 8; thisNote++) {
    int overDuration = 1000/overDurations[thisNote];
    tone(beep, over[thisNote],overDuration);
    int pauseBetweenNotes = overDuration * 1.30;
    delay(pauseBetweenNotes);
    noTone(beep);
  }
  //tone(beep,1500,150);
}


void loop() {
  
  for(int i=0; i<rounds; i++)
  {
    sequence[i]=color[random(0,4)];
  }

  for(int i=0; i<rounds; i++)
  {
    preview(sequence,i);
    for(int current=0; current<=i; current++)
    {
      if(sequence[current]!=input())
      {
        Serial.println("Game over !");
        Serial.print("Round : ");
        Serial.println(current);
        gameover();
        i=-1;
      }
      else {
      play(sequence[current]);
      /*
      Serial.print("Won round ");
      Serial.println(current);
      */
      }
    }
  }
  Serial.println("You won !");
}


void test() {
  digitalWrite(R, HIGH);
  delay(100);
  digitalWrite(R, LOW);
  digitalWrite(G, HIGH);
  delay(100);
  digitalWrite(G, LOW);
  digitalWrite(B, HIGH);
  delay(100);
  digitalWrite(B, LOW);
  digitalWrite(W, HIGH);
  delay(100);
  digitalWrite(W, LOW);

  Serial.print("Red : ");
  Serial.print(digitalRead(BtnR));
  Serial.print("- Green : ");
  Serial.print(digitalRead(BtnG));
  Serial.print("- Blue : ");
  Serial.print(digitalRead(BtnB));
  Serial.print("- White : ");
  Serial.println(digitalRead(BtnW));
  
}
