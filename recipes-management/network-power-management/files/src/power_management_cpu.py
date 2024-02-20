import sys
import os
import ctypes
import time
from ctypes import *

libc = ctypes.CDLL("/usr/lib/libTelematics.so")

rc = libc.ign_pin_status_check_enable()
#print("ign_pin_status_check_enable")
print(hex((rc + (1 << 32)) % (1 << 32)))

counter = 0

while True:
    rc = libc.ignition_pin_status()
    print("Ignition PIN Status")
    print(hex((rc + (1 << 32)) % (1 << 32)))

    if rc == -1:
        #print(counter)
        time.sleep(10)
        if counter == 5:
            print("Device going to sleep mode. Ignition as a wakeup source\n")
            #print("Enable ignition wakeup")
            rc = libc.config_ignition_wakeup(1)
            #print("Push device to sleep")
            rc = libc.push_device_to_sleep()
            counter = 0
    else:
        print("IGNITION IS ON")
        counter = 0
        time.sleep(5)

    counter += 1  # Increment the counter at the end of each iteration
