DESCRIPTION = "A framework for dark-mode and light-mode transitions on Unix-like desktops."
HOMEPAGE = "https://darkman.whynothugo.nl/"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENCE;md5=2ede528e2b89412cbfa466590b31c8f7"

SRC_URI = "git://gitlab.com/WhyNotHugo/darkman;branch=main;protocol=https"
SRCREV = "ec68820495fcb7137310c166052dab86b0d940c4"
UPSTREAM_CHECK_COMMITS = "1"

GO_IMPORT = "gitlab.com/WhyNotHugo/darkman"

do_compile[network] = "1"

inherit go systemd

RDEPENDS:${PN}:append = " bash"
RDEPENDS:${PN}-dev:append = " bash"

SYSTEMD_SERVICE:${PN} = "darkman.service"
FILES:${PN}:append = "\
    ${systemd_unitdir}/system/darkman.service \
    ${datadir}/dbus-1/services/nl.whynothugo.darkman.service \
    ${datadir}/dbus-1/services/org.freedesktop.impl.portal.desktop.darkman.service \
    ${datadir}/xdg-desktop-portal/portals/darkman.portal \
"

do_compile() {
    cd ${S}/src/${GO_IMPORT}
    ${GO} build -ldflags "-X main.Version=git" ./cmd/darkman
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/src/${GO_IMPORT}/darkman ${D}${bindir}/darkman

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/src/${GO_IMPORT}/darkman.service ${D}${systemd_system_unitdir}

    install -d ${D}${datadir}/dbus-1/services
    install -m 0644 ${S}/src/${GO_IMPORT}/contrib/dbus/nl.whynothugo.darkman.service ${D}${datadir}/dbus-1/services/
    install -m 0644 ${S}/src/${GO_IMPORT}/contrib/dbus/org.freedesktop.impl.portal.desktop.darkman.service ${D}${datadir}/dbus-1/services/

    install -d ${D}${datadir}/xdg-desktop-portal/portals
    install -m 0644 ${S}/src/${GO_IMPORT}/contrib/portal/darkman.portal ${D}${datadir}/xdg-desktop-portal/portals/
}
