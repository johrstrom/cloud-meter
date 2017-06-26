#!/bin/bash

#ctype="content-type: multiform/post-data"
#ctype="content-type: application/x-www-form-urlencoded"

accept="-H accept:application/json"
hdrs="${accept}"

if [ -n $1 ]
then
	curl ${hdrs} -v "http://localhost:8080/api/v1/testplan?name=$1" | python -m json.tool
else
	curl ${hdrs} -v "http://localhost:8080/api/v1/testplan" | python -m json.tool
fi

echo ""
