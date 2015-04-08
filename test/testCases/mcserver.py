# -*- coding: utf-8 -*-
import threading
import os
import shutil
from time import sleep
class MinecraftServerThread(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)
        self.process = None

    def run(self):
        '''
        Remove setting data.
        banned-ips.json
        banned-players.json
        ops.json
        server.properties
        usercache.json
        whitelist.json
        world
        world_nether
        world_the_end
        '''
        try:
            os.remove('./banned-ips.json')
            os.remove('./banned-players.json')
            os.remove('./server.properties')
            os.remove('./usercache.json')
            os.remove('./whitelist.json')
            shutil.rmtree('./world')
            shutil.rmtree('./world_nether')
            shutil.rmtree('./world_the_end')
        except:
            print 'File not found.'
        import subprocess
        cmd = ['java', '-jar', 'spigot.jar']
        self.process = subprocess.Popen(cmd, stdout=subprocess.PIPE)
        for line in self.process.stdout:
            print line

    def stop(self):
        if self.process is not None:
            self.process.terminate()
            self.process = None
