To try out the build, issue the following at the command line:
------------
mvn compile
------------

This will run Maven, telling it to execute the compile goal. When it's finished, you should find the
compiled .class files in the target classes/directory.

Since it's unlikely that you'll want to distribute or work with .class files directly, you'll probably want to
run the package goal instead:
-------------
mvn package
-------------

The package will compile your Java code, run any tests, and finish by packaging the code up in a
JAR file within the target directory. The name of the JAR file will be based on the project's
<artifactID> and <version>. For example, given the minimal pom.xml file from before, the JAR
file will be named gs-maven-0.1.0.jar

To execute the JAR file run:
-------------------------------------
java -jar target/gs-maven-0.1.0.jar
-------------------------------------

To run the project compile maven and then run the package. From that a jar will be 
created and then run that jar file.

Or:
Go to LoginHandler.java and run the main file there
