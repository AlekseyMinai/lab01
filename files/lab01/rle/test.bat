rem %1
rem %~11

set PROGRAM="%~1"

java -jar %PROGRAM% pack text.txt packed.txt
java -jar %PROGRAM% unpack packed.txt unpacked.txt
java -jar %PROGRAM% unknown packed.txt unpacked.txt
java -jar %PROGRAM% pack notexist.txt 22.txt
java -jar %PROGRAM% unpack notexist.txt 22.txt
java -jar %PROGRAM% pack 255.txt 255packed.txt
java -jar %PROGRAM% unpack 255packed.txt 255unpacked.txt