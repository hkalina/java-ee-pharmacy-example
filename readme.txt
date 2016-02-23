
Pro kompilaci:

mvn clean install

Pro deploy na lokální wildfly: (předpokládá že wildfly už běží)

mvn wildfly:deploy

Deploynutý web se objeví na adrese:

http://localhost:8080/pis/


Pozn: založení podobného projektu:

mvn archetype:generate -DarchetypeGroupId=org.richfaces.archetypes -DarchetypeArtifactId=richfaces-archetype-simpleapp -DarchetypeVersion=4.0.0-SNAPSHOT -DgroupId=package -DartifactId=project

https://github.com/wildfly/quickstart/tree/10.x/hibernate5

