# -*- coding: utf-8 -*-
import requests, json
import unittest
import config
import mcserver
from time import sleep
class TestPluginStart(unittest.TestCase):
    def setUp(self):
        self.thread = mcserver.MinecraftServerThread()
        self.thread.start()
        print "sleep 90 sec"
        sleep(90)
    def tearDown(self):
        self.thread.stop()

    def test_up(self):
        plugin_url= config.PluginUrl+":"+config.PluginPort+"/"+config.PluginPrefix+"/"
        result = requests.get(plugin_url).text
        self.assertEquals("Hello MCRest.", result);

