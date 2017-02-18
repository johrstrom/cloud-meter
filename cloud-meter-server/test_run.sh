

#ctype="content-type: multiform/post-data"
#ctype="content-type: application/x-www-form-urlencoded"

file="/opt/jmeter/apache-jmeter-3.0/testplans/cm_test_1.jmx"

curl -v -F "testPlan=@${file}" "http://localhost:8080/api/v1/run"

echo ""
