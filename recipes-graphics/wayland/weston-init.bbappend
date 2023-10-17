FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://weston.ini"

JPOS_KB_LAYOUT ?= "us"

do_configure:prepend() {
    sed -i -e 's#[@]JPOS_KB_LAYOUT[@]#${JPOS_KB_LAYOUT}#' ${WORKDIR}/weston.ini
}
