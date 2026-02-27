@echo off
echo ========================================
echo   Committing Changes to GitHub
echo ========================================
echo.
echo This will upload all your local changes to GitHub
echo.
pause

cd /d "%~dp0"

echo.
echo Step 1: Adding all files...
git add .

echo.
echo Step 2: Committing changes...
git commit -m "Remove Firebase files, use Mock repositories"

echo.
echo Step 3: Pushing to GitHub...
git push

echo.
echo ========================================
echo   DONE!
echo ========================================
echo.
echo Your changes are now on GitHub.
echo Go to GitHub Actions and run the workflow!
echo.
pause
