javac -d ./output -cp .:resources/postgresql-42.3.5.jar ./src/*.java;
java -cp ./output:resources/postgresql-42.3.5.jar ./src/Main.java jdbc:postgresql://localhost:5432/database username password    