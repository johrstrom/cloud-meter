

#ctype="content-type: multiform/post-data"
#ctype="content-type: application/x-www-form-urlencoded"

accept="-H accept:application/json"
hdrs="${accept}"

curl ${hdrs} -v "http://localhost:8080/api/v1/testplan" | python -m json.tool

echo ""
