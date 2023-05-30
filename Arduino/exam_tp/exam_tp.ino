  int btn1 = 8;
  int btn2 = 7;
  int btn3 = 6;
  int btn4 = 5;

  int red = 9;
  int green = 10;
  int blue = 11;

  int beep = 4;

  int btnState1 = LOW;
  int btnState2 = LOW;
  int btnState3 = LOW;
  int btnState4 = LOW;

  bool state = false;

  int i=0;
  char t[10]={'0','0','0','0','0','0','0','0','0','0'};

  void setup() {
    Serial.begin(9600);
    pinMode(btn1, INPUT);
    pinMode(btn2, INPUT);
    pinMode(btn3, INPUT);
    pinMode(btn4, INPUT);
    pinMode(red, OUTPUT);
    pinMode(green, OUTPUT);
    pinMode(blue, OUTPUT);
    pinMode(beep, OUTPUT);
  }

  void blueLight() {
    digitalWrite(blue, HIGH);
    tone(beep,1600);
    delay(3000);
    digitalWrite(blue, LOW);
    noTone(beep);
    delay(1000);
  }

  void greenLight() {
    digitalWrite(green, HIGH);
    tone(beep,400);
    delay(1000);
    digitalWrite(green, LOW);
    noTone(beep);
    delay(1000);
  }

  void changeState() {
    if (state) {
      state = false;
      digitalWrite(red, LOW);
    }
    else {
      state = true;
      digitalWrite(red, HIGH);
    }

  }

  void validate() {
    int k = 0;
    for(k=0; t[k]!='0'; k++) {
      switch(t[k]) {
        case 'g' :
          greenLight();
        break;
        case 'l' :
          blueLight();
        break;
      }
    }
    i=0;
    for(k=0; k<10; k++)
      t[k]='0';

  }

  void loop() {

  if (digitalRead(btn1) != btnState1) {
      if (digitalRead(btn1) == HIGH) {
        tone(beep,100,50);
        changeState();
        Serial.println("1 appuyé");
      } else {
        Serial.println("1 relâché");
      }
      btnState1 = digitalRead(btn1);
    }
    if (digitalRead(btn2) != btnState2) {
      if (digitalRead(btn2) == HIGH && state) {
        tone(beep,100,50);
        t[i]='g';
        i++;
        Serial.println("2 appuyé");
      } else {
        Serial.println("2 relâché");
      }
      btnState2 = digitalRead(btn2);
    }

  if (digitalRead(btn3) != btnState3) {
      if (digitalRead(btn3) == HIGH && state) {
        tone(beep,100,50);
        t[i]='l';
        i++;
        Serial.println("3 appuyé");
      } else {
        Serial.println("3 relâché");
      }
      btnState3 = digitalRead(btn3);
    }

  if (digitalRead(btn4) != btnState4) {
      if (digitalRead(btn4) == HIGH && state ){
        tone(beep,200,50);
        validate();
        Serial.println("4 appuyé");
      } else {
        Serial.println("4 relâché");
      }
      btnState4 = digitalRead(btn4);
    }

  }
