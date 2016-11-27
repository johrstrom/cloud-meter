#!/bin/sh

mvn clean package

java -jar "target/cloud-meter-server-0.0.1-SNAPSHOT.jar"
