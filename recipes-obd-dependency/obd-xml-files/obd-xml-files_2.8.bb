SUMMARY = "Node Red"
DESCRIPTION = "Recipe file for Nodered Scripts"
LICENSE = "CLOSED"

SRC_URI = "file://src"

FILES:${PN} = "${ROOT_HOME}"
S = "${WORKDIR}/src"

#FILES:${PN} = "/*.xml"
#S = "${WORKDIR}"

do_install() {
	install -d ${D}${ROOT_HOME}
	install -m 755 ${S}/*.xml ${D}${ROOT_HOME}
}
