# Documentation
 ********
## PostgreSql
### installation:
###### -version:  10.20
##### -lien de téléchargement:  
###### 1/https://www.enterprisedb.com/downloads/postgres-postgresql-downloads
###### 2/https://www.enterprisedb.com/postgresql-tutorial-resources-training?uuid=ea5c8104-3940-4ed1-b427-81cf19781581&campaignId=70138000000rYFmAAM
##### -video de téléchargement :
###### https://www.youtube.com/watch?v=GU3uRV0A8HQ&t=307s&ab_channel=TechWebDocs
### Intégration:
#### *Keycloak:
##### -lien vidéo: 
###### https://www.youtube.com/watch?v=mUfMsbimEB4&ab_channel=KuylimTith 
#### *Alfresco:
##### 1/Install the PostgreSQL database connector to allow the database to talk to the Content Services server
##### 2/The database connector is a JAR file, for example, postgresql-9.4.1212.jar .
##### 3/Copy the JAR file into the /lib directory. For example, for Tomcat, copy the JAR file into the <TOMCAT_HOME>/lib directory.
###### 1/Locate the configuration file:
######      a/Linux: /var/lib/pgsql/<version-of-postgresql\>/data/postgresql.conf
######      b/Windows: C:\Program Files\PostgreSQL\<version-of-postgresql>\data\postgresql.conf
###### 2/Add or edit the max_connections property:max_connections = 275
###### 3/Restart the database
###### 4/Create a database named alfresco.
###### 5/Create a user named alfresco. :create user alfresco with encrypted password 'mypassword';
###### 6/grant all privileges on database sample_db to user_name;
###### 7/Open the <classpathRoot>/alfresco-global.properties.sample file.
###### 8/Edit the line with an absolute path to point to the directory in which you want to store Content Services data. For example: dir.root=C:\alfresco-content-services-community-full\alf_data
###### Uncomment the following properties:
###### *PostgreSQL connection (requires postgresql-8.2-504.jdbc3.jar or equivalent)
###### db.driver=org.postgresql.Driver 
###### db.url=jdbc:postgresql://{db:host}:{db:port}/{db:name}
###### db.url=jdbc:postgresql://localhost:5432/alfresco
###### Set the other database connection properties.
###### db.name=alfresco
###### db.username=postgres
###### db.password=”password of pgAdmin”
###### db.host=localhost
###### db.port=5432
###### db.pool.max=275
###### 9/Save the file without the .sample extension.
###### 10/To allow password-authenticated connections through TCP/IP, ensure that the PostgreSQL configuration file, pg_hba.conf, contains the following line:
###### 11/host all all `127.0.0.1/32` password
###### 12/Restart the Content Services server. If you receive JDBC errors, ensure the location of the PostgreSQL JDBC drivers are on the system path, or add them to the relevant lib directory of the application server.
#### *Flowable:
##### -lien vidéo: 
###### https://www.youtube.com/watch?v=HwKZ7NKUlO8&t=2s:
## Keycloak:
##### 1/ video telechargement:
###### https://www.youtube.com/watch?v=zq-ENK6ZgXE&t=211s&ab_channel=hi5code
##### 2/ version: 17.0.0
##### 3/ lien de téléchargement :
###### https://hub.alfresco.com/t5/alfresco-content-services-hub/alfresco-community-edition-201802-ea-file-list/ba-p/291521
##### 4/changement de port : dans c:/keycloak/standalone/configuration/standalone.xml change
##### <socket-binding name="http" port="${jboss.http.port:8080}"/> to <socket-binding name="http" port="${jboss.http.port:8085}"/>
##### 5/getting started
###### dans C:\keycloak-legacy-17.0.0\keycloak-17.0.0\bin cliquer sur standalone.bat aprés taper “http://localhost:8085/auth/” 
##### 5/exemple d’application:
###### https://systemweakness.com/setting-up-keycloak-and-securing-spring-boot-rest-apis-1765a85f5ac4
## flowable:
##### 1/ prérequises:
###### *java(JDK) 1.8+
###### *Tomcat
###### *flowable open source
##### 2/Version 6.7.2
##### 3/video telechargement:
###### https://www.youtube.com/watch?v=pmQ6rpotp-U&t=611s&ab_channel=Tech%26Facts
##### 4/créer un simple workflow :
###### https://www.youtube.com/watch?v=SeKdgWtEpCE
##### 5/exemple d’application: 
###### https://medium.com/swlh/implement-flowable-engine-using-java-e437061b6773
## Alfresco: 
##### 1/version:6.0.2.1
##### 2/lien de téléchargement: 
###### https://hub.alfresco.com/t5/alfresco-content-services-hub/alfresco-community-edition-201802-ea-file-list/ba-p/291521
##### 3/création d’un utilisateur et faire télécharger un document :
###### https://www.youtube.com/watch?v=AwKix8L6UPU 
##### 4/donner les permission au utilisateurs:
###### https://www.youtube.com/watch?v=I5LqjLpiR0Y
##### 5/configuration du alfresco avec postgresql
###### https://docs.alfresco.com/content-services/latest/config/databases/#postgresql
##### 6/exemple de download d’un document:
###### https://www.youtube.com/watch?v=Yo8-MYXkgeg&ab_channel=TechyCodes
##### 7/exemple d’upload d’un document 
###### https://www.youtube.com/watch?v=4eeNR_lsBRI&ab_channel=TechyCodes





 

