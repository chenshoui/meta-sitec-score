# Copyright (C) 2013, 2014 Freescale Semiconductor

DESCRIPTION = "Bootloader for i.MX platforms"
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCBRANCH = "imx_v2015.04_4.1.15_1.0.0_ga"
SRCREV = "d7d7c4312b71dd3879fa8640b23f6a5bac30e303"
UBOOT_SRC ?= "git://git.freescale.com/imx/uboot-imx.git;protocol=git"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PR="r2"
LOCALVERSION = "-${PR}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx6ul|mx7)"

SRC_URI += "file://0001-score-Add-board-score.patch"
SRC_URI += "file://0002-arch-arm-Kconfig-Add-score-board-to-arm-configuratio.patch"
SRC_URI += "file://0003-board-score-Add-methode-for-getting-the-cs-of-spi.patch"
SRC_URI += "file://0004-config-score_defconfig-Add-option-for-SPINOR.patch"
SRC_URI += "file://0005-include-configs-score-Cleaning-Up.patch"
SRC_URI += "file://0006-tools-env-env_flags-Add-ARRAY_SIZE-macro.patch"

