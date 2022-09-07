FROM bellsoft/liberica-openjdk-alpine:11.0.16

COPY target/jasperreports-1.0.0-SNAPSHOT.jar app.jar
COPY src/main/docker/entrypoint.sh /entrypoint.sh
COPY src/main/docker/fontconfig.bfc /usr/lib/jvm/jdk-11.0.16.1-bellsoft-x86_64/lib/fontconfig.bfc

EXPOSE 8080

ENTRYPOINT ["sh", "/entrypoint.sh"]