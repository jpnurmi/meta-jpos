SUMMARY = "wpaCute - A graphical wpa_supplicant front end"
HOMEPAGE = "https://github.com/loh-tar/wpa-cute"
LICENSE = "BSD-3-Clause"

inherit qt6-qmake

SRC_URI = "git://github.com/loh-tar/wpa-cute.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git/src"
LIC_FILES_CHKSUM = "file://../COPYING;md5=6e8ce79ea24f904a51035cf427fdf154"

DEPENDS += "qtbase qtsvg"

RDEPENDS:${PN} += " \
    qtbase \
    qtsvg \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/wpa-cute ${D}${bindir}
}
