@echo off
echo ========================================
echo   File Verification for GitHub Upload
echo ========================================
echo.
echo Checking if all required Mock files exist...
echo.

set "MISSING=0"

if exist "app\src\main\java\com\vinod\app\data\repository\MockAuthRepository.kt" (
    echo [OK] MockAuthRepository.kt
) else (
    echo [MISSING] MockAuthRepository.kt
    set "MISSING=1"
)

if exist "app\src\main\java\com\vinod\app\data\repository\MockGroupRepository.kt" (
    echo [OK] MockGroupRepository.kt
) else (
    echo [MISSING] MockGroupRepository.kt
    set "MISSING=1"
)

if exist "app\src\main\java\com\vinod\app\data\repository\MockChatRepository.kt" (
    echo [OK] MockChatRepository.kt
) else (
    echo [MISSING] MockChatRepository.kt
    set "MISSING=1"
)

if exist "app\src\main\java\com\vinod\app\ui\MockLoginActivity.kt" (
    echo [OK] MockLoginActivity.kt
) else (
    echo [MISSING] MockLoginActivity.kt
    set "MISSING=1"
)

if exist "app\src\main\java\com\vinod\app\viewmodel\AuthViewModel.kt" (
    echo [OK] AuthViewModel.kt
) else (
    echo [MISSING] AuthViewModel.kt
    set "MISSING=1"
)

if exist "app\src\main\java\com\vinod\app\viewmodel\GroupViewModel.kt" (
    echo [OK] GroupViewModel.kt
) else (
    echo [MISSING] GroupViewModel.kt
    set "MISSING=1"
)

if exist "app\src\main\java\com\vinod\app\viewmodel\ChatViewModel.kt" (
    echo [OK] ChatViewModel.kt
) else (
    echo [MISSING] ChatViewModel.kt
    set "MISSING=1"
)

if exist "app\src\main\res\layout\activity_mock_login.xml" (
    echo [OK] activity_mock_login.xml
) else (
    echo [MISSING] activity_mock_login.xml
    set "MISSING=1"
)

echo.
echo ========================================

if "%MISSING%"=="0" (
    echo All files are present! Ready to upload to GitHub.
    echo.
    echo NEXT STEPS:
    echo 1. Go to your GitHub repository
    echo 2. Delete the entire 'app' folder
    echo 3. Upload the 'app' folder from this directory
    echo 4. Run the build workflow
) else (
    echo ERROR: Some files are missing!
    echo Please check the files above.
)

echo.
echo ========================================
echo.
pause
