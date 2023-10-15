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
