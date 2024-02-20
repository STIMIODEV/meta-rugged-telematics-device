FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = "file://wpa_supplicant.conf"

do_install:append() {
        install -m 0644 ${WORKDIR}/wpa_supplicant.conf ${D}${sysconfdir}
}

