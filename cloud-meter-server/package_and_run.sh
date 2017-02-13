#!/bin/sh

mvn clean package "-Dmaven.test.skip=true"

java -jar "target/cloud-meter-server-0.0.1-SNAPSHOT.jar"
