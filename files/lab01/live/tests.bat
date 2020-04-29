rem %1
rem %~11

set PROGRAM="%~1"

java -jar %PROGRAM% before.txt
java -jar %PROGRAM% before.txt after.txt