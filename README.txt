Project has been compiled using JDK16 with Eclipse IDE v2021-06(4.20.0) and ran on Apache Tomcat v10

==================
For Eclipse IDE
==================
https://www.eclipse.org/downloads/
1) File -> Import (WAR file)
2) Select "OneST.WAR"
3) Select target runtime with "Apache Tomcat"
If there is no runtime environment, proceed to http://tomcat.apache.org/ and install Apache Tomcat
4) Ignore library imports or "Deselect all"
5) Click finish
6) Right click Project -> Run as -> Run on server
7) Select Apache Tomcat server or run on any existing server that is already in local pc
8) Done

==================
For Netbeans IDE (Not tested)
==================
https://netbeans.apache.org/download/index.html
1) Unzip "OneST.WAR" file into clean empty folder
2) Open Netbeans -> File -> New project -> Java Web Application
3) Give it any name
4) Give it any project location
5) Click next and select "Apache Tomcat" server
If there is no runtime environment, proceed to http://tomcat.apache.org/ and install Apache Tomcat
6) Click finish
7) Copy the files over from step 1 to the new project "\src\main\webapp" folder
8) Right click Project -> Run
9) Done