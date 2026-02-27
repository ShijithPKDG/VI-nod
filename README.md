# VI-nod - Private Friend Group App

A modern Android application for offline friend groups to connect, interact, and strengthen bonding.

## 🎯 DEMO VERSION - No Firebase Required!

**Want to test immediately?** This version works WITHOUT Firebase!

→ **[BUILD_DEMO_NOW.md](BUILD_DEMO_NOW.md)** - Build APK in 5 minutes! ⚡

- ✅ No Firebase setup
- ✅ No Google account
- ✅ Just build and test
- ✅ Perfect for demonstration

## 🚀 Quick Start

**New to the project?** Start here:
1. **[GET_STARTED.md](GET_STARTED.md)** - 10-minute setup guide ⭐
2. **[SETUP_GUIDE.md](SETUP_GUIDE.md)** - Detailed Firebase setup
3. **[BUILD_APK_INSTRUCTIONS.md](BUILD_APK_INSTRUCTIONS.md)** - Build your APK

**Need help?** Check **[TROUBLESHOOTING.md](TROUBLESHOOTING.md)**

**Want to understand the code?** Read **[PROJECT_STRUCTURE.md](PROJECT_STRUCTURE.md)**

**Looking for something specific?** Browse **[INDEX.md](INDEX.md)**

## ✨ Current Features (Phase 1)
- ✅ Firebase Authentication (Google Sign-in)
- ✅ Profile creation
- ✅ Create private groups
- ✅ Join group via invite code
- ✅ Real-time group chat with message bubbles
- ✅ Modern Material Design 3 UI
- ✅ Dark mode support

## 🔮 Upcoming Features (Phase 2+)
- 🔜 Anonymous teasing inside groups
- 🔜 Fun polls ("Who is always late?")
- 🔜 Friendship scores & badges
- 🔜 Inside jokes section
- 🔜 Event planner with countdown
- 🔜 Group leaderboard

## 🛠️ Tech Stack
- **Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **Backend**: Firebase (Auth, Firestore, Cloud Messaging)
- **UI**: Material Design 3 with dark mode
- **Async**: Kotlin Coroutines & Flow
- **Navigation**: Jetpack Navigation Component

## 📱 Screenshots & Design

Check **[VISUAL_GUIDE.md](VISUAL_GUIDE.md)** for:
- Screen layouts
- Color scheme
- UI components
- Design principles

## 🎯 Quick Setup (5 Steps)

1. **Open in Android Studio**
2. **Add google-services.json** to `app/` folder
3. **Update Web Client ID** in `strings.xml`
4. **Sync Gradle**
5. **Run!**

For detailed instructions, see **[SETUP_GUIDE.md](SETUP_GUIDE.md)**

## 📦 Building APK

```bash
# Debug APK (for testing)
./gradlew assembleDebug

# Release APK (for distribution)
./gradlew assembleRelease
```

See **[BUILD_APK_INSTRUCTIONS.md](BUILD_APK_INSTRUCTIONS.md)** for complete guide.

## 📚 Documentation

| Document | Description |
|----------|-------------|
| **[INDEX.md](INDEX.md)** | Complete documentation index |
| **[GET_STARTED.md](GET_STARTED.md)** | Quick start guide (10 min) |
| **[SETUP_GUIDE.md](SETUP_GUIDE.md)** | Detailed setup instructions |
| **[BUILD_APK_INSTRUCTIONS.md](BUILD_APK_INSTRUCTIONS.md)** | How to build APK |
| **[PROJECT_STRUCTURE.md](PROJECT_STRUCTURE.md)** | Code architecture & organization |
| **[VISUAL_GUIDE.md](VISUAL_GUIDE.md)** | UI/UX design guide |
| **[TROUBLESHOOTING.md](TROUBLESHOOTING.md)** | Common issues & solutions |
| **[QUICK_REFERENCE.md](QUICK_REFERENCE.md)** | Commands & quick tips |

## 🏗️ Project Structure
```
app/
├── data/
│   ├── model/          # Data classes (User, Group, Message)
│   └── repository/     # Firebase operations
├── ui/
│   ├── adapter/        # RecyclerView adapters
│   ├── LoginActivity   # Google sign-in
│   ├── MainActivity    # Main container
│   ├── GroupsFragment  # Groups list
│   └── ChatFragment    # Group chat
├── viewmodel/          # ViewModels (MVVM)
└── res/
    ├── layout/         # XML layouts
    ├── drawable/       # Icons & images
    └── values/         # Colors, strings, themes
```

## 🎓 Learning Path

1. **Week 1**: Setup & test basic features
2. **Week 2**: Understand code structure
3. **Week 3**: Add your first feature
4. **Week 4**: Customize & extend

See **[PROJECT_STRUCTURE.md](PROJECT_STRUCTURE.md)** for adding features.

## 🐛 Troubleshooting

Common issues:
- **Build fails**: Check google-services.json location
- **Sign in fails**: Verify SHA-1 and Web Client ID
- **App crashes**: Check Logcat for errors

See **[TROUBLESHOOTING.md](TROUBLESHOOTING.md)** for solutions.

## 🤝 Contributing

Want to add features? Follow MVVM pattern:
1. Create model in `data/model/`
2. Add repository in `data/repository/`
3. Create ViewModel in `viewmodel/`
4. Build UI in `ui/`

See **[PROJECT_STRUCTURE.md](PROJECT_STRUCTURE.md)** → "Adding New Features"

## 📄 License

This project is open source and available for educational purposes.

## 🎉 Ready to Start?

→ **[GET_STARTED.md](GET_STARTED.md)** - Begin your journey!

---

Made with ❤️ for friend groups everywhere
