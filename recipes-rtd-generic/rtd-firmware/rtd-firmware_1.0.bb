SUMMARY = "Firmware files for Telematics Device"
DESCRIPTION = "Recipe for copying the Firmware files for Telematics Device"
LICENSE = "CLOSED"

LIB_FIRMWARE_PATH = "${D}/${base_libdir}/firmware/brcm/"
LIB_FIRMWARE_PATH1 = "${D}/${base_libdir}/firmware/"

SRC_URI = "file://LICENCE.broadcom_bcm43xx \
    file://regulatory.db \
    file://regulatory.db.p7s \
    file://brcmfmac43455-sdio.bin \
    file://brcmfmac43455-sdio.clm_blob \
    file://brcmfmac43455-sdio.raspberrypi,3-model-b-plus.txt \
    file://brcmfmac43455-sdio.txt \
    file://epdc_E060SCM.fw \
    file://epdc_E60_V110.fw \
    file://epdc_E60_V220.fw \
    file://epdc_E97_V110.fw \
    file://epdc_ED060XH2C1.fw \
    file://BCM4345C0.1MW.hcd \
    file://sdma-imx6q.bin \
    file://sdma-imx7d.bin"

FILES:${PN} = "${base_libdir} ${sysconfdir}"

PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"
S = "${WORKDIR}"

INSANE_SKIP:${PN} = "ldflags"

do_install () {
        install -d ${D}/${sysconfdir}/firmware/
        install -d ${LIB_FIRMWARE_PATH}/
        install -d ${LIB_FIRMWARE_PATH1}/imx/epdc/
        install -d ${LIB_FIRMWARE_PATH1}/imx/sdma/
        install -m 755 BCM4345C0.1MW.hcd ${D}/${sysconfdir}/firmware
        install -m 755 LICENCE.broadcom_bcm43xx ${LIB_FIRMWARE_PATH1}/
        install -m 755 regulatory.db ${LIB_FIRMWARE_PATH1}/
        install -m 755 regulatory.db.p7s ${LIB_FIRMWARE_PATH1}/
        install -m 755 brcmfmac43455-sdio.bin ${LIB_FIRMWARE_PATH}/brcmfmac43455-sdio.iw,ull_iwg26i.bin
        install -m 755 brcmfmac43455-sdio.clm_blob ${LIB_FIRMWARE_PATH}/
        install -m 755 brcmfmac43455-sdio.raspberrypi,3-model-b-plus.txt ${LIB_FIRMWARE_PATH}/
        install -m 755 brcmfmac43455-sdio.txt ${LIB_FIRMWARE_PATH}/brcmfmac43455-sdio.iw,ull_iwg26i.txt
        install -m 755 epdc_E060SCM.fw ${LIB_FIRMWARE_PATH1}/imx/epdc
        install -m 755 epdc_E60_V110.fw ${LIB_FIRMWARE_PATH1}/imx/epdc
        install -m 755 epdc_E60_V220.fw ${LIB_FIRMWARE_PATH1}/imx/epdc
        install -m 755 epdc_E97_V110.fw ${LIB_FIRMWARE_PATH1}/imx/epdc
        install -m 755 epdc_ED060XH2C1.fw ${LIB_FIRMWARE_PATH1}/imx/epdc
        install -m 755 sdma-imx6q.bin ${LIB_FIRMWARE_PATH1}/imx/sdma
        install -m 755 sdma-imx7d.bin ${LIB_FIRMWARE_PATH1}/imx/sdma
}

EXCLUDE_FROM_WORLD = "1"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
