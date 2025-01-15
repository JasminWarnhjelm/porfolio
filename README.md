# java_project_work


<h2>Contacts App</h2>

Contacts App is a command line user interface application where you can store contacts.

## Description
This application is a simple Java-based application to manage contact information stored in a CSV file. This application provides features to
create, read, update and delete contacts that are validated to provide
correct form of information.

## Features
- Create a contact
- Read contacts
- Update contacts
- Delete contacts

## Structure
- Validation.java: Handles input validation for the user input.
- Choises.java: Implements create, update and delete funtionalities.
- Info.java: Represents a contact object.
- MyFile.java: Manages reading and writing to a CSV file.

## Tests
Creating a contact and reading the file
<img src="Create.png">

Updating a contact
<img src="Update.png">

Deleting a contact <br>
<img src="Delete.png">

## Usage

Run the App using this command: <br>
cd src/ && javac *.java && java ContactsApp

Type create, read, update or delete to choose the action and follow the instructions.

<kbd>q + enter</kbd> - Quit the App.

## Screencast
Watch it <a href="https://youtu.be/lhuKIVQTDJI">here</a>.

## Sources

Regex:
https://www.jrebel.com/blog/java-regular-expressions-cheat-sheet <br>
https://regex101.com/library/cIohyA (finnish ID) <br>
https://stackoverflow.com/questions/66910411/regular-expression-to-validate-a-name (name) <br>
https://ihateregex.io/expr/phone/ (phone number) <br>
https://ihateregex.io/expr/email (email) <br>

PrintWriter:
https://www.youtube.com/watch?v=c9L2rJt20qQ (writing to a csv file) <br>

Reader:
https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line <br>
https://www.geeksforgeeks.org/split-string-java-examples/ (split.line) <br>
https://www.geeksforgeeks.org/java-io-filereader-class/ <br>
https://www.w3schools.com/java/ref_string_format.asp (format) <br>
https://www.studytonight.com/java-examples/reading-a-csv-file-in-java <br>
https://www.youtube.com/watch?v=JFc_8oq7yLM <br>
https://www.baeldung.com/java-csv-file-array (array) <br>

Update:
https://www.youtube.com/watch?v=TpyRKom0X_s <br>

Delete:
https://www.youtube.com/watch?v=NceIYifVAQQ <br>

Errors and Exections:
https://stackoverflow.com/questions/15722763printing-exception-message-in-java <br>
https://rollbar.com/blog/how-to-throw-illegalargumentexception-in-java/ <br>
https://www.youtube.com/watch?v=EDIIXLL24pk <br>

Graphical user interface:
https://www.youtube.com/watch?v=vego72w5kPU <br>
https://docs.oracle.com/javase/8/docs/api/javax/swing/JTable.html (table) <br>
https://www.youtube.com/watch?v=ccUdvsj4L0U (table) <br>

ReadMe inspo:
https://github.com/akashnimare/foco/blob/master/readme.md <br>

Others:
https://stackoverflow.com/questions/23283041/how-to-make-java-delay-for-a-few-seconds (thread sleep) <br>
https://www.youtube.com/watch?v=WEZRc0GoP3E (writing to text file) <br>
https://mkyong.com/java/how-to-export-data-to-csv-file-java/ (writing to csv file) <br>
https://www.youtube.com/watch?v=WEZRc0GoP3E (writing to text file) <br>
https://www.programiz.com/java-programming/printwriter (printwriter) <br>
https://www.geeksforgeeks.org/difference-between-bufferedreader-and-filereader-in-java/ <br>
https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/ <br>
