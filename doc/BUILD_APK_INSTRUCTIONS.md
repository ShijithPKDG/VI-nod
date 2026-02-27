# How to Build APK File for VI-nod

## Quick Start (5 Steps to APK)

### Step 1: Complete Firebase Setup
Follow `SETUP_GUIDE.md` first to:
- Create Firebase project
- Download `google-services.json` → place in `app/` folder
- Enable Google Authentication
- Update `default_web_client_id` in `strings.xml`

### Step 2: Open Project in Android Studio
```
1. Launch Android Studio
2. File → Open
3. Select the VI-nod project folder
4. Wait for Gradle sync to complete
```

### Step 3: Build Debug APK (Easiest Method)
```
1. In Android Studio: Build → Build Bundle(s) / APK(s) → Build APK(s)
2. Wait for build to complete
3. Click "locate" in the notification
4. APK is at: app/build/outputs/apk/debug/app-debug.apk
```

OR use command line:
```bash
# Windows
gradlew.bat assembleDebug

# Mac/Linux
./gradlew assembleDebug
```

### Step 4: Install APK on Phone
```
Method 1: Direct Install
- Connect phone via USB
- Enable USB debugging on phone
- Drag APK to phone
- Open and install

Method 2: Share APK
- Copy app-debug.apk to phone
- Open file manager on phone
- Tap APK file
- Allow "Install from unknown sources"
- Install
```

### Step 5: Test the App
```
1. Open VI-nod app
2. Sign in with Google
3. Create a group
4. Share invite code with friends
5. Start chatting!
```

---

## Building Release APK (For Distribution)

Release APK is smaller, optimized, and ready for sharing with many users.

### Step 1: Create Signing Key
```bash
keytool -genkey -v -keystore vinod-release.keystore -alias vinod -keyalg RSA -keysize 2048 -validity 10000
```

Enter details when prompted:
- Password: (remember this!)
- Name, Organization, etc.

This creates `vinod-release.keystore` file.

### Step 2: Configure Signing in build.gradle

Edit `app/build.gradle`, add inside `android { }`:

```gradle
android {
    ...
    
    signingConfigs {
        release {
            storeFile file("../vinod-release.keystore")
            storePassword "YOUR_PASSWORD_HERE"
            keyAlias "vinod"
            keyPassword "YOUR_PASSWORD_HERE"
        }
    }
    
    buildTypes {
        release {
            signingConfig signingConfigs.release
            minifyEnabled true
            shrinkResources true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}
```

### Step 3: Build Release APK
```bash
# Windows
gradlew.bat assembleRelease

# Mac/Linux
./gradlew assembleRelease
```

### Step 4: Find Your APK
```
Location: app/build/outputs/apk/release/app-release.apk
Size: ~5-10 MB (much smaller than debug)
```

---

## APK Size Optimization

To make APK even smaller:

### 1. Enable R8 (already enabled in release)
```gradle
buildTypes {
    release {
        minifyEnabled true
        shrinkResources true
    }
}
```

### 2. Use APK Splits (for different architectures)
Add to `app/build.gradle`:
```gradle
android {
    splits {
        abi {
            enable true
            reset()
            include 'armeabi-v7a', 'arm64-v8a'
            universalApk true
        }
    }
}
```

This creates separate APKs for different phone types.

---

## Troubleshooting

### "Gradle sync failed"
```
Solution:
1. File → Invalidate Caches → Invalidate and Restart
2. Delete .gradle folder
3. Sync again
```

### "google-services.json not found"
```
Solution:
- Download from Firebase Console
- Place in app/ folder (same level as app/build.gradle)
- NOT in app/src/
```

### "Build failed: Duplicate class"
```
Solution:
- Clean project: Build → Clean Project
- Rebuild: Build → Rebuild Project
```

### "APK not installing on phone"
```
Solution:
- Enable "Install from unknown sources" in phone settings
- Check phone has enough storage
- Try uninstalling old version first
```

### "Sign in not working in release APK"
```
Solution:
- Get SHA-1 of release keystore:
  keytool -list -v -keystore vinod-release.keystore -alias vinod
- Add this SHA-1 to Firebase Console
- Rebuild APK
```

---

## Distribution Options

### Option 1: Direct Share
- Share APK file via WhatsApp, Telegram, etc.
- Friends download and install
- Simple but requires "unknown sources" enabled

### Option 2: Google Play Store (Future)
- Create Google Play Developer account ($25 one-time)
- Upload APK/AAB
- Professional distribution
- Automatic updates

### Option 3: Firebase App Distribution
- Free for testing with friends
- Upload APK to Firebase Console
- Invite testers via email
- They get download link

---

## Building AAB (Android App Bundle)

For Play Store, you need AAB instead of APK:

```bash
# Windows
gradlew.bat bundleRelease

# Mac/Linux
./gradlew bundleRelease
```

Output: `app/build/outputs/bundle/release/app-release.aab`

---

## Quick Reference

| Build Type | Command | Output | Use Case |
|------------|---------|--------|----------|
| Debug APK | `gradlew assembleDebug` | app-debug.apk | Testing |
| Release APK | `gradlew assembleRelease` | app-release.apk | Distribution |
| Release AAB | `gradlew bundleRelease` | app-release.aab | Play Store |

---

## File Sizes (Approximate)

- Debug APK: ~15-20 MB
- Release APK: ~5-10 MB
- Release AAB: ~5-8 MB

---

## Next Steps After Building

1. Test APK on multiple devices
2. Share with friends for beta testing
3. Gather feedback
4. Add Phase 2 features (polls, badges, etc.)
5. Consider Play Store release

Good luck with VI-nod! 🚀
