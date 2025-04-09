batch
/subsystem="datasources"/data-source="java:/jdbc/MySQLDataSource":add(\
  connection-url="jdbc:mysql://susfund:7777/susfund_db", \
  driver="mysql", \
  driver-name="mysql", \
  driver-module="com.mysql", \
  jndi-name="java:/jdbc/MySQLDataSource"
  driver-class="com.mysql.cj.jdbc.Driver"
)

