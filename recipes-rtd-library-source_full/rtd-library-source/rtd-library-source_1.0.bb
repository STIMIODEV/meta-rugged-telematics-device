SUMMARY = "LibRugged Telematics Library for Rugged Telematics Device"
DESCRIPTION = "Recipe to compile the LibRugged Telematics Library for Rugged Telematics Gateway"
LICENSE = "CLOSED"

SRC_URI = "file://CMakeLists.txt file://src file://inc"

FILES:${PN} = "${libdir}"

PACKAGES = "${PN} ${PN}-dbg"
S = "${WORKDIR}"


SOLIBS = ".so"
FILES_SOLIBSDEV = ""

inherit cmake

BBCLASSEXTEND = "native nativesdk"

do_install:append() {
    install -d ${D}${includedir}
    install -m 0644 ${WORKDIR}/inc/libcommon/* ${D}${includedir}
    install -m 0644 ${WORKDIR}/inc/rugged_telematics_lib/* ${D}${includedir}
    install -m 0644 ${WORKDIR}/inc/xml/* ${D}${includedir}
}
FILES:${PN} += "${libdir}/*"
FILES:${PN} += "${includedir}/*"