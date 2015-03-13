#!/bin/bash
mkdir testDir
mkdir -p testDir/plugins/PluginMetrics/
wget -O ./testDir/eula.txt https://raw.githubusercontent.com/eternnoir/docker-spigot/master/eula.txt
cp ./tmp/spigot-1.8.3.jar ./testDir/spigot.jar
cp ./build/libs/MCREST-all*.jar ./testDir/plugins
cd ./testDir
python2 ../test/testRun.py
