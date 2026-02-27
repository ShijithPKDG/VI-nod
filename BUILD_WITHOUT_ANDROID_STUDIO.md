# 🚀 Build APK Without Android Studio

## ✅ What You Need

1. **JDK (Java Development Kit)** - Version 17 or higher
2. **This project folder**
3. **Command line / Terminal**

That's it! No Android Studio required!

---

## 📥 Step 1: Install JDK (If Not Installed)

### Windows

**Option A: Download from Oracle**
1. Go to: https://www.oracle.com/java/technologies/downloads/#jdk17-windows
2. Download "Windows x64 Installer"
3. Run installer
4. Follow prompts

**Option B: Using Chocolatey (if installed)**
```bash
choco install openjdk17
```

**Option C: Using Winget**
```bash
winget install Microsoft.OpenJDK.17
```

### Verify Installation
```bash
java -version
```

Should show: `java version "17.x.x"` or higher

---

## 📦 Step 2: Build APK

### Open Command Prompt

1. Press `Win + R`
2. Type `cmd`
3. Press Enter

### Navigate to Project

```bash
cd path\to\VI-nod
```

Example:
```bash
cd C:\Users\YourName\Downloads\VI-nod
```

### Build the APK

```bash
gradlew.bat assembleDebug
```

**Wait 3-5 minutes** for first build (downloads dependencies)

---

## 📍 Step 3: Find Your APK

After successful build, APK is at:

```
app\build\outputs\apk\debug\app-debug.apk
```

**Full path example:**
```
C:\Users\YourName\Downloads\VI-nod\app\build\outputs\apk\debug\app-debug.apk
```

---

## 🎉 Success Messages

You'll see:
```
BUILD SUCCESSFUL in 3m 45s
```

APK size: ~5-8 MB

---

## 📱 Step 4: Install APK

### Transfer to Phone

**Option A: USB Cable**
1. Connect phone to PC
2. Copy `app-debug.apk` to phone
3. Disconnect

**Option B: Cloud Storage**
1. Upload APK to Google Drive / Dropbox
2. Download on phone

**Option C: Email**
1. Email APK to yourself
2. Download on phone

### Install on Phone

1. Open file manager on phone
2. Find `app-debug.apk`
3. Tap to install
4. Allow "Install from unknown sources" if prompted
5. Install!

---

## 🐛 Troubleshooting

### "java is not recognized"

**Problem:** JDK not installed or not in PATH

**Solution:**
1. Install JDK (see Step 1)
2. Restart command prompt
3. Try again

### "JAVA_HOME is not set"

**Solution:**
```bash
# Windows - Set temporarily
set JAVA_HOME=C:\Program Files\Java\jdk-17

# Or set permanently:
# 1. Search "Environment Variables" in Windows
# 2. Add JAVA_HOME variable
# 3. Point to JDK installation folder
```

### "gradlew.bat not found"

**Problem:** Not in project directory

**Solution:**
```bash
# Make sure you're in the right folder
cd path\to\VI-nod

# Check if gradlew.bat exists
dir gradlew.bat
```

### Build fails with "SDK not found"

**Solution:**

Create/edit `local.properties` file:
```properties
sdk.dir=C\:\\Users\\YourName\\AppData\\Local\\Android\\Sdk
```

If you don't have Android SDK, you'll need to either:
- Install Android Studio (easiest)
- Or install Android SDK command-line tools

---

## 🔧 Alternative: Use GitHub Actions (Online Build)

If command line doesn't work, you can build online:

### Option 1: GitHub Actions

1. Create GitHub account
2. Upload project to GitHub
3. Create `.github/workflows/build.yml`:

```yaml
name: Build APK

on:
  push:
    branches: [ main ]
  workflow_dispatch:

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'
      - name: Build APK
        run: ./gradlew assembleDebug
      - name: Upload APK
        uses: actions/upload-artifact@v3
        with:
          name: app-debug
          path: app/build/outputs/apk/debug/app-debug.apk
```

4. Push to GitHub
5. Go to Actions tab
6. Download APK artifact

### Option 2: Online Android Build Services

- **Appetize.io** - Online Android emulator
- **Appcircle** - Cloud build service
- **Bitrise** - CI/CD platform

---

## 💻 Minimum Requirements

### For Building:
- Windows 7 or higher
- 4 GB RAM (8 GB recommended)
- 10 GB free disk space
- Internet connection (first build only)

### For Running APK:
- Android 7.0 or higher
- 50 MB free space

---

## ⚡ Quick Commands Reference

```bash
# Navigate to project
cd path\to\VI-nod

# Build debug APK
gradlew.bat assembleDebug

# Clean build (if needed)
gradlew.bat clean

# Build release APK (unsigned)
gradlew.bat assembleRelease

# Check Java version
java -version

# List all Gradle tasks
gradlew.bat tasks
```

---

## 📊 Build Time

- **First build**: 5-10 minutes (downloads dependencies)
- **Subsequent builds**: 1-3 minutes
- **Internet required**: Only for first build

---

## 🎯 Expected Output

```
> Task :app:assembleDebug
BUILD SUCCESSFUL in 3m 45s
45 actionable tasks: 45 executed

APK location:
app\build\outputs\apk\debug\app-debug.apk
```

---

## 🆘 Still Can't Build?

### Easiest Solution: Install Android Studio

1. Download: https://developer.android.com/studio
2. Install (takes 10-15 minutes)
3. Open project
4. Click Build → Build APK
5. Done!

### Alternative: Ask Someone

- Find a friend with Android Studio
- Share project folder
- They build APK for you
- You get the APK file

### Last Resort: Pre-built APK

If you absolutely can't build:
- You'll need someone to build it for you
- Or install Android Studio (recommended)

---

## 💡 Pro Tips

1. **First build is slow** - Be patient, it downloads dependencies
2. **Use WiFi** - First build downloads ~500 MB
3. **Close other programs** - Frees up RAM for build
4. **Antivirus** - May slow down build, temporarily disable if needed

---

## ✅ Success Checklist

- [ ] JDK 17+ installed
- [ ] Command prompt opened
- [ ] Navigated to project folder
- [ ] Ran `gradlew.bat assembleDebug`
- [ ] Build completed successfully
- [ ] APK file found
- [ ] APK copied to phone
- [ ] APK installed
- [ ] App launches!

---

## 🎉 You Did It!

Once you have the APK file, you can:
- Install on your phone
- Share with friends
- Test the app
- Enjoy VI-nod!

**No Android Studio needed!** 🚀

---

**Need Help?** Check TROUBLESHOOTING.md

**Want easier way?** Install Android Studio (recommended)
