int irPin = 9;
int pinData = 9;
int buzzer = 7;
int red = 6;

int key=0;
int k[3];
int currentK=0;
bool alarmState = true;

void setup() {
  Serial.begin(9600);
  pinMode(irPin, INPUT);
  pinMode(buzzer, OUTPUT);
  pinMode(red, OUTPUT);
}

int getIRKey() {
  uint32_t pulseBitValue=0; // Value used for reading the PulseIn()
  uint32_t bitValue=0; // Value used for converting the pulseBitValue to 1 or 0
  uint32_t pulseOne=1200; // Threshold for Binary Value=1
  uint32_t startPulse=2600; // Threshold for StartBit
  uint32_t thePulse = pulseIn(pinData, LOW); // Initialze pulse sent
  uint32_t resultValue=0; // Initalize resultValue Returned = 0
  uint32_t bitShiftValue=0; // Initialize the Binary Shift Value
  if(thePulse > startPulse) { // Ready To Receive value when thePulse >StartBit Threshold
    // digitalWrite(statLED,HIGH); // Status LED = ON
    for(uint8_t i = 1; i <= 32; i++) { // Loop to Get 32 Pulses
      pulseBitValue=pulseIn(pinData,HIGH,10000); // Get the pulseBit Value
      bitValue=(pulseBitValue>=pulseOne)?1:0; // If pulseBitValue > Binary 1 Threshold Value then bitValue=1 else bitValue=0
      if(i>16 && i<=24) { // If the bitPosition of the PulseIn Values are between 17 and 24 ...
        resultValue=resultValue+(bitValue <<(bitShiftValue++)); // then add bitValue*2^bitShiftValue to returnValue
      }
    }
  }
  return resultValue;
}

int input() {
  int now = millis();
  while((now+1000)>millis())
    {
      key = getIRKey();
      if(currentK==3)
        currentK=0;
      if(key)
        {
          k[currentK]=key;
          currentK++;
          Serial.println(currentK);
          tone(buzzer,1500,100);
          break;
        }
    }
}

void code() {
  if(k[0] == 7 && k[1] == 21 && k[2] == 9)
    {
      alarmState=true;
      currentK=0;
    }
  if(k[0] == 7 && k[1] == 21 && k[2] == 9)
    {
      alarmState=false;
      currentK=0;
    }
}

bool presence() {
  if(analogRead(A0)<20)
    return true;
}

void switchAlarm() {
  for(int h=0; h<10; h++)
  {
    digitalWrite(red, HIGH);
    delay(50);
    digitalWrite(red, LOW);
    tone(buzzer,200,50);
    input();
    code();
    if(alarmState)
      return;
  }
  while(true)
  {
    digitalWrite(red, HIGH);
    tone(buzzer,250,50);
    delay(50);
    tone(buzzer,800,50);
  }
}

void loop() {
  if(alarmState)
  {
    if(presence())
      switchAlarm();
  }
  if(!(alarmState))  
  {
    input();
    code();
  }
  
  Serial.print("Light : ");
  Serial.println(analogRead(A0));
  Serial.print("Key : ");
  for(int j=0;j<3;j++)
    Serial.print(k[j]);
  Serial.println();
}
