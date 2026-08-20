# Setup — baby steps

## Part 1 — Install Android tools

1. Install Android Studio.
2. Open Android Studio once.
3. Let it install the Android SDK and Android SDK Platform Tools.
4. When Android Studio asks for a JDK, use the JDK bundled with Android Studio.
5. Restart Android Studio.

You do not need to install a separate JDK if Android Studio's bundled JDK is selected.

## Part 2 — Create Firebase project

1. Open the Firebase Console.
2. Create a Firebase project.
3. Add an Android app.
4. Use the exact package name from `android/app/build.gradle.kts`.
5. Download `google-services.json`.
6. Put the file here:

`android/app/google-services.json`

Do not rename it to `google-services (1).json` or similar.

## Part 3 — Enable Firebase products

For the first version, enable:

- Authentication
- Cloud Firestore
- Cloud Messaging (FCM), when push notifications are added

Do not put a Firebase Admin SDK service-account JSON file inside this repository.

## Part 4 — Open the Android project

1. Open Android Studio.
2. Choose **Open**.
3. Select the repository's `android` folder.
4. Wait for Gradle Sync to finish.
5. Put `google-services.json` inside `android/app/`.
6. Sync again.

## Part 5 — Connect a real phone

1. On the phone, enable Developer Options.
2. Enable USB debugging.
3. Connect the phone to the laptop with USB.
4. Accept the debugging prompt on the phone.
5. Select the phone in Android Studio.
6. Press Run.

## Part 6 — Remote-control permissions

The app intentionally requires Android's normal user-approved permissions.

- Screen sharing uses the Android MediaProjection permission dialog.
- Remote touch interaction uses an Accessibility Service that the phone owner enables in Android Settings.

Do not attempt to hide these permissions or silently enable them.

## Part 7 — Laptop dashboard

The initial dashboard is in `dashboard/index.html`.

You can open it directly in a browser for the UI prototype. The real internet connection and WebRTC signalling server will be connected in the next development phase.

## What is not finished yet

This repository currently provides the project foundation and permission flow. The production remote session requires a signalling server and WebRTC implementation for low-latency screen/video transport and command transport. Those pieces should be added after the Android app builds successfully.
