# -*- coding: utf-8 -*-
from testCases.test_startUp import TestPluginStart
import unittest

if __name__ == '__main__':
    unittest.TestLoader().loadTestsFromTestCase(TestPluginStart)
    unittest.main()
