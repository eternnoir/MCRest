# -*- coding: utf-8 -*-
from testCases.test_startUp import TestPluginStart
from testCases import mcserver
import unittest

if __name__ == '__main__':

    unittest.TestLoader().loadTestsFromTestCase(TestPluginStart)
    unittest.main()
