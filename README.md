## Setup develop environment
Download Wildfly 35 final -> unzip to folder on your local machine

Configure mysql connectivity in Wildfly server by opening wildfly-35.0.1.Final/standalone/configuration/standalone.xml
 -> navigate to element <subsystem xmlns="urn:jboss:domain:datasources:7.2"> <datasources>
 -> add <datasource jndi-name="java:/jdbc/MySQLDataSource" pool-name="MySQLDS" enabled="true">
           <connection-url>jdbc:mysql://localhost:3306/susfund_db</connection-url>
          <driver>mysql</driver>
        </datasource>

-> navigate to <drivers> 
-> add <driver name="mysql" module="com.mysql">
      <driver-class>com.mysql.cj.jdbc.Driver</driver-class>
      </driver>

-> navigate to wildfly-35.0.1.Final/modules
-> create folders /com/mysql/main
-> download platform indepedent connectorJ 9.2.0 and extract .jar file into /com/mysql/main folder
-> create file module.xml in /com/mysql/main folder
-> open and add to module.xml: 
<module xmlns="urn:jboss:module:1.1" name="com.mysql">
<resources>
<resource-root path="mysql-connector-j-9.2.0.jar"/>
</resources>
<dependencies>
<module name="javax.api"/>
<module name="javax.transaction.api"/>
</dependencies>
</module>


