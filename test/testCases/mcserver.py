# -*- coding: utf-8 -*-
import threading
class MinecraftServerThread(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)
        self.process = None

    def run(self):
        import subprocess
        cmd = ['java', '-jar', 'spigot-1.8.jar']
        self.process = subprocess.Popen(cmd, stdout=subprocess.PIPE)
        for line in self.process.stdout:
            line = line

    def stop(self):
        print "Trying to stop thread "
        if self.process is not None:
            self.process.terminate()
            self.process = None


