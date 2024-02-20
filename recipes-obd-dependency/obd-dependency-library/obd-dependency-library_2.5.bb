SUMMARY = "OBD2 Library"
DESCRIPTION = "Recipe file for OBD2 file compilation"
LICENSE = "CLOSED"

SRC_URI = " file://libcrypto.so.1.0.0 \
           file://libcrypto.so.1.0.2 \
           file://libssl.so.1.0.0 \
           file://libssl.so.1.0.2 \
           file://libz.so \
          "

FILES:${PN} = "${libdir}"

PACKAGES = "${PN} ${PN}-dbg"
S = "${WORKDIR}"
INSANE_SKIP:${PN}:append = "already-stripped"
RDEPENDS:${PN} = "libxml2 zlib libidn2 nettle gnutls"
DEPENDS = "libxml2 zlib libidn2 nettle gnutls"

do_install() {
        install -d ${D}${libdir}
        install -m 755 libcrypto.so.1.0.0 libcrypto.so.1.0.2 libssl.so.1.0.0 libssl.so.1.0.2 ${D}${libdir}
}
PROVIDES = "libcrypto libssl"
RPROVIDES:${PN} = "libcrypto libssl"
