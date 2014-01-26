zipcode
=======
This application validate the zip code and if it is valid then show the weather details of that city. This aplication is build using spring-mvc and maven. 

There is one global variable is defined in validate.js to enable the client side or server side calculation. If that flag is true then validation and reteriving of data will be done on server side otherwise on client side.

Run Application
==================
1) Below code should be in settings.xml placed at ${user_directory}/.m2. The 'manager-gui' role must be defined in tomcat-users.xml located at ${tomcat dir}/conf/tomcat-users.xml
  Write username and password defined in that xml for manager-gui role.
     <server>
        <id>Tomcat_6.0-config</id>
        <username>tomcat</username>
        <password>tomcat</password>
    </server>
2) Tomcat should be up on http://localhost:8080
3) To start the application use command "mvn clean install tomcat:deploy";
4) Access application at http://localhost:8080/zipcode/mainpage
