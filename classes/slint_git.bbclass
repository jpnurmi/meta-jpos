HOMEPAGE = "https://slint-ui.com/"
LICENSE = "GPLv3 | Slint-Commercial"

inherit cargo

do_configure[network] = "1"
do_compile[network] = "1"

EXTRA_CARGO_FLAGS = "\
    ${@oe.utils.conditional('SLINT_PACKAGE', '', '', '--package "${SLINT_PACKAGE}"', d)} \
"

SRC_URI = "git://github.com/slint-ui/slint.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=c12ffea0eacb376c3ba8c0601fe78d5d"

S = "${WORKDIR}/git"

# EXTRA_CARGO_FLAGS += "\
#     --no-default-features \
#     --features slint/backend-linuxkms \
# "

# DEPENDS = "\
#     libdrm \
#     libinput \
#     libxkbcommon \
#     seatd \
#     udev \
#     virtual/egl \
#     virtual/libgbm \
# "
