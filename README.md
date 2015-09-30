weather-app

Basert på https://github.com/wildfly/quickstart prosjektene

Teknologier: CDI, JSF, JPA, EJB, JAX-RS

App-server: Jboss Wildfly 9.0.1.Final
Database: H2 in memory

* Deploy og kjør applikasjon på lokal Jboss Wildfly
* App bruker H2 in memory database. Denne følger med Jboss Wildfly out-of-the-box (ExampleDS)
* Last ned h2console.war fra https://github.com/wildfly/quickstart/tree/9.x/h2-console
* Kopier war fila til $JBOSS_HOME\standalone\deployments
* Start H2 konsoll på http://localhost:8080/h2console
* Bruk jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE som JDBC URL og sa/sa som brukernavn/passord (finnes i standalone.xml)
* Start app på app på http://localhost:8080/moap/