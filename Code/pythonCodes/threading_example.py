import threading

class MyThread(threading.Thread):
    def run(self):
        for i in range(5):
            print(i)

thread = MyThread()
thread.start()
thread.join()
