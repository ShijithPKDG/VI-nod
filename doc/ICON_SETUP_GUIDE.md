# 🎨 Custom Icon Setup - Using "Image (2).jpg"

## 🚀 Quick Start (Easiest Method):

### Step 1: Generate Icons Online

1. **Double-click** `CREATE_ICON.bat` (this will open icon.kitchen)
   
   OR manually visit: https://icon.kitchen/

2. Click **"Upload Image"** or drag `Image (2).jpg` onto the page

3. Configure the icon:
   - **Source**: Image
   - **Shape**: Square (or Circle if you prefer)
   - **Padding**: Adjust to fit your image nicely
   - **Background**: Choose a color or keep transparent

4. Click **"Download"** button at the top

5. Extract the downloaded ZIP file

### Step 2: Replace Icon Files

1. Open the extracted folder - you'll see folders like:
   ```
   mipmap-mdpi/
   mipmap-hdpi/
   mipmap-xhdpi/
   mipmap-xxhdpi/
   mipmap-xxxhdpi/
   ```

2. Each folder contains `ic_launcher.png` and `ic_launcher_round.png`

3. Copy ALL these folders to:
   ```
   C:\Users\shiji\Desktop\Vi-nod\app\src\main\res\
   ```
   
4. **Replace** the existing mipmap folders (delete the old .xml files)

### Step 3: Upload to GitHub

Upload these new folders to GitHub:
```
app/src/main/res/mipmap-mdpi/
app/src/main/res/mipmap-hdpi/
app/src/main/res/mipmap-xhdpi/
app/src/main/res/mipmap-xxhdpi/
app/src/main/res/mipmap-xxxhdpi/
```

---

## 📐 Manual Method (If You Prefer):

If you want to resize manually, create these exact sizes from `Image (2).jpg`:

| Folder | Size | File Name |
|--------|------|-----------|
| mipmap-mdpi | 48x48 px | ic_launcher.png |
| mipmap-hdpi | 72x72 px | ic_launcher.png |
| mipmap-xhdpi | 96x96 px | ic_launcher.png |
| mipmap-xxhdpi | 144x144 px | ic_launcher.png |
| mipmap-xxxhdpi | 192x192 px | ic_launcher.png |

**Tools you can use:**
- Paint (Windows built-in)
- GIMP (free)
- Photoshop
- Online: https://www.iloveimg.com/resize-image

---

## ✅ Verification:

After setting up, your folder structure should look like:

```
app/src/main/res/
├── mipmap-mdpi/
│   └── ic_launcher.png (48x48)
├── mipmap-hdpi/
│   └── ic_launcher.png (72x72)
├── mipmap-xhdpi/
│   └── ic_launcher.png (96x96)
├── mipmap-xxhdpi/
│   └── ic_launcher.png (144x144)
└── mipmap-xxxhdpi/
    └── ic_launcher.png (192x192)
```

---

## 🔧 Already Configured:

The `AndroidManifest.xml` is already set to use `@mipmap/ic_launcher`, so once you add the PNG files, they'll automatically be used as your app icon!

---

## 💡 Tips:

- **Square vs Circle**: Most Android launchers will automatically round square icons
- **Padding**: Leave a little space around your image so it doesn't get cut off
- **Format**: PNG with transparency works best
- **Quality**: Use the highest quality source image possible

---

## 🆘 Need Help?

If you have issues:
1. Make sure the files are named exactly `ic_launcher.png`
2. Make sure they're in the correct folders
3. Make sure they're PNG format (not JPG)
4. Upload ALL mipmap folders to GitHub

