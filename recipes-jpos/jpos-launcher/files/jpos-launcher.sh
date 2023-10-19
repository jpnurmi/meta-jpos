#!/bin/sh

JPOS_LAUNCHER=/usr/share/jpos_launcher/@FLUTTER_SDK_VERSION@/release

export LD_LIBRARY_PATH=$JPOS_LAUNCHER/lib

/usr/bin/flutter-client --bundle=$JPOS_LAUNCHER --fullscreen
