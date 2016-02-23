
Pro kompilaci:

mvn clean install

Pro deploy na lokální wildfly: (předpokládá že wildfly už běží)

mvn wildfly:deploy

Deploynutý web se objeví na adrese:

http://localhost:8080/pis/

