# 🚀 Get Started with VI-nod in 10 Minutes

## What You're Building

VI-nod is a private friend group app where you can:
- ✅ Sign in with Google
- ✅ Create private groups
- ✅ Join groups with invite codes
- ✅ Chat in real-time with friends
- 🔜 Add polls, badges, and gamification (Phase 2)

## Prerequisites

You need:
1. **Android Studio** (download from https://developer.android.com/studio)
2. **Google account** (for Firebase)
3. **Android phone** (for testing) OR Android emulator

## Step-by-Step Setup

### 1️⃣ Open Project (2 minutes)

```
1. Open Android Studio
2. Click "Open"
3. Select the VI-nod folder
4. Wait for Gradle sync (may take 2-5 minutes first time)
```

### 2️⃣ Firebase Setup (5 minutes)

**A. Create Firebase Project**
1. Go to https://console.firebase.google.com
2. Click "Add project"
3. Name: "VI-nod" (or anything)
4. Disable Google Analytics (optional)
5. Click "Create project"

**B. Add Android App**
1. Click Android icon
2. Package name: `com.vinod.app`
3. Click "Register app"
4. Download `google-services.json`
5. **IMPORTANT**: Place file in `app/` folder (drag and drop in Android Studio)

**C. Enable Google Sign-In**
1. In Firebase Console → Authentication
2. Click "Get started"
3. Click "Google" → Enable → Save

**D. Get SHA-1 Fingerprint**
1. In Android Studio → Terminal (bottom)
2. Run: `./gradlew signingReport` (Mac/Linux) or `gradlew.bat signingReport` (Windows)
3. Copy SHA-1 from output (looks like: `A1:B2:C3:...`)
4. In Firebase Console → Project Settings → Your apps
5. Click "Add fingerprint" → Paste SHA-1 → Save

**E. Get Web Client ID**
1. Firebase Console → Project Settings → General
2. Scroll to "Your apps"
3. Find "Web client ID" (looks like: `123456-abc.apps.googleusercontent.com`)
4. Copy it
5. In Android Studio, open `app/src/main/res/values/strings.xml`
6. Replace `YOUR_WEB_CLIENT_ID_HERE` with your actual ID

**F. Create Firestore Database**
1. Firebase Console → Firestore Database
2. Click "Create database"
3. Select "Start in test mode"
4. Choose location (closest to you)
5. Click "Enable"

### 3️⃣ Build & Run (3 minutes)

```
1. Connect Android phone via USB (enable USB debugging)
   OR start Android emulator
2. In Android Studio, click green "Run" button (▶️)
3. Select your device
4. Wait for build and install
5. App launches automatically!
```

### 4️⃣ Test the App

```
1. Click "Sign in with Google"
2. Select your Google account
3. You're in! 🎉
4. Click + button (bottom right)
5. Create a group (e.g., "My Squad")
6. Note the invite code shown (e.g., "ABC123")
7. Click on your group
8. Send a message!
```

### 5️⃣ Test with Friends

```
1. Build APK: Build → Build Bundle(s) / APK(s) → Build APK(s)
2. Find APK: app/build/outputs/apk/debug/app-debug.apk
3. Share APK with friend
4. Friend installs and signs in
5. Friend clicks "Join Group" button (bottom right)
6. Friend enters your invite code
7. Both can now chat! 🎊
```

## 🎯 Quick Verification Checklist

After setup, verify:
- [ ] google-services.json is in app/ folder
- [ ] default_web_client_id is updated in strings.xml
- [ ] SHA-1 is added in Firebase Console
- [ ] Google Sign-in is enabled in Firebase
- [ ] Firestore database is created
- [ ] App builds without errors
- [ ] Can sign in with Google
- [ ] Can create a group
- [ ] Can send messages

## 🐛 Common Issues & Fixes

### "google-services.json not found"
**Fix**: Make sure file is in `app/` folder, NOT `app/src/`

### "Sign in failed"
**Fix**: 
1. Check SHA-1 is added in Firebase Console
2. Verify default_web_client_id in strings.xml
3. Make sure Google Sign-in is enabled in Firebase

### "Gradle sync failed"
**Fix**: File → Invalidate Caches → Invalidate and Restart

### "App crashes on launch"
**Fix**: Check Logcat in Android Studio for error details

## 📱 Building APK for Distribution

Once everything works:

```bash
# In Android Studio Terminal:
./gradlew assembleDebug

# APK location:
app/build/outputs/apk/debug/app-debug.apk
```

Share this APK with friends!

## 📚 Next Steps

### Immediate (Test Phase 1)
1. Test with 2-3 friends
2. Create multiple groups
3. Send lots of messages
4. Note any bugs or issues

### Phase 2 (Add Features)
Add these features one by one:
- Anonymous teasing
- Polls ("Who is always late?")
- Friendship scores
- Badges (Roast King, Meme Master)
- Inside jokes section
- Event planner

### Phase 3 (Polish)
- Custom app icon
- Splash screen
- Push notifications
- Media sharing (images)

### Phase 4 (Launch)
- Create release APK
- Test thoroughly
- Share with more friends
- Consider Play Store release

## 📖 Documentation

- **SETUP_GUIDE.md** - Detailed setup instructions
- **BUILD_APK_INSTRUCTIONS.md** - How to build APK
- **PROJECT_STRUCTURE.md** - Code architecture
- **QUICK_REFERENCE.md** - Quick commands & tips

## 🎓 Learning Path

If you want to customize the app:

1. **Start with UI**: Change colors in `colors.xml`
2. **Add simple features**: Add a new screen
3. **Learn Firebase**: Understand Firestore queries
4. **Study MVVM**: Understand the architecture
5. **Add complex features**: Polls, badges, etc.

## 💡 Pro Tips

1. **Always test on real device** - Emulator may hide issues
2. **Use test mode for Firestore** - Easy during development
3. **Keep keystore safe** - You'll need it for updates
4. **Start simple** - Don't add all features at once
5. **Test with friends** - Real usage reveals problems
6. **Check Logcat** - Shows all errors and logs
7. **Backup your work** - Use Git or cloud storage

## 🎉 Success!

If you can:
- ✅ Sign in with Google
- ✅ Create a group
- ✅ Chat with friends
- ✅ Share APK with others

**Congratulations! You've built a working social app!** 🎊

## 🆘 Need Help?

1. Check the error in Logcat (Android Studio → Logcat tab)
2. Read SETUP_GUIDE.md for detailed instructions
3. Check Firebase Console for configuration issues
4. Google the error message
5. Check Stack Overflow

## 🚀 Ready to Build?

```bash
# Open Android Studio
# Open this project
# Follow steps above
# Start coding!
```

**Time to connect with your squad!** 💪

---

Made with ❤️ for friend groups everywhere
