SUMMARY = "Test Applications and Tools for Telematics Device"
DESCRIPTION = "Recipe for Telematics Device Test Applications and Tools"
LICENSE = "CLOSED"

SRC_URI = "file://tools/AT-Test \
	file://tools/QLog \
	file://tools/QFirehose \
"

FILES:${PN} = "${ROOT_HOME} ${bindir}"
S = "${WORKDIR}"

INSANE_SKIP:${PN} = "ldflags"
RDEPENDS:${PN} = "rtd-library-source"
DEPENDS = "rtd-library-source"

do_install() {
	install -d ${D}${ROOT_HOME}
	install -d ${D}${bindir}
	install -m 755 ${S}/tools/AT-Test ${D}${ROOT_HOME}
	install -m 755 ${S}/tools/QLog ${D}${ROOT_HOME}
	install -m 755 ${S}/tools/QFirehose ${D}${bindir}
}

EXCLUDE_FROM_WORLD = "1"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
