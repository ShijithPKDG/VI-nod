# VI-nod Setup Guide

## Prerequisites
- Android Studio (latest version)
- JDK 17 or higher
- Firebase account

## Firebase Setup (IMPORTANT!)

### 1. Create Firebase Project
1. Go to https://console.firebase.google.com
2. Click "Add project"
3. Name it "VI-nod" (or any name)
4. Follow the setup wizard

### 2. Add Android App to Firebase
1. In Firebase Console, click "Add app" → Android
2. Package name: `com.vinod.app`
3. Download `google-services.json`
4. Place it in `app/` directory (same level as build.gradle)

### 3. Enable Authentication
1. In Firebase Console → Authentication → Sign-in method
2. Enable "Google" provider
3. Add your SHA-1 fingerprint:
   ```bash
   # Get debug SHA-1
   cd android
   ./gradlew signingReport
   ```
4. Copy the SHA-1 and add it in Firebase Console → Project Settings → Your apps

### 4. Get Web Client ID
1. Firebase Console → Project Settings → General
2. Scroll to "Your apps" section
3. Find "Web client ID" under OAuth 2.0 Client IDs
4. Copy it and replace in `app/src/main/res/values/strings.xml`:
   ```xml
   <string name="default_web_client_id">YOUR_ACTUAL_WEB_CLIENT_ID</string>
   ```

### 5. Create Firestore Database
1. Firebase Console → Firestore Database
2. Click "Create database"
3. Start in "Test mode" (for development)
4. Choose a location

### 6. Firestore Security Rules (Optional for production)
```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /users/{userId} {
      allow read, write: if request.auth != null;
    }
    match /groups/{groupId} {
      allow read: if request.auth != null && 
                     request.auth.uid in resource.data.members;
      allow create: if request.auth != null;
      allow update: if request.auth != null && 
                       request.auth.uid in resource.data.members;
    }
    match /messages/{messageId} {
      allow read, create: if request.auth != null;
    }
  }
}
```

## Build & Run

### 1. Open in Android Studio
- Open Android Studio
- File → Open → Select the project folder
- Wait for Gradle sync

### 2. Verify google-services.json
- Make sure `google-services.json` is in `app/` folder
- If missing, download from Firebase Console

### 3. Run the App
- Connect Android device or start emulator
- Click Run (green play button)
- Select device
- App should install and launch

## Testing the App

### Test Flow:
1. Launch app → Login screen appears
2. Click "Sign in with Google"
3. Select Google account
4. After login → Groups screen
5. Click + button → Create a group
6. Note the invite code shown in toast
7. Click group → Opens chat
8. Send messages

### Test with Friends:
1. Share the invite code with a friend
2. Friend clicks "Join Group" button
3. Friend enters the code
4. Both can now chat in the group!

## Troubleshooting

### "Sign in failed"
- Check SHA-1 is added in Firebase Console
- Verify `default_web_client_id` in strings.xml
- Make sure Google Sign-in is enabled in Firebase

### "google-services.json not found"
- Download from Firebase Console
- Place in `app/` directory (NOT `app/src/`)

### Build errors
- File → Invalidate Caches → Invalidate and Restart
- Clean project: Build → Clean Project
- Rebuild: Build → Rebuild Project

## Building APK

### Debug APK (for testing):
```bash
./gradlew assembleDebug
```
APK location: `app/build/outputs/apk/debug/app-debug.apk`

### Release APK (for distribution):
1. Create keystore:
   ```bash
   keytool -genkey -v -keystore vinod-release.keystore -alias vinod -keyalg RSA -keysize 2048 -validity 10000
   ```

2. Add to `app/build.gradle`:
   ```gradle
   android {
       signingConfigs {
           release {
               storeFile file("../vinod-release.keystore")
               storePassword "your_password"
               keyAlias "vinod"
               keyPassword "your_password"
           }
       }
       buildTypes {
           release {
               signingConfig signingConfigs.release
               minifyEnabled true
               proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
           }
       }
   }
   ```

3. Build:
   ```bash
   ./gradlew assembleRelease
   ```
   APK location: `app/build/outputs/apk/release/app-release.apk`

## Next Steps (Phase 2)

Once basic features work, you can add:
- Anonymous teasing feature
- Polls ("Who is always late?")
- Friendship scores & badges
- Inside jokes section
- Event planner
- Leaderboard

Check the codebase - it's structured to easily add these features!

## Support
If you face issues, check:
- Firebase Console for errors
- Android Studio Logcat for crash logs
- Ensure all Firebase services are enabled
