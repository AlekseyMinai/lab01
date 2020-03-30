java -jar rle.jar pack text.txt packed.txt
java -jar rle.jar unpack packed.txt unpacked.txt
java -jar rle.jar unknown packed.txt unpacked.txt
java -jar rle.jar pack notexist.txt 22.txt
java -jar rle.jar unpack notexist.txt 22.txt
java -jar rle.jar pack 255.txt 255packed.txt
java -jar rle.jar unpack 255packed.txt 255unpacked.txt