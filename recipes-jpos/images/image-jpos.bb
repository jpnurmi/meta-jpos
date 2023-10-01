include recipes-core/images/core-image-base.bb

SUMMARY = "jpOS"
DESCRIPTION = "jpOS image"
LICENSE = "MIT"

IMAGE_INSTALL:append = " packagegroup-jpos"
