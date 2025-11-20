FROM payara/micro:6.2025.10-jdk21
COPY target/hello-world-0.1-SNAPSHOT.war $DEPLOY_DIR
