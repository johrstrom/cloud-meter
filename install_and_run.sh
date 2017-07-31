#!/bin/sh

mvn clean install "-Dmaven.test.skip=true"

java -jar "cloud-meter-server/target/cloud-meter-server-0.0.1-SNAPSHOT.jar"
