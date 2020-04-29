rem %1
rem %~11

set PROGRAM="%~1"

java -jar %PROGRAM% matrix.txt
java -jar %PROGRAM% nomatrix.txt
java -jar %PROGRAM%