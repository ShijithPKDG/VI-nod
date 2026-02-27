# 🎨 Convert "Image (2).jpg" to App Icon

## ✅ Method 1: Icon Kitchen (Easiest - Recommended)

1. **Go to:** https://icon.kitchen/

2. **Upload your image:**
   - Click "Image" tab
   - Click "Upload Image"
   - Select `Image (2).jpg` from your project folder

3. **Configure:**
   - **Shape:** Square (or Circle if you prefer rounded)
   - **Padding:** Adjust slider to fit your image nicely (try 10-20%)
   - **Background:** Choose a color or keep transparent

4. **Download:**
   - Click the big "Download" button at the top
   - Save the ZIP file

5. **Extract and Copy:**
   - Extract the downloaded ZIP file
   - You'll see folders: `mipmap-mdpi`, `mipmap-hdpi`, etc.
   - Copy ALL these folders to: `C:\Users\shiji\Desktop\Vi-nod\app\src\main\res\`
   - Replace the existing mipmap folders

6. **Push to GitHub:**
   ```
   git add app/src/main/res/mipmap-*
   git commit -m "Add custom app icon"
   git push
   ```

7. **Rebuild:**
   - Go to GitHub Actions
   - Run workflow again
   - Download new APK with your custom icon!

---

## 🖼️ Method 2: Android Asset Studio (Alternative)

1. **Go to:** https://romannurik.github.io/AndroidAssetStudio/icons-launcher.html

2. **Upload Image:**
   - Click "Image" option
   - Upload `Image (2).jpg`

3. **Adjust:**
   - Resize and position your image
   - Choose shape (square, circle, etc.)
   - Add padding if needed

4. **Download:**
   - Click "Download .zip"
   - Extract the files

5. **Copy to Project:**
   - Copy all `mipmap-*` folders to `app/src/main/res/`

---

## 📐 Icon Sizes Needed

If you want to resize manually, create these sizes:

| Folder | Size | File Name |
|--------|------|-----------|
| mipmap-mdpi | 48x48 px | ic_launcher.png |
| mipmap-hdpi | 72x72 px | ic_launcher.png |
| mipmap-xhdpi | 96x96 px | ic_launcher.png |
| mipmap-xxhdpi | 144x144 px | ic_launcher.png |
| mipmap-xxxhdpi | 192x192 px | ic_launcher.png |

---

## ✅ After Adding Icon

Your `AndroidManifest.xml` is already configured to use the icon:
```xml
android:icon="@mipmap/ic_launcher"
android:roundIcon="@mipmap/ic_launcher"
```

Just replace the icon files and rebuild!

---

## 🎯 Quick Steps Summary

1. Visit https://icon.kitchen/
2. Upload `Image (2).jpg`
3. Download ZIP
4. Extract and copy mipmap folders to `app/src/main/res/`
5. Delete old `.xml` icon files
6. Push to GitHub
7. Rebuild APK

Your custom icon will appear on the app!
