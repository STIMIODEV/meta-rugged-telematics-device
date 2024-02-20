SUMMARY = "MCU Test Application for Rugged Telematics Device"
DESCRIPTION = "Recipe to compile the MCU Test Application for Rugged Telematics Device"
LICENSE = "CLOSED"

SRC_URI = "file://src"

FILES:${PN} = "${ROOT_HOME}"

S = "${WORKDIR}/src"

INSANE_SKIP:${PN} = "ldflags"
RDEPENDS:${PN} = "rtd-library-source obd-dependency-library"
DEPENDS = "rtd-library-source obd-dependency-library"

do_install() {
        install -d ${D}${ROOT_HOME}/
        install -m 755 mcu_test_app ${D}${ROOT_HOME}/
}
