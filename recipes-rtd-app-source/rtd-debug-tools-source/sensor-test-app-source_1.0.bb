SUMMARY = "Telematics Device Sensor Test Application Compilation"
DESCRIPTION = "Recipe to compile Sensor Test Application for Telematics Device"
LICENSE = "CLOSED"

SRC_URI = "file://src"

FILES:${PN} = "${ROOT_HOME}"

PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"
S = "${WORKDIR}/src"

INSANE_SKIP:${PN} = "ldflags"
RDEPENDS:${PN} = "rtd-library-source obd-dependency-library"
DEPENDS = "rtd-library-source obd-dependency-library"

do_install() {
        install -d ${D}${ROOT_HOME}
        install -m 755 ${S}/sensor_test ${D}${ROOT_HOME}
}
EXCLUDE_FROM_WORLD = "1"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
