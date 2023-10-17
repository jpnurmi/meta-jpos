FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://wifi.nmconnection"
FILES:${PN}:append = " ${sysconfdir}/NetworkManager/system-connections/wifi.nmconnection"

JPOS_WIFI_SSID ?= ""
JPOS_WIFI_PSK ?= ""

do_install:append() {
    sed -i -e 's#[@]JPOS_WIFI_SSID[@]#${JPOS_WIFI_SSID}#' ${WORKDIR}/wifi.nmconnection
    sed -i -e 's#[@]JPOS_WIFI_PSK[@]#${JPOS_WIFI_PSK}#' ${WORKDIR}/wifi.nmconnection

    install -d ${D}${sysconfdir}/NetworkManager/system-connections
    install -m 0600 ${WORKDIR}/wifi.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections/
}
