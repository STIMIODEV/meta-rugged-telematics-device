import os
import time
import ctypes
from ctypes import *
libc = ctypes.CDLL("/usr/lib/libTelematics.so")

def find_ttyUSB_devices():
    ttyUSB_devices = []
    for filename in os.listdir('/dev'):
        if filename.startswith('ttyUSB'):
            ttyUSB_devices.append('/dev/' + filename)
    return ttyUSB_devices

if __name__ == "__main__":

    rc = libc.i_battery_init()
    #print(hex((rc + (1 << 32)) % (1 << 32)))

    rc = libc.init(1)
    #print(hex((rc + (1 << 32)) % (1 << 32)))

    while True:
        ttyUSB_list = find_ttyUSB_devices()
        if ttyUSB_list:
            # Check for newly added devices.......
            #print("Found ttyUSB devices:")
            os.system('systemctl start service-name.service')

        else:
            print("No ttyUSB devices found.")
            os.system('systemctl stop service-name.service')
        time.sleep(5)
