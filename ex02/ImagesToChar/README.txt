Compile
    cd src/java
    mkdir ../../target
    javac -d ../../target edu/school21/printer/app/Program.java
Run
    java -cp ../../target edu.school21.printer.app.Program 0 . ../it.bmp
Archive
    cd ../../target
    cp -rf ../src/resources .
    jar cmf ../src/manifest.txt images-to-chars-printer.jar edu/school21/printer/app/Program.class edu/school21/printer/logic/Converter.class resources
Run archive
    java -jar images-to-chars-printer.jar 0 . resources/it.bmp