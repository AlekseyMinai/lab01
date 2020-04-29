rem %1
rem %~11

set PROGRAM="%~1"

java -jar %PROGRAM% 16 10 1F
java -jar %PROGRAM% 32 2 1F
java -jar %PROGRAM% 8 12 55
java -jar %PROGRAM% 2 10 1F
java -jar %PROGRAM% 32 1 1F
java -jar %PROGRAM% 400 32 1F
java -jar %PROGRAM% 32 2 ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ

