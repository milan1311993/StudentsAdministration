# StudentsAdministration

*This is a simple application for students and faculty administration. Once you sign up you can use this app. As a regular user, you can see the list of currently enrolled students from the base with this information for each of them: first name, last name, index number, level of studies and year of studies. Clicking on button "Download .xclx file" you may choose where you want to download this list as the excel file. On the right side of the panel you may see your user name, you may delete your account and you are able to sign off. 
On the other side, if you are logged in as admin (user name: admin, password admin) you may add new students in the base following the instructions about mandatory fields and input data. You may delete and edit wanted student. Also, logged in as admin you may filtered list of students by the level of studies (undergraduate, master, PhD).*

Take a look at my app opening screenshots folder with 11 pictures!

For the graphical user interface (**GUI**) I used the ***SWING*** with manual adjustment of the panels layout.
Clicking on some buttons through the app the pop up window appears with notification or warning message (for example, button for delete student, button for sign up, sign in etc.)
Pay attention to the mandatory and optional fields within the registration process. You cannot open your account if the mandatory fields are not fulfilled! I used **ApachePOI** for writing excel file (.xclx) with list of all the students from the base.


If you want to test or use this app you have to do next:

**->** import jar file for connecting with database (I used jdbc mysql-connector-java-8.0.17.jar)

**->** import poi jar files (I  used poi-4.1.0)

**->** download three packages (ActionListeners, FrameListStudentMain, Panels) and database faculty-student.sql

**->** you have to scroll down the class "Frame" in the FrameListStudentMain package and change your port and possibly the name of the base. I mean on this line of code: DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty_student", "root", "")

***That's it! Nice day! :)***
