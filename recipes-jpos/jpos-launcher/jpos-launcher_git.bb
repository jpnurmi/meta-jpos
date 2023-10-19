SUMMARY = "jpOS Launcher"
HOMEPAGE = "https://github.com/jpnurmi/jpos-launcher"
LICENSE = "GPL-3.0-only"

inherit flutter-app

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI = "\
    git://github.com/jpnurmi/jpos-launcher.git;protocol=https;branch=main \
    file://jpos-launcher.sh \
"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-3.0-only.txt;md5=75d892af193fd5a298f724c4377d8f62"

PUBSPEC_APPNAME = "jpos_launcher"

RDEPENDS:${PN}:append = "\
    flutter-wayland-client \
"

FILES:${PN}:append = " ${bindir}/jpos-launcher"

do_install:append() {
    sed -i -e 's#[@]FLUTTER_SDK_VERSION[@]#${FLUTTER_SDK_VERSION}#' ${WORKDIR}/jpos-launcher.sh

    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/jpos-launcher.sh ${D}${bindir}/jpos-launcher
}
