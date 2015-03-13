# -*- coding: utf-8 -*-
import threading
from time import sleep
class MinecraftServerThread(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)
        self.process = None

    def run(self):
        import subprocess
        cmd = ['java', '-jar', 'spigot.jar']
        self.process = subprocess.Popen(cmd, stdout=subprocess.PIPE)
        for line in self.process.stdout:
            line = line

    def stop(self):
        if self.process is not None:
            self.process.terminate()
            self.process = None
        sleep(10)


