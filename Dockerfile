FROM quay.io/wildfly/wildfly

COPY ./wildfly-config/com /opt/jboss/wildfly/modules/com

#COPY ./wildfly-config/config-script.sh /opt/jboss/
#RUN opt/jobb/wildfly/bin/jboss-cli.sh --file=config-script.sh

RUN /opt/jboss/wildfly/bin/add-user.sh admin test1234

WORKDIR /opt/jboss/wildfly/standalone/deployments

COPY ./target/SusFund-1.0-SNAPSHOT.war ./SusFund-1.0-SNAPSHOT.war

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
