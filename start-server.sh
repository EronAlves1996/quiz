#!/bin/bash

source tomcat-settings.sh

webappLocation="$tomcatLocation/webapps/$projectName"

function cleanup(){
  mvn clean
  rm -rf "$webappLocation" "$webappLocation.war"
}

trap cleanup SIGINT
trap cleanup SIGHUP

mvn package
warLocation=$(readlink -f ./target/*.war)
cp "$warLocation" "$webappLocation.war"
"$tomcatLocation/bin/catalina.sh" run
