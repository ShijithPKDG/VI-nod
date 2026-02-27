# 📤 Step-by-Step GitHub Upload Guide

## 🎯 Goal:
Replace the old Firebase files on GitHub with the new Mock files from your computer.

---

## ✅ Before You Start:

1. **Run** `VERIFY_FILES.bat` to check if all files exist locally
2. All files should show `[OK]` status

---

## 🚀 Method 1: Delete & Re-upload (EASIEST - Recommended)

### Step 1: Go to Your GitHub Repository
1. Open your web browser
2. Go to your GitHub repository (the VI-nod project)
3. Make sure you're on the main/master branch

### Step 2: Delete the Old 'app' Folder
1. Click on the `app` folder
2. Look for the **3 dots menu (...)** or **trash icon** at the top right
3. Click **"Delete directory"**
4. Scroll down and click **"Commit changes"**
5. Confirm the deletion

### Step 3: Upload the New 'app' Folder
1. Go back to the main repository page
2. Click **"Add file"** → **"Upload files"**
3. Drag the entire `app` folder from:
   ```
   C:\Users\shiji\Desktop\Vi-nod\app
   ```
4. Wait for upload to complete (may take 1-2 minutes)
5. Scroll down and click **"Commit changes"**

### Step 4: Also Upload These Root Files
Upload these files from `C:\Users\shiji\Desktop\Vi-nod\`:
- `build.gradle`
- `app/build.gradle` (if not already in app folder)

### Step 5: Run the Build
1. Click the **"Actions"** tab at the top
2. Click **"Build Android APK"** workflow on the left
3. Click **"Run workflow"** button (top right)
4. Click the green **"Run workflow"** button
5. Wait 3-5 minutes for the build to complete

### Step 6: Download Your APK
1. Click on the completed workflow run
2. Scroll down to **"Artifacts"** section
3. Click **"app-debug"** to download
4. Extract the ZIP file
5. Install `app-debug.apk` on your phone!

---

## 🔧 Method 2: Manual File Upload (If Method 1 Doesn't Work)

### Files to DELETE from GitHub:

Navigate to each file and click the trash icon:

1. `app/src/main/java/com/vinod/app/data/repository/AuthRepository.kt`
2. `app/src/main/java/com/vinod/app/data/repository/GroupRepository.kt`
3. `app/src/main/java/com/vinod/app/data/repository/ChatRepository.kt`
4. `app/src/main/java/com/vinod/app/ui/LoginActivity.kt`
5. `app/src/main/res/layout/activity_login.xml` (if exists)

### Files to UPLOAD to GitHub:

**Repository Files:**
1. Navigate to: `app/src/main/java/com/vinod/app/data/repository/`
2. Click "Add file" → "Upload files"
3. Upload:
   - `MockAuthRepository.kt`
   - `MockGroupRepository.kt`
   - `MockChatRepository.kt`

**UI Files:**
1. Navigate to: `app/src/main/java/com/vinod/app/ui/`
2. Click "Add file" → "Upload files"
3. Upload:
   - `MockLoginActivity.kt`

**ViewModel Files:**
1. Navigate to: `app/src/main/java/com/vinod/app/viewmodel/`
2. Click "Add file" → "Upload files"
3. Upload:
   - `AuthViewModel.kt`
   - `GroupViewModel.kt`
   - `ChatViewModel.kt`

**Layout Files:**
1. Navigate to: `app/src/main/res/layout/`
2. Click "Add file" → "Upload files"
3. Upload:
   - `activity_mock_login.xml`

**Icon Files:**
1. Navigate to: `app/src/main/res/`
2. Upload all `mipmap-*` folders (mdpi, hdpi, xhdpi, xxhdpi, xxxhdpi)

**Config Files:**
1. Navigate to root directory
2. Upload:
   - `build.gradle`
3. Navigate to `app/` directory
4. Upload:
   - `build.gradle`
   - `AndroidManifest.xml`

---

## 🔍 How to Verify Upload Was Successful:

After uploading, check your GitHub repository:

### ✅ Should HAVE these files:
- `app/src/main/java/com/vinod/app/data/repository/MockAuthRepository.kt`
- `app/src/main/java/com/vinod/app/data/repository/MockGroupRepository.kt`
- `app/src/main/java/com/vinod/app/data/repository/MockChatRepository.kt`
- `app/src/main/java/com/vinod/app/ui/MockLoginActivity.kt`

### ❌ Should NOT have these files:
- `app/src/main/java/com/vinod/app/data/repository/AuthRepository.kt` (without "Mock")
- `app/src/main/java/com/vinod/app/data/repository/GroupRepository.kt` (without "Mock")
- `app/src/main/java/com/vinod/app/data/repository/ChatRepository.kt` (without "Mock")
- `app/src/main/java/com/vinod/app/ui/LoginActivity.kt` (without "Mock")

---

## 🆘 If Build Still Fails:

1. Check the Actions tab for error details
2. Look for lines that say "Unresolved reference"
3. Share the error message
4. I'll help you fix it!

---

## 💡 Why This Is Necessary:

Your GitHub repository has the OLD Firebase version of the code, but your local computer has the NEW Mock version. The build fails because it tries to compile Firebase code without Firebase dependencies.

By uploading the Mock files, the build will work without needing Firebase!

