@echo off
echo ========================================
echo VI-nod APK Builder
echo ========================================
echo.

REM Check if Java is installed
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERROR] Java is not installed!
    echo.
    echo You need to install Java JDK 17 first.
    echo.
    echo Download from:
    echo https://download.oracle.com/java/17/latest/jdk-17_windows-x64_bin.exe
    echo.
    echo After installing Java, run this script again.
    echo.
    pause
    exit /b 1
)

echo [OK] Java is installed!
echo.

REM Check Java version
echo Checking Java version...
java -version
echo.

REM Build APK
echo ========================================
echo Building APK...
echo This will take 3-5 minutes...
echo ========================================
echo.

call gradlew.bat assembleDebug

if %errorlevel% equ 0 (
    echo.
    echo ========================================
    echo SUCCESS! APK Built Successfully!
    echo ========================================
    echo.
    echo APK Location:
    echo %cd%\app\build\outputs\apk\debug\app-debug.apk
    echo.
    echo You can now copy this APK to your phone!
    echo.
    start explorer.exe "%cd%\app\build\outputs\apk\debug"
) else (
    echo.
    echo ========================================
    echo BUILD FAILED!
    echo ========================================
    echo.
    echo Check the error messages above.
    echo.
)

pause
