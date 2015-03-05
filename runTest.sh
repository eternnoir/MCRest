#!/bin/bash
mkdir testDir
wget -O ./testDir/eula.txt https://raw.githubusercontent.com/eternnoir/docker-spigot/master/eula.txt
cp ./tmp/spigot-1.8.jar ./testDir
cp ./build/libs/MCREST-all*.jar ./testDir/plugins
cd ./testDir
python2 ../test/testRun.py
