FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
KERNEL_MODULE_INSTALL_PATH = "${WORKDIR}/image/lib/modules/${KERNEL_VERSION}/kernel"
KERNEL_MODULE_PATH = "${D}/iwtest/kernel-module/"

FILES:${KERNEL_PACKAGE_NAME}-modules += "/iwtest/kernel-module/*.ko"
SRC_URI += " \
	file://PATCH001-iW-PRGET-SC-R1.0-REL3.0-L5.15.52_i.MX_6ULL_Standard_Kernel_Customization.patch \
        file://PATCH003-iW-PRGET-SC-R1.0-REL3.0-L5.15.52_i.MX_6ULL_ACC_enabled.patch \
	file://PATCH006-iW-PRGET-SC-R1.0-REL3.0-L5.15.52_i.MX_6ULL_Kernel_TCAN_Bit_Error_and_Watermark.patch \
	file://PATCH007-iW-PRGET-SC-R1.0-REL3.0-L5.15.52_i.MX_6ULL_Kernel_TCAN_Watermark_and_Timeout.patch \
	file://PATCH010-iW-PRGET-SC-R1.0-REL3.0-L5.15.52_i.MX_6ULL_CAN_FD_Transmission.patch \
	file://PATCH011-iW-PRGET-SC-R1.0-REL3.1-L5.15.52_i.MX_6ULL_MRAM_Conf.patch \
	file://PATCH012-iW-PRGET-SC-R1.0-REL3.2-L5.15.52_i.MX_6ULL_OBDLIB_CAN_MULTITHREAD.patch \
	file://PATCH013-iW-Unified-SC-R1.0-REL3.2-L5.15.kernel_Name.patch \
	file://PATCH014-iW-Unified-SC-R1.0-REL3.3-L5.15_CANFD_HANG_ISSUE_SOLVED.patch \
	file://PATCH015-iW-Unified-SC-R1.0-REL3.4-L5.15_CANFD_OPTIMIZATION.patch \
	file://PATCH016-iW-Unified-SC-R1.0-REL3.5-L5.15_CANFD_Wakeup.patch \
	file://PATCH017-iW-Unified-SC-R1.0-REL3.6-L5.15_CONFIG_TUN_ENABLED.patch \
	file://PATCH019-iW-Unified-SC-R1.0-REL3.6-L5.15_CANFD_OPTIMZATION_2.patch \
"

INSANE_SKIP:${KERNEL_PACKAGE_NAME}-modules += "host-user-contaminated"

# Copy the defconfig before compilation
do_copy_defconfig () {
	install -d ${B}
	mkdir -p ${B}
	cp ${S}/arch/arm/configs/${IWG26I_KERNEL_DEFCONFIG} ${B}/.config
}

# Add task sequence
addtask copy_defconfig after do_unpack before do_preconfigure

# Preventing the autoloading of below modules
KERNEL_MODULE_PROBECONF += "tcan4x5x"
module_conf_tcan4x5x = "blacklist tcan4x5x"

# Copy the required kernel modules to "${KERNEL_MODULE_PATH}" path
do_install:append() {
	install -d ${KERNEL_MODULE_PATH}
	install -m 0644 ${KERNEL_MODULE_INSTALL_PATH}/net/can/j1939/can-j1939.ko ${KERNEL_MODULE_PATH}
	install -m 0644 ${KERNEL_MODULE_INSTALL_PATH}/drivers/net/can/m_can/tcan4x5x.ko ${KERNEL_MODULE_PATH}
}

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

COMPATIBLE_MACHINE = "(imx6ull-iwg26i)"
