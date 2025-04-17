#!/bin/bash

/opt/jboss/wildfly/bin/add-user.sh "$WILDFLY_USER" "$WILDFLY_PASSWORD" --silent

exec /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 --debug