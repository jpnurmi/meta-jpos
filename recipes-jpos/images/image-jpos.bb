require recipes-core/images/core-image-base.bb

SUMMARY = "jpOS"
DESCRIPTION = "jpOS image"
LICENSE = "GPL-3.0-only"

IMAGE_INSTALL += "\
    packagegroup-fonts-truetype \
    packagegroup-jpos \
"

IMAGE_FEATURES += "\
    hwcodecs \
    splash \
    ssh-server-dropbear \
    weston \
"
