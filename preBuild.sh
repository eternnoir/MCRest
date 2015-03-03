#!/bin/sh
mkdir tmp
mkdir libs
wget wget -O ./tmp/BuildTools.jar https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar
cd tmp
java -jar ./BuildTools.jar
cd ..
cp tmp/spigot*.jar libs/spigot.jar 
