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
        print "sleep 90 sec"
        sleep(90)

    @classmethod
    def tearDownClass(cls):
        print "Trying to stop thread "
        cls.thread.stop()
        cls.thread.join()
        print "Thread stoped"

    def test_up(self):
        plugin_url= config.PluginUrl+":"+config.PluginPort+"/"+config.PluginPrefix+"/"
        result = requests.get(plugin_url).text
        server = json.loads(result);
        self.assertTrue("Bukkit" in server['name'])

    def test_getWorld(self):
        plugin_url= config.PluginUrl+":"+config.PluginPort+"/"+config.PluginPrefix+"/" \
            + "world"
        result = requests.get(plugin_url).text
        worlds = json.loads(result);
        self.assertEquals(len(worlds), 3);


