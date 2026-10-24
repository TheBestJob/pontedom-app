# PonteDom Android and browser demo

## Online demo
Enable GitHub Pages under Settings > Pages > Deploy from branch > main > root.
Expected URL: https://thebestjob.github.io/pontedom-app/

The phone frame is an iframe preview, not an Android emulator. If pontedom.pl prevents iframe embedding, use the Open live mobile site link.

## Android debug APK
Go to Actions > Build Android APK > Run workflow. Download the PonteDom-debug-APK artifact from a successful run. Extract and install app-debug.apk on an Android device.

This is a demonstration WebView app connected to the live https://pontedom.pl/ site. It requires internet and is not a signed Google Play release. Test forms, map, filters, language switching, file uploads and external links before distribution.
