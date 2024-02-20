import sys
import os
import ctypes
import time
from ctypes import *

libc = ctypes.CDLL("/usr/lib/libTelematics.so")

rc = libc.ign_pin_status_check_enable()
print("ign_pin_status_check_enable")
print(hex((rc + (1 << 32)) % (1 << 32)))

counter = 0

while True:
    rc = libc.ignition_pin_status()
    print("Ignition PIN Status")
    print(hex((rc + (1 << 32)) % (1 << 32)))

    if rc == -1:
        print(counter)
        time.sleep(10)
        if counter == 5:
            print("Device going to DPDM mode. Ignition as a wakeup source\n") 
            os.system('i2ctransfer -y 0 w10@0x76 0xB0 0x01 0x02 0x04 0x40 0x0 0x0 0x0 0x0 0x0')
            break  # Exit the loop after 5 iterations
    else:
        print("IGNITION IS ON")
        counter = 0
        time.sleep(5)

    counter += 1  # Increment the counter at the end of each iteration
