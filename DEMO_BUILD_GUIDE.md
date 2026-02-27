# 🚀 VI-nod Demo Version - Build Guide

## ✨ What is This?

This is a **DEMO VERSION** of VI-nod that works **WITHOUT Firebase**!

- ✅ No Firebase setup needed
- ✅ No Google account required
- ✅ All data stored locally on device
- ✅ Perfect for testing and demonstration
- ✅ Build APK in 5 minutes!

## 🎯 Features

- Mock login (just enter your name)
- Create groups locally
- Join groups with invite codes
- Send messages (stored on device)
- Full UI experience
- Dark mode support

## 📦 Build APK (3 Steps)

### Step 1: Open in Android Studio

1. Open Android Studio
2. Click "Open"
3. Select this project folder
4. Wait for Gradle sync (2-3 minutes)

### Step 2: Build APK

**Option A: Using Menu**
```
Build → Build Bundle(s) / APK(s) → Build APK(s)
Wait for "Build successful"
Click "locate" in notification
```

**Option B: Using Command Line**
```bash
# Windows
gradlew.bat assembleDebug

# Mac/Linux
./gradlew assembleDebug
```

### Step 3: Get Your APK

**Location:**
```
app/build/outputs/apk/debug/app-debug.apk
```

**Size:** ~5-8 MB

## 📱 Install & Test

### Install on Phone

1. Copy APK to phone
2. Open file manager
3. Tap APK file
4. Allow "Install from unknown sources"
5. Install!

### Test the App

1. **Launch app** → See "DEMO MODE" screen
2. **Click "Start Demo"** → Enter your name
3. **Create a group** → Click + button
4. **Note the invite code** (e.g., "ABC123")
5. **Send messages** → Type and send
6. **Test with friend:**
   - Share APK with friend
   - Friend installs and enters their name
   - Friend clicks "Join Group"
   - Friend enters your invite code
   - Both can chat!

## 🎨 What Works

✅ Mock login (no Google account)
✅ Create groups
✅ Join groups with codes
✅ Send messages
✅ View messages
✅ Multiple users (each device is separate)
✅ Modern UI
✅ Dark mode

## ⚠️ Limitations (Demo Mode)

- ❌ No real-time sync (data is local per device)
- ❌ No cloud backup
- ❌ Data lost if app uninstalled
- ❌ Can't chat across devices (each device has own data)
- ❌ No push notifications

## 🔄 Switching to Real Firebase

Want to use real Firebase later? See:
- **SETUP_GUIDE.md** - Full Firebase setup
- **BUILD_APK_INSTRUCTIONS.md** - Production build

The code is ready - just need to:
1. Add Firebase config
2. Switch from Mock to Firebase repositories
3. Rebuild

## 🐛 Troubleshooting

### Build fails
```
Solution:
1. File → Invalidate Caches → Restart
2. Build → Clean Project
3. Build → Rebuild Project
```

### APK won't install
```
Solution:
1. Enable "Unknown sources" in phone settings
2. Uninstall old version first
3. Try transferring via USB
```

### App crashes
```
Solution:
1. Uninstall completely
2. Reinstall fresh APK
3. Clear app data if needed
```

## 📊 Build Time

- First build: ~3-5 minutes
- Subsequent builds: ~1-2 minutes
- APK size: ~5-8 MB

## 🎉 Success Checklist

- [ ] Project opens in Android Studio
- [ ] Gradle sync completes
- [ ] Build succeeds
- [ ] APK file created
- [ ] APK installs on phone
- [ ] App launches
- [ ] Can enter name and login
- [ ] Can create group
- [ ] Can send messages

## 💡 Pro Tips

1. **Test on real device** - Better than emulator
2. **Share with friends** - More fun with multiple users
3. **Note invite codes** - Write them down to share
4. **Clean install** - Uninstall old version first
5. **Check storage** - Need ~50 MB free

## 🚀 Quick Commands

```bash
# Clean build
gradlew clean

# Build debug APK
gradlew assembleDebug

# Install on connected device
gradlew installDebug

# Uninstall from device
gradlew uninstallDebug
```

## 📁 APK Location

After build, find APK at:
```
app/
└── build/
    └── outputs/
        └── apk/
            └── debug/
                └── app-debug.apk  ← HERE!
```

## 🎯 Next Steps

1. **Now**: Build and test demo
2. **Later**: Add Firebase for real sync
3. **Future**: Add Phase 2 features

## 📞 Need Help?

- Build issues → Check TROUBLESHOOTING.md
- General help → Check QUICK_REFERENCE.md
- Understanding code → Check PROJECT_STRUCTURE.md

## 🎊 You're Ready!

This demo version is perfect for:
- ✅ Testing the app
- ✅ Showing to friends
- ✅ Learning Android development
- ✅ Demonstrating features
- ✅ Quick prototyping

**No Firebase, no hassle - just build and go!** 🚀

---

**Build Time**: ~5 minutes
**Setup Time**: 0 minutes (no Firebase!)
**Fun Time**: Unlimited! 🎉
