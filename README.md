# Dark Focus for Android

[![Build Status](https://travis-ci.org/mozilla-mobile/focus-android.svg?branch=master)](https://travis-ci.org/mozilla-mobile/focus-android)
[![Task Status](https://github.taskcluster.net/v1/repository/mozilla-mobile/focus-android/master/badge.svg)](https://github.taskcluster.net/v1/repository/mozilla-mobile/focus-android/master/latest)
[![codecov](https://codecov.io/gh/mozilla-mobile/focus-android/branch/master/graph/badge.svg)](https://codecov.io/gh/mozilla-mobile/focus-android/branch/master)
[![Sputnik](https://sputnik.ci/conf/badge)](https://sputnik.ci/app#/builds/mozilla-mobile/focus-android)


_Browse like no one’s watching. The new Dark Focus automatically blocks a wide range of online trackers — from the moment you launch it to the second you leave it. Easily erase your history, passwords and cookies, so you won’t get followed by things like unwanted ads._ 

Dark Focus provides automatic ad blocking and tracking protection on an easy-to-use private browser.

## Build Instructions


1. Clone or Download the repository:

  ```shell
  git clone https://github.com/Android-Open-Source-Dark-Project/focus-android
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
