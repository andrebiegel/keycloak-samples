#!/bin/bash                                                                                                                                                                         
export DIRECT_GRANT_RESPONSE=$(curl -i --request POST http://localhost:8080/auth/realms/extension-samples/protocol/openid-connect/token \
        --header "Accept: application/json" \
        --header "Content-Type: application/x-www-form-urlencoded" \
        --data "grant_type=password&username=sampleuser&password=password&client_id=sample-client");

echo -e "\n\nSENT RESOURCE-OWNER-PASSWORD-CREDENTIALS-REQUEST. OUTPUT IS:\n\n";
echo $DIRECT_GRANT_RESPONSE;

export ACCESS_TOKEN=$(echo $DIRECT_GRANT_RESPONSE | grep "access_token" | sed 's/.*\"access_token\":\"\([^\"]*\)\".*/\1/g');
echo -e "\n\nACCESS TOKEN IS \"$ACCESS_TOKEN\"";

echo -e "\n\nGET Jitsi Token :\n";
curl -i --request GET http://localhost:8080/auth/realms/extension-samples/custom-jaxrs/greetings/helloMe \
        --header "Accept: application/json" \
        --header "Authorization: Bearer $ACCESS_TOKEN";
echo "result received"


