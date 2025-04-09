FROM quay.io/wildfly/wildfly

COPY ./wildfly-config/com /opt/jboss/wildfly/modules/com

WORKDIR /opt/jboss/wildfly/standalone/deployments

COPY ./target/SusFund-1.0-SNAPSHOT.war ./SusFund-1.0-SNAPSHOT.war

#COPY ./wildfly-config/config-script.sh /opt/jboss/
#RUN opt/jobb/wildfly/bin/jboss-cli.sh --file=config-script.sh

CMD ["/opt/jboss/wildfly/bin/standalone.sh"]
