SUMMARY = "Telematics Device Sample Application"
DESCRIPTION = "Recipe for Telematics Device Sample Application Compilation"
LICENSE = "CLOSED"

SRC_URI = "file://src"

FILES:${PN} = "${ROOT_HOME}"

S = "${WORKDIR}/src"

INSANE_SKIP:${PN} = "ldflags"
RDEPENDS:${PN} = "rtd-library-source obd-dependency-library"
DEPENDS = "rtd-library-source obd-dependency-library"

do_install() {
        install -d ${D}${ROOT_HOME}/
        install -m 755 sample_application ${D}${ROOT_HOME}/
}
EXCLUDE_FROM_WORLD = "1"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

