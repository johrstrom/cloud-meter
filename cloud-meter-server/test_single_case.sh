#!/bin/sh

if [[ -n $1 ]]; then
	#cd ../cloud-meter-core
	cd ../cloud-meter-protocols/
	mvn clean install
	cd ../cloud-meter-server
fi

mvn clean test -Dtest=NewElementTest#accessLogSamplerTest

