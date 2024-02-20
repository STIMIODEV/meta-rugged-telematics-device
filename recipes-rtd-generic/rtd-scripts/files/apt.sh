cp /sbin/ldconfig /sbin/.debug
dpkg --add-architecture armhf
apt --fix-broken install -y
echo -e "deb [arch=armhf] http://deb.debian.org/debian unstable main\ndeb [arch=armhf] http://deb.debian.org/debian-debug unstable-debug main\ndeb [arch=armhf] http://deb.debian.org/debian-ports unstable main" > /etc/apt/sources.list
apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 648ACFD622F3D138
apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 0E98404D386FA1D9
apt-key adv --keyserver keyserver.ubuntu.com --recv-keys B523E5F3FC4E5F2C
apt-get update
apt-get install gcc -y
cp /sbin/.debug/ldconfig /sbin/
apt-get install gcc -y
