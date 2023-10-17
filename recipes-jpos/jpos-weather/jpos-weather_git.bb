SUMMARY = "jpOS Weather"
HOMEPAGE = "https://github.com/jpnurmi/jpos-weather"
LICENSE = "GPL-3.0-only"

inherit cargo_bin

do_configure[network] = "1"
do_compile[network] = "1"

SRC_URI = "git://github.com/jpnurmi/jpos-weather.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-3.0-only.txt;md5=75d892af193fd5a298f724c4377d8f62"

DEPENDS = "\
    openssl \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/icons:"
SRC_URI:append = "\
    file://24x24/jpos-weather.png \
    file://48x48/jpos-weather.png \
    file://192x192/jpos-weather.png \
"
FILES:${PN}:append = "\
    ${datadir}/icons/hicolor/*/apps/jpos-weather.png \
"
do_install:append() {
    for size in 24x24 48x48 192x192; do
        install -d ${D}${datadir}/icons/hicolor/${size}/apps
        install ${WORKDIR}/${size}/jpos-weather.png ${D}${datadir}/icons/hicolor/${size}/apps
    done
}
