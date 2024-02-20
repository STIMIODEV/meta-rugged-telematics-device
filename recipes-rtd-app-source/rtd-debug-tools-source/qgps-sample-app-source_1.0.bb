SUMMARY = "Telematics Device QGPS Test Application Compilation"
DESCRIPTION = "Recipe to compile the QGPS Test Application for Telematics Device"
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
	install -m 755 ${S}/QGPS_APP ${D}${ROOT_HOME}
}
