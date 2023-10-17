require recipes-core/images/core-image-base.bb

SUMMARY = "jpOS"
DESCRIPTION = "jpOS image"
LICENSE = "GPL-3.0-only"

IMAGE_INSTALL:append = "\
    ca-certificates \
    nano \
    networkmanager \
    ntp ntpdate \
    packagegroup-basic \
    packagegroup-fonts-truetype \
    packagegroup-jpos \
"

IMAGE_FEATURES:append = "\
    hwcodecs \
    weston \
"

IMAGE_FEATURES:remove = "\
    splash \
"
