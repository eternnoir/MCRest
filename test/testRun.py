# -*- coding: utf-8 -*-
from testCases.test_startUp import TestPluginStart
from testCases.test_getWorld import TestGetWorld
import unittest

if __name__ == '__main__':
    unittest.TestLoader().loadTestsFromTestCase(TestPluginStart)
    unittest.main()
