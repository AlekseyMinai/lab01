rem %1
rem %~11

set PROGRAM="%~1"

java -jar %PROGRAM% text1.txt result1.txt Skibidi 345345
java -jar %PROGRAM% text2.txt result2.txt 1231234 !!!
java -jar %PROGRAM% text3.txt result3.txt 123 !!!

echo OK


