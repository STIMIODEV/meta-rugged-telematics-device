SUMMARY = "Packages to be added for the Yocto build with \"meta-telematics-device\" layer."

IMAGE_INSTALL:append = " \
	packagegroup-core-boot hostapd wpa-supplicant tzdata \
	openssl usbutils can-utils iproute2 gnupg dpkg \
 	python3 python3-pip python3-pyserial ethtool \
	ppp socat gpsd libgps gps-utils udev-extraconf sudo wireless-tools \
	bluez5 mmc-utils i2c-tools obexftp git \
	valgrind apt nano iw minicom iptables tcpdump wget iperf2 \
	iperf3 tar zip ntp ntpdate curl kernel-modules openobex \
	openssh unzip gzip dnsmasq libwebsockets \
	rtd-modem-debug-tools rtd-firmware \
	rtd-general rtd-mcu-bin rtd-services\
	rtd-library-source obd-dependency-library obd-xml-files \
	pulseaudio-server pulseaudio-module-bluetooth-discover \
	pulseaudio-module-bluez5-device pulseaudio-module-bluez5-discover \
	bluez5-noinst-tools bluez5-obex pulseaudio \
	phytool glibc-gconv-utf-16 \
	cmake \
	cronie bash perl \
	network-power-management uds-app \
	libubootenv libubootenv-bin \
	ntp \
	geolocator \
    u-boot-scr \
    kernel-devicetree \
    kernel-image-zimage \
    mqtt-simple-comm \
    reverse-ssh \
    firmware-update\
	config-update\
    can1 \
    can0 \
    device-hostname \
	rauc \
	datalogger \
	gps \
	stimio-services \
	ignitionstatus \
"
CORE_IMAGE_EXTRA_INSTALL += "openssh"
PACKAGE_EXCLUDE += " packagegroup-core-ssh-dropbear"
CORE_IMAGE_EXTRA_INSTALL += "packagegroup-core-ssh-openssh"

IMAGE_FEATURES += " tools-debug "


# Here we give sudo access to sudo members
update_sudoers(){
	sed -i 's/# %sudo/%sudo/' ${IMAGE_ROOTFS}/etc/sudoers
}

ROOTFS_POSTPROCESS_COMMAND += "update_sudoers;"

# Updates the Login password for the root user
inherit extrausers
EXTRA_USERS_PARAMS = "usermod -p '$(openssl passwd LMA2-stimio!)' root;"
