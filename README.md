CustomerRecordManagement1
=========================

* The CutomerRecordManagement program implements an application that  stores and maintains Customer Records and displays the records .

Release notes
=============
* Version 1.0 (25/06/2014)
* First release of CustomerRecordManagement1 repository
* Tecnologies used: Java 7, JavaFX2 for UI, H2 embedded for database
* Requirement : NetBeans 8.0 , H2 database jar file h2-1.4.179.jar

h2 Database 
============
* CREATE TABLE customertable(name varchar2(100),email varchar2(100),phone varchar2(15),address varchar2(255),city varchar2(50),state varchar2(50),pincode int(20),country varchar2(50));

How to Execute
==============
* Open NetBeans
* Create New Project -->  select JavaFX --> select JavaFX Application
* Specify Project Name as :  CustomerRecordManagement1
* Click Finish
* Right Click Source Folder and create new Package named : Form
* Add all the files from src folder to the Form package
* Right Click Project Name --> Properties
* Add the H2 database jar file h2-1.4.179.jar
* Build the Project
* Run the Project
