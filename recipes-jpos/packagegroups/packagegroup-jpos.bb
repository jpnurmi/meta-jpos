DESCRIPTION = "jpOS"
LICENSE = "GPL-3.0-only"

inherit packagegroup

RDEPENDS:${PN} = "\
    jpos-launcher \
    jpos-settings \
    jpos-weather \
    wpa-cute \
"
