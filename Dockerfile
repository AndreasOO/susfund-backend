FROM quay.io/wildfly/wildfly

COPY ./wildfly-config/com /opt/jboss/wildfly/modules/com

COPY ./wildfly-config/config-script.cli /opt/jboss/config-script.cli

RUN /opt/jboss/wildfly/bin/jboss-cli.sh --file=/opt/jboss/config-script.cli

RUN rm -Rf /opt/jboss/wildfly/standalone/configuration/standalone_xml_history/*

RUN /opt/jboss/wildfly/bin/add-user.sh admin test1234

WORKDIR /opt/jboss/wildfly/standalone/deployments

COPY ./target/SusFund-1.0-SNAPSHOT.war ./SusFund-1.0-SNAPSHOT.war

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
