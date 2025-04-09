FROM mysql:latest

ENV MYSQL_DATABASE=susfund_db \
    MYSQL_ROOT_PASSWORD=test1234

COPY ./scripts/dbinit.sql /docker-entrypoint-initdb.d/
