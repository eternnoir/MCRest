# -*- coding: utf-8 -*-
import requests, json
import unittest
import config
import mcserver
from time import sleep
class TestGetWorld(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.thread = mcserver.MinecraftServerThread()
        cls.thread.start()
        print "sleep 30 sec"
        sleep(30)
    @classmethod
    def tearDownClass(cls):
        cls.thread.stop()

    def test_getWorld(self):
        plugin_url= config.PluginUrl+":"+config.PluginPort+"/"+config.PluginPrefix+"/" \
            + "world"
        result = requests.get(plugin_url).text
        worlds = json.loads(result);
        self.assertEquals(len(worlds), 3);

