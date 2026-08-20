# Remote Control

A personal Android remote-control project for controlling an Android phone from a laptop over the internet.

## Architecture

- `android/` — Android phone client (Kotlin)
- `dashboard/` — laptop web dashboard
- `server/` — real-time signalling/backend (to be added in the next phase)

## Important Android permissions

The phone app uses Android's user-approved screen-capture flow (`MediaProjection`) and an `AccessibilityService` for remote touch interaction. Android will show permission/setup screens; the app is not designed to hide or bypass them.

## Firebase

Firebase is used for authentication, device registration, pairing metadata and signalling support. Do not put Firebase Admin/service-account credentials in the Android app or browser.

For Android, Firebase's `google-services.json` belongs at:

`android/app/google-services.json`

Download it from Firebase Console after registering the Android app with the exact package name used by this project.

## Setup

See `docs/SETUP.md` for the beginner-friendly setup guide.
