SUMMARY = "Lib Telematics Library for Telematics Device"
DESCRIPTION = "Recipe to compile the Lib Telematics Library for Telematics Gateway"
LICENSE = "CLOSED"

SRC_URI = "file://src"

FILES:${PN} = "${libdir}"

PACKAGES = "${PN} ${PN}-dbg"
S = "${WORKDIR}/src"

INSANE_SKIP:${PN} = "ldflags"
RDEPENDS:${PN} = "obd-dependency-library"
DEPENDS = "obd-dependency-library"

do_install() {
	install -d ${D}${libdir}
	install -m 755 libTelematics.so ${D}${libdir}
}
