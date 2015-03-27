# -*- coding: utf-8 -*-
import requests, json
import unittest
import config
import mcserver
from time import sleep
class TestWhiteList(unittest.TestCase):

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

    def test_getWhiteList(self):
        self.getWhitListResult()

    def test_enableWhiteList(self):
        plugin_url= config.PluginUrl+":"+config.PluginPort+"/"+config.PluginPrefix+"/" \
            + "whitelist/enable"
        payload = {'enable': True}
        result = requests.post(plugin_url,data=json.dumps( payload)).text
        whitelist= json.loads(result)
        self.assertEqual(whitelist["result"] , "OK")
        whitelistResult = self.getWhitListResult()
        self.assertTrue(whitelistResult["enabled"])


    def test_disableWhiteList(self):
        plugin_url= config.PluginUrl+":"+config.PluginPort+"/"+config.PluginPrefix+"/" \
            + "whitelist/enable"
        payload = {'enable': False}
        result = requests.post(plugin_url,data=json.dumps( payload)).text
        whitelist= json.loads(result)
        self.assertEqual(whitelist["result"] , "OK")
        whitelistResult = self.getWhitListResult()
        self.assertFalse(whitelistResult["enabled"])

    def getWhitListResult(self):
        '''
        get whitelist object
        '''
        plugin_url= config.PluginUrl+":"+config.PluginPort+"/"+config.PluginPrefix+"/" \
            + "whitelist"
        result = requests.get(plugin_url).text
        whitelist= json.loads(result)
        return whitelist


