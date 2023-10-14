SUMMARY = "Settings"
HOMEPAGE = "https://github.com/jpnurmi/jpos-settings"
LICENSE = "GPL-3.0-only"

inherit qt6-cmake

SRC_URI = "git://github.com/jpnurmi/jpos-settings.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-3.0-only.txt;md5=75d892af193fd5a298f724c4377d8f62"
