# Dark Klar for Android

_Browse like no one’s watching. The new Dark Klar automatically blocks a wide range of online trackers — from the moment you launch it to the second you leave it. Easily erase your history, passwords and cookies, so you won’t get followed by things like unwanted ads._ 

Dark Klar provides automatic ad blocking and tracking protection on an easy-to-use private browser.

**Forked from Focus, by Mozilla. This app contains an AMOLED theme by default.**

<a href="https://f-droid.org/packages/org.mozilla.klar/" target="_blank">
<img src="https://f-droid.org/badge/get-it-on.png" alt="Get it on F-Droid" height="90"/></a>

<a href='https://play.google.com/store/apps/details?id=org.mozilla.focus'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' height="90"/></a>

[Original Source](https://github.com/mozilla-mobile/focus-android)

## Build Instructions


1. Clone or Download the repository:

  ```shell
  git clone https://github.com/Android-Open-Source-Dark-Project/dark-klar
  ```

2. Import the project into Android Studio **or** build on the command line:

  ```shell
  ./gradlew clean app:assembleFocusArmDebug
  ```

3. Make sure to select the correct build variant in Android Studio:
**focusWebviewArmDebug** for ARM
**focusWebviewX86Debug** for X86
**focusWebviewAarch64Debug** for ARM64

## License


    This Source Code Form is subject to the terms of the Mozilla Public
    License, v. 2.0. If a copy of the MPL was not distributed with this
    file, You can obtain one at http://mozilla.org/MPL/2.0/
