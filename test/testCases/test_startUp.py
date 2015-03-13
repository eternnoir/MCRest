# -*- coding: utf-8 -*-
import requests, json
import unittest
import config
import mcserver
from time import sleep
class TestPluginStart(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        cls.thread = mcserver.MinecraftServerThread()
        cls.thread.start()
        print "sleep 30 sec"
        sleep(30)

    @classmethod
    def tearDownClass(cls):
        print "Trying to stop thread "
        cls.thread.stop()
        cls.thread.join()
        print "Thread stoped"

    def test_up(self):
        plugin_url= config.PluginUrl+":"+config.PluginPort+"/"+config.PluginPrefix+"/"
        result = requests.get(plugin_url).text
        self.assertEquals("Hello MCRest.", result);

    def test_getWorld(self):
        plugin_url= config.PluginUrl+":"+config.PluginPort+"/"+config.PluginPrefix+"/" \
            + "world"
        result = requests.get(plugin_url).text
        worlds = json.loads(result);
        self.assertEquals(len(worlds), 3);


