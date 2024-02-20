SUMMARY = "LibTelematics Library for Telematics Device"
DESCRIPTION = "Recipe to compile the LibTelematics Library for Telematics Gateway"
LICENSE = "CLOSED"

SRC_URI = "file://Quectel_FW"

FILES:${PN} = "${ROOT_HOME}"

PACKAGES = "${PN} ${PN}-dbg"
S = "${WORKDIR}"

INSANE_SKIP:${PN} = "ldflags"
INSANE_SKIP:${PN} = "already-stripped"
INSANE_SKIP:${PN} += "file-rdeps"

do_install() {
        install -d ${D}${ROOT_HOME}
	install -d ${D}${ROOT_HOME}/Quectel_FW
        cp -R ${WORKDIR}/Quectel_FW/* ${D}${ROOT_HOME}/Quectel_FW
}
