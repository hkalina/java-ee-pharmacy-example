
Pro kompilaci:
mvn clean install

Pro konfiguraci bezpečnostního subsystému (security domény):
mvn wildfly:execute-commands

Pro deploy na lokální wildfly: (předpokládá že wildfly už běží)
mvn wildfly:deploy

Deploynutý web se objeví na adrese:
http://localhost:8080/pis/


Pozn: pro založení podobného projektu:
mvn archetype:generate -DarchetypeGroupId=org.richfaces.archetypes -DarchetypeArtifactId=richfaces-archetype-simpleapp -DarchetypeVersion=4.0.0-SNAPSHOT -DgroupId=package -DartifactId=project

https://github.com/wildfly/quickstart/tree/10.x/hibernate5


Bezpečnostní subsystém lze nakonfigurovat také přidáním následující domény do `standalone/configuration/standalone.xml`:

                <security-domain name="pis-domain" cache-type="default">
                    <authentication>
                        <login-module code="Database" flag="required">
                            <module-option name="dsJndiName" value="java:jboss/datasources/ExampleDS"/>
                            <module-option name="principalsQuery" value="SELECT password FROM User WHERE username = ?"/>
                            <module-option name="rolesQuery" value="SELECT role, 'Roles' FROM User WHERE username = ?"/>
                            <module-option name="hashAlgorithm" value="MD5"/>
                            <module-option name="hashEncoding" value="base64"/>
                        </login-module>
                    </authentication>
                </security-domain>

