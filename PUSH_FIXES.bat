@echo off
echo ========================================
echo   Pushing Navigation Fixes to GitHub
echo ========================================
echo.

cd /d "%~dp0"

echo Adding files...
git add .

echo Committing...
git commit -m "Fix navigation errors - remove Safe Args dependency"

echo Pushing to GitHub...
git push

echo.
echo ========================================
echo   DONE! Run the build workflow now.
echo ========================================
pause
