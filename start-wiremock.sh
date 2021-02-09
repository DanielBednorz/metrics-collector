#!/bin/bash

wiremockDir="wiremock"
wiremockVersion="2.26.2"
wiremockPort="5555"
wiremockFile=wiremock-standalone-${wiremockVersion}.jar

echo -e "\\nStarting wiremock...\\n"

if [ -d "$wiremockDir" ]; then
  cd $wiremockDir
  java -jar $wiremockFile --port $wiremockPort --global-response-templating --verbose
else
  echo "$wiremockDir folder not found."
fi
