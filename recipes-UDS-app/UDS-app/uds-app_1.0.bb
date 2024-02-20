SUMMARY = "Lib Telematics Library for Telematics Device"
DESCRIPTION = "Recipe to compile the Lib Telematics Library for Telematics Gateway"
LICENSE = "CLOSED"

SRC_URI = "file://src"

FILES:${PN} = "${libdir} ${ROOT_HOME}"

PACKAGES = "${PN} ${PN}-dbg"
S = "${WORKDIR}/src"

INSANE_SKIP:${PN} = "ldflags"

do_install() {
	install -d ${D}${libdir}
        install -d ${D}${ROOT_HOME}
	install -m 755 ${WORKDIR}/src/*.so ${D}${libdir}
	install -m 755 ${WORKDIR}/src/UDS_APP ${D}${ROOT_HOME}
}
