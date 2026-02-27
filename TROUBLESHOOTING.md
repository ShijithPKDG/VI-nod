# 🔧 VI-nod Troubleshooting Guide

## Common Issues & Solutions

### 🔴 Build & Sync Issues

#### "google-services.json not found"
**Symptoms**: Build fails with error about missing google-services.json

**Solutions**:
1. Download `google-services.json` from Firebase Console
2. Place it in `app/` folder (NOT `app/src/`)
3. In Android Studio, you should see it at: `app/google-services.json`
4. Sync Gradle: File → Sync Project with Gradle Files

#### "Gradle sync failed"
**Symptoms**: Red errors in build.gradle files

**Solutions**:
1. File → Invalidate Caches → Invalidate and Restart
2. Delete `.gradle` folder in project root
3. File → Sync Project with Gradle Files
4. If still fails, check internet connection
5. Try: Build → Clean Project → Rebuild Project

#### "Duplicate class found"
**Symptoms**: Build error about duplicate classes

**Solutions**:
1. Build → Clean Project
2. Build → Rebuild Project
3. Delete `app/build` folder
4. Sync Gradle again

---

### 🔴 Authentication Issues

#### "Sign in failed" or "Sign in cancelled"
**Symptoms**: Google sign-in doesn't work, returns to login screen

**Solutions**:
1. **Check SHA-1 fingerprint**:
   ```bash
   ./gradlew signingReport
   ```
   Copy SHA-1 and add to Firebase Console → Project Settings → Your apps

2. **Verify Web Client ID**:
   - Firebase Console → Project Settings → General
   - Copy "Web client ID"
   - Update in `app/src/main/res/values/strings.xml`:
     ```xml
     <string name="default_web_client_id">YOUR_ACTUAL_ID_HERE</string>
     ```

3. **Enable Google Sign-in**:
   - Firebase Console → Authentication → Sign-in method
   - Make sure Google is enabled

4. **Check package name**:
   - Must be `com.vinod.app` in Firebase Console
   - Check `app/build.gradle`: `applicationId "com.vinod.app"`

#### "API not enabled" error
**Symptoms**: Error about Google Sign-In API

**Solutions**:
1. Go to Google Cloud Console
2. Enable "Google Sign-In API"
3. Wait 5 minutes for propagation
4. Try again

---

### 🔴 Firebase Issues

#### "Permission denied" in Firestore
**Symptoms**: Can't read/write to Firestore

**Solutions**:
1. Firebase Console → Firestore Database → Rules
2. Make sure rules allow authenticated users:
   ```javascript
   rules_version = '2';
   service cloud.firestore {
     match /databases/{database}/documents {
       match /{document=**} {
         allow read, write: if request.auth != null;
       }
     }
   }
   ```
3. Click "Publish"

#### "Firestore not initialized"
**Symptoms**: App crashes when trying to use Firestore

**Solutions**:
1. Make sure `google-services.json` is in place
2. Check Firebase Console → Firestore Database is created
3. Rebuild app
4. Check Logcat for specific error

#### Messages not appearing in real-time
**Symptoms**: Have to refresh to see new messages

**Solutions**:
1. Check internet connection
2. Verify Firestore rules allow read access
3. Check Logcat for listener errors
4. Try force-closing and reopening app

---

### 🔴 APK Installation Issues

#### "App not installed"
**Symptoms**: APK won't install on phone

**Solutions**:
1. **Enable Unknown Sources**:
   - Settings → Security → Unknown Sources → Enable
   - OR Settings → Apps → Special Access → Install Unknown Apps

2. **Uninstall old version**:
   - If you have an old version, uninstall it first
   - Then install new APK

3. **Check storage space**:
   - Make sure phone has at least 50 MB free

4. **Verify APK integrity**:
   - Re-download or re-build APK
   - Transfer via USB instead of wireless

#### "Parse error" when installing
**Symptoms**: "There was a problem parsing the package"

**Solutions**:
1. APK might be corrupted - rebuild it
2. Make sure APK is for correct architecture
3. Try transferring via USB cable
4. Check if phone OS version is compatible (Android 7.0+)

---

### 🔴 Runtime Crashes

#### App crashes on launch
**Symptoms**: App opens then immediately closes

**Solutions**:
1. **Check Logcat**:
   - Android Studio → Logcat tab
   - Look for red error messages
   - Search for "FATAL EXCEPTION"

2. **Common causes**:
   - Missing google-services.json
   - Wrong package name
   - Firebase not initialized

3. **Clean install**:
   - Uninstall app completely
   - Rebuild and reinstall

#### App crashes when creating group
**Symptoms**: Crash when clicking create group button

**Solutions**:
1. Check Firestore is created and accessible
2. Verify user is authenticated
3. Check Logcat for specific error
4. Verify Firestore rules allow write access

#### App crashes when sending message
**Symptoms**: Crash when clicking send button

**Solutions**:
1. Check internet connection
2. Verify Firestore rules
3. Make sure message text is not empty
4. Check Logcat for error details

---

### 🔴 UI Issues

#### Blank screen after login
**Symptoms**: White/blank screen after successful login

**Solutions**:
1. Check if user profile was created in Firestore
2. Verify navigation is set up correctly
3. Check Logcat for errors
4. Try force-closing and reopening

#### Messages not scrolling to bottom
**Symptoms**: New messages appear but don't auto-scroll

**Solutions**:
1. This is expected behavior in current version
2. Manually scroll down to see new messages
3. Or add auto-scroll in ChatFragment

#### Keyboard covers input box
**Symptoms**: Can't see what you're typing

**Solutions**:
1. Add to AndroidManifest.xml in MainActivity:
   ```xml
   android:windowSoftInputMode="adjustResize"
   ```

---

### 🔴 Network Issues

#### "Network error" or "Connection failed"
**Symptoms**: Can't connect to Firebase

**Solutions**:
1. Check internet connection
2. Try switching between WiFi and mobile data
3. Check if Firebase services are down (status.firebase.google.com)
4. Verify firewall isn't blocking Firebase
5. Try on different network

#### Slow message delivery
**Symptoms**: Messages take long to appear

**Solutions**:
1. Check internet speed
2. Verify Firestore is in nearest region
3. Check if too many listeners are active
4. Consider implementing pagination

---

### 🔴 Development Issues

#### Android Studio is slow
**Solutions**:
1. Increase memory: Help → Edit Custom VM Options
   ```
   -Xmx4096m
   ```
2. Disable unused plugins
3. Close unnecessary projects
4. Clear cache: File → Invalidate Caches

#### Emulator is slow
**Solutions**:
1. Use physical device instead
2. Enable hardware acceleration
3. Reduce emulator RAM
4. Use x86 system image

#### Changes not reflecting
**Solutions**:
1. Build → Clean Project
2. Build → Rebuild Project
3. Uninstall app from device
4. Reinstall fresh

---

### 🔴 Firebase Console Issues

#### Can't find Web Client ID
**Location**:
1. Firebase Console
2. Project Settings (gear icon)
3. General tab
4. Scroll to "Your apps"
5. Look for "Web client ID" under OAuth 2.0 Client IDs

#### Can't add SHA-1
**Steps**:
1. Firebase Console → Project Settings
2. Scroll to "Your apps"
3. Click on your Android app
4. Scroll to "SHA certificate fingerprints"
5. Click "Add fingerprint"
6. Paste SHA-1
7. Save

---

## Debugging Tips

### Check Logcat
```
1. Android Studio → Logcat tab (bottom)
2. Select your device
3. Filter by "Error" or "Fatal"
4. Look for red lines
5. Read stack trace for clues
```

### Enable Debug Logging
Add to your code:
```kotlin
// In onCreate or init
FirebaseFirestore.setLoggingEnabled(true)
```

### Test Firebase Connection
```kotlin
// Add to MainActivity onCreate
FirebaseFirestore.getInstance()
    .collection("test")
    .document("test")
    .set(mapOf("test" to "value"))
    .addOnSuccessListener {
        Log.d("Firebase", "Connection successful!")
    }
    .addOnFailureListener { e ->
        Log.e("Firebase", "Connection failed", e)
    }
```

### Verify Authentication
```kotlin
// Add to MainActivity onCreate
val user = FirebaseAuth.getInstance().currentUser
Log.d("Auth", "Current user: ${user?.email}")
```

---

## Getting Help

### Before Asking for Help

1. **Check Logcat** - Most errors are shown there
2. **Read error message** - Often tells you exactly what's wrong
3. **Google the error** - Someone likely had same issue
4. **Check Firebase Console** - Look for errors or warnings
5. **Try clean build** - Fixes many issues

### Where to Get Help

1. **Stack Overflow**: Tag with `android`, `firebase`, `kotlin`
2. **Firebase Support**: firebase.google.com/support
3. **Android Developers**: developer.android.com
4. **GitHub Issues**: If using open source libraries

### What to Include When Asking

1. **Error message** from Logcat
2. **Steps to reproduce** the issue
3. **What you've tried** already
4. **Code snippet** if relevant
5. **Android version** and device model
6. **Build.gradle** dependencies

---

## Prevention Tips

### Before Building
- [ ] google-services.json in place
- [ ] Web Client ID updated
- [ ] SHA-1 added to Firebase
- [ ] Firestore database created
- [ ] Google Sign-in enabled

### Before Testing
- [ ] Clean build
- [ ] Fresh install on device
- [ ] Internet connection active
- [ ] Firebase services enabled

### Before Distributing
- [ ] Test on multiple devices
- [ ] Test with multiple users
- [ ] Test all features
- [ ] Check for crashes
- [ ] Verify APK size

---

## Quick Fixes Checklist

When something goes wrong, try these in order:

1. ✅ Check Logcat for errors
2. ✅ Clean Project
3. ✅ Rebuild Project
4. ✅ Invalidate Caches & Restart
5. ✅ Uninstall and reinstall app
6. ✅ Check Firebase Console
7. ✅ Verify internet connection
8. ✅ Check google-services.json
9. ✅ Verify SHA-1 fingerprint
10. ✅ Check Firestore rules

---

## Still Stuck?

If none of these solutions work:

1. **Create a new Firebase project** and start fresh
2. **Clone the project again** in case files are corrupted
3. **Try on a different device** to isolate the issue
4. **Check Firebase status** at status.firebase.google.com
5. **Ask for help** with detailed error information

Remember: Most issues are configuration-related and can be fixed by double-checking the setup steps! 💪

---

Good luck debugging! 🐛🔨
