#!/bin/sh

if [[ -n $1 ]]; then
	cd ../cloud-meter-core
	mvn clean install
	cd ../cloud-meter-protocols
	mvn clean install
	cd ../cloud-meter-components
	mvn clean install
	cd ../cloud-meter-server
fi

mvn clean test

