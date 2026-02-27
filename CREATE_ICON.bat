@echo off
echo ========================================
echo   VI-nod Custom Icon Creator
echo ========================================
echo.
echo This will help you create app icons from "Image (2).jpg"
echo.
echo OPTION 1: Online Tool (Easiest - Recommended)
echo --------------------------------------------
echo 1. Visit: https://icon.kitchen/
echo 2. Click "Upload Image"
echo 3. Select "Image (2).jpg" from this folder
echo 4. Choose "Square" shape
echo 5. Adjust the image position/zoom if needed
echo 6. Click "Download" button
echo 7. Extract the downloaded ZIP file
echo 8. Copy all mipmap-* folders to: app\src\main\res\
echo    (Replace the existing mipmap folders)
echo.
echo OPTION 2: Use Image Resizer Tool
echo --------------------------------------------
echo 1. Download "Image Resizer for Windows" (free)
echo    https://www.bricelam.net/ImageResizer/
echo 2. Right-click "Image (2).jpg"
echo 3. Select "Resize pictures"
echo 4. Create these sizes:
echo    - 48x48 px   (save to: app\src\main\res\mipmap-mdpi\ic_launcher.png)
echo    - 72x72 px   (save to: app\src\main\res\mipmap-hdpi\ic_launcher.png)
echo    - 96x96 px   (save to: app\src\main\res\mipmap-xhdpi\ic_launcher.png)
echo    - 144x144 px (save to: app\src\main\res\mipmap-xxhdpi\ic_launcher.png)
echo    - 192x192 px (save to: app\src\main\res\mipmap-xxxhdpi\ic_launcher.png)
echo.
echo OPTION 3: Use Online Image Resizer
echo --------------------------------------------
echo 1. Visit: https://www.iloveimg.com/resize-image
echo 2. Upload "Image (2).jpg"
echo 3. Resize to each size listed above
echo 4. Download and save to the correct folders
echo.
echo ========================================
echo After creating icons:
echo ========================================
echo 1. Delete the .xml files in mipmap-* folders
echo 2. Replace them with your .png files
echo 3. Upload to GitHub
echo 4. Run the build workflow
echo.
echo Press any key to open icon.kitchen in your browser...
pause > nul
start https://icon.kitchen/
