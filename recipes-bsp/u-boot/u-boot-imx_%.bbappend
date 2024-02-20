FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += " \
	file://PATCH001-iW-PRGET-SC-R1.0-REL3.0-L5.15.52_i.MX_6ULL_Standard_uBoot_Customization.patch \
	file://PATCH002-iW-PRGET-SC-R1.0-REL3.0-L5.15.52_i.MX_6ULL_Boot_Prints_Disabled.patch \
	file://PATCH004-iW-PRGET-SC-R1.0-REL3.1-L5.15.52_i.MX_6ULL_uBoot_Battery_Charger_Disabled_in_Serial_Mode.patch \
	file://PATCH005-iW-Unified-SC-R1.0-REL3.2-L5.15.52_i.MX_6ULL_UBoot_Name.patch \
	file://PATCH006-iW-Unified-SC-R1.0-REL3.3-L5.15.52_i.MX_6ULL_Boot_scr.patch \
	file://PATCH007-iW-Unified-SC-R1.0-REL3.4-L5.15.52_i.MX_6ULL_BT_Detected_After_Soft_Reboot.patch \
	file://PATCH008-iW-Unified-SC-R1.0-REL3.4-L5.15.52_i.MX_6ULL_Ethernet_Fixed_MAC_Address.patch \
"

COMPATIBLE_MACHINE = "(imx6ull-iwg26i)"

