#!/bin/sh

sleep 15

PKG=com.samsung.android.mdx
UID=$(pm list packages -U | grep $PKG | sed -n -e "s/package:$PKG uid://p")

pm grant $PKG android.permission.WRITE_SECURE_SETTINGS
pm grant $PKG android.permission.INTERACT_ACROSS_USERS
pm grant $PKG android.permission.BLUETOOTH_CONNECT
pm grant $PKG android.permission.SYSTEM_ALERT_WINDOW
pm grant $PKG android.permission.RECORD_AUDIO
pm grant $PKG android.permission.BATTERY_STATS

appops set --uid $UID LEGACY_STORAGE allow
appops set $PKG BLUETOOTH_CONNECT allow
appops set $PKG SYSTEM_ALERT_WINDOW allow
appops set $PKG RECORD_AUDIO allow
