#!/bin/sh

if [[ -n $1 ]]; then
	#cd ../cloud-meter-core
	cd ../cloud-meter-protocols
	mvn clean install
	cd ../cloud-meter-server
fi

mvn clean package 

java -jar "target/cloud-meter-server-0.0.1-SNAPSHOT.jar"
