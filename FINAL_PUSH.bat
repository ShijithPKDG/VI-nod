@echo off
echo ========================================
echo   FINAL PUSH - All Files to GitHub
echo ========================================
echo.
echo This will force push ALL your local files to GitHub
echo.
pause

cd /d "%~dp0"

echo.
echo Step 1: Checking Git status...
git status

echo.
echo Step 2: Adding ALL files (including changes and deletions)...
git add -A

echo.
echo Step 3: Committing...
git commit -m "Fix all compilation errors - complete Mock implementation"

echo.
echo Step 4: Pushing to GitHub...
git push origin main

if errorlevel 1 (
    echo.
    echo Push failed. Trying 'master' branch...
    git push origin master
)

echo.
echo ========================================
echo   DONE!
echo ========================================
echo.
echo Now go to GitHub Actions and run the workflow.
echo.
pause
