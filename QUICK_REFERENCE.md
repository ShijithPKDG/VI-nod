# VI-nod Quick Reference Card

## 🚀 Getting Started (First Time)

```bash
1. Download project
2. Open in Android Studio
3. Add google-services.json to app/ folder
4. Update default_web_client_id in strings.xml
5. Sync Gradle
6. Run app
```

## 🔥 Firebase Setup Checklist

- [ ] Create Firebase project
- [ ] Add Android app (package: com.vinod.app)
- [ ] Download google-services.json
- [ ] Enable Google Authentication
- [ ] Add SHA-1 fingerprint
- [ ] Copy Web Client ID to strings.xml
- [ ] Create Firestore database (test mode)

## 📱 Build Commands

```bash
# Debug APK (for testing)
./gradlew assembleDebug
# Output: app/build/outputs/apk/debug/app-debug.apk

# Release APK (for distribution)
./gradlew assembleRelease
# Output: app/build/outputs/apk/release/app-release.apk

# Clean build
./gradlew clean

# Install on connected device
./gradlew installDebug
```

## 🎨 Key Files to Customize

| File | Purpose | What to Change |
|------|---------|----------------|
| `strings.xml` | App text | App name, web client ID |
| `colors.xml` | Color scheme | Brand colors |
| `themes.xml` | App theme | Overall look & feel |
| `AndroidManifest.xml` | App config | Permissions, activities |

## 🗂️ Project Structure Quick Map

```
app/src/main/java/com/vinod/app/
├── data/
│   ├── model/          → Data classes (User, Group, Message)
│   └── repository/     → Firebase operations
├── ui/                 → Screens & UI components
└── viewmodel/          → State management

app/src/main/res/
├── layout/             → XML UI layouts
├── drawable/           → Icons & images
└── values/             → Colors, strings, themes
```

## 🔧 Common Tasks

### Add a New Screen

1. Create Fragment: `ui/NewFragment.kt`
2. Create Layout: `res/layout/fragment_new.xml`
3. Add to Navigation: `res/navigation/nav_graph.xml`
4. Add to Menu: `res/menu/bottom_nav_menu.xml` (if needed)

### Add a New Feature

1. Model: `data/model/Feature.kt`
2. Repository: `data/repository/FeatureRepository.kt`
3. ViewModel: `viewmodel/FeatureViewModel.kt`
4. UI: `ui/FeatureFragment.kt` + layout

### Change App Colors

Edit `res/values/colors.xml`:
```xml
<color name="primary">#FF6B4EFF</color>      <!-- Main brand color -->
<color name="primary_dark">#FF5639E8</color> <!-- Darker shade -->
<color name="accent">#FFFF6B9D</color>       <!-- Accent color -->
```

### Change App Name

Edit `res/values/strings.xml`:
```xml
<string name="app_name">Your New Name</string>
```

## 🐛 Troubleshooting Quick Fixes

| Problem | Solution |
|---------|----------|
| Gradle sync failed | File → Invalidate Caches → Restart |
| google-services.json error | Check file is in app/ folder |
| Sign in not working | Verify SHA-1 in Firebase Console |
| Build error | Clean Project → Rebuild Project |
| APK won't install | Enable "Unknown sources" on phone |

## 📊 Firebase Collections

```
users/{userId}
  - uid, name, email, photoUrl, bio

groups/{groupId}
  - groupId, name, inviteCode, adminId, members[]

messages/{messageId}
  - messageId, groupId, senderId, senderName, text, timestamp
```

## 🎯 Testing Flow

```
1. Launch app → Login screen
2. Sign in with Google → Groups screen
3. Click + → Create group → Note invite code
4. Click group → Chat screen
5. Send message → Appears in chat
6. Share invite code with friend
7. Friend joins → Both can chat
```

## 🔐 Get SHA-1 Fingerprint

```bash
# Debug SHA-1
./gradlew signingReport

# Release SHA-1 (after creating keystore)
keytool -list -v -keystore vinod-release.keystore -alias vinod
```

## 📦 APK Locations

```
Debug:   app/build/outputs/apk/debug/app-debug.apk
Release: app/build/outputs/apk/release/app-release.apk
```

## 🎨 Material Design Icons

Find icons at: https://fonts.google.com/icons

Add to `res/drawable/ic_name.xml`:
```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="24"
    android:viewportHeight="24">
    <path
        android:fillColor="?attr/colorOnSurface"
        android:pathData="M..." />
</vector>
```

## 🚀 Phase 2 Features to Add

- [ ] Anonymous teasing system
- [ ] Polls ("Who is always late?")
- [ ] Friendship scores
- [ ] Badges (Roast King, Meme Master)
- [ ] Inside jokes section
- [ ] Event planner
- [ ] Leaderboard

## 📱 Minimum Requirements

- Android 7.0 (API 24) or higher
- Internet connection
- Google Play Services
- ~20 MB storage

## 🔗 Useful Links

- Firebase Console: https://console.firebase.google.com
- Material Design: https://m3.material.io
- Android Docs: https://developer.android.com
- Kotlin Docs: https://kotlinlang.org/docs

## 💡 Pro Tips

1. **Test on real device** - Emulator may not show all issues
2. **Use test mode** - Firestore test mode for development
3. **Version control** - Use Git to track changes
4. **Backup keystore** - Keep release keystore safe!
5. **Test with friends** - Real usage reveals bugs
6. **Start simple** - Add features incrementally
7. **Check Logcat** - Android Studio Logcat shows errors

## 🎓 Learning Resources

### Kotlin
- Official Kotlin Koans
- Kotlin by Example

### Android
- Android Basics in Kotlin (Google)
- Android Developer Fundamentals

### Firebase
- Firebase Quickstart Samples
- Firebase Codelab

## 📞 Support

If stuck:
1. Check SETUP_GUIDE.md
2. Check BUILD_APK_INSTRUCTIONS.md
3. Check Android Studio Logcat
4. Check Firebase Console for errors
5. Google the error message
6. Check Stack Overflow

## 🎉 Success Checklist

- [ ] App builds successfully
- [ ] Google sign-in works
- [ ] Can create group
- [ ] Can join group with code
- [ ] Can send messages
- [ ] Messages appear in real-time
- [ ] APK installs on phone
- [ ] Friends can join and chat

---

**Remember**: Start simple, test often, add features gradually! 🚀
