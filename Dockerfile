FROM quay.io/wildfly/wildfly

COPY ./wildfly-config/com /opt/jboss/wildfly/modules/com



#COPY ./wildfly-config/config-script.sh /opt/jboss/
#RUN opt/jobb/wildfly/bin/jboss-cli.sh --file=config-script.sh

CMD ["/opt/jboss/wildfly/bin/standalone.sh"]
