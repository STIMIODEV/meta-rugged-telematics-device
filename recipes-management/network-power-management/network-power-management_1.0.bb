SUMMARY = "Lib Telematics Library for Telematics Device"
DESCRIPTION = "Recipe to compile the Lib Telematics Library for Telematics Gateway"
LICENSE = "CLOSED"

SRC_URI = "file://src"

FILES:${PN} = "${bindir} ${systemd_unitdir}"

PACKAGES = "${PN} ${PN}-dbg"
S = "${WORKDIR}/src"

INSANE_SKIP:${PN} = "ldflags"

do_install() {
	install -d ${D}${bindir}
        install -d ${D}${systemd_unitdir}
	install -d ${D}${systemd_unitdir}/system
	install -m 755 ${WORKDIR}/src/*.py ${D}${bindir}/
	install -m 755 ${WORKDIR}/src/*.service ${D}/${systemd_unitdir}/system/
}
