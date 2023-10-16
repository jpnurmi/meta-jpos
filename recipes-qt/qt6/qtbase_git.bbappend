QT_QPA_DEFAULT_PLATFORM = "wayland"
PACKAGECONFIG:remove:rpi = "examples tests x11"
PACKAGECONFIG:append:rpi = " fontconfig harfbuzz tslib"
