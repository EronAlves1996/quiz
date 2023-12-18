tomcatLocation="/home/eron/servers/apache-tomee-plus-8.0.6"
projectName=$(xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:artifactId pom.xml)
