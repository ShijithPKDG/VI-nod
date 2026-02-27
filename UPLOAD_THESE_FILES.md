# 📤 Upload These Fixed Files to GitHub

## Files That Need to be Updated:

### 1. activity_login.xml (FIXED)
**Location:** `app/src/main/res/layout/activity_login.xml`

**How to update:**
1. Go to your GitHub repo
2. Navigate to: `app/src/main/res/layout/activity_login.xml`
3. Click **pencil icon** (Edit)
4. **Delete all content**
5. **Copy and paste this:**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="?attr/colorPrimary"
    android:padding="24dp">

    <ImageView
        android:id="@+id/iv_logo"
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:src="@drawable/ic_groups"
        android:tint="@android:color/white"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toTopOf="@id/tv_app_name"
        android:contentDescription="App Logo" />

    <TextView
        android:id="@+id/tv_app_name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="VI-nod"
        android:textSize="48sp"
        android:textStyle="bold"
        android:textColor="@android:color/white"
        app:layout_constraintTop_toBottomOf="@id/iv_logo"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toTopOf="@id/tv_tagline" />

    <TextView
        android:id="@+id/tv_tagline"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Connect with your squad"
        android:textSize="16sp"
        android:textColor="@android:color/white"
        android:alpha="0.8"
        app:layout_constraintTop_toBottomOf="@id/tv_app_name"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toTopOf="@id/btn_google_sign_in"
        android:layout_marginTop="8dp" />

    <com.google.android.material.button.MaterialButton
        android:id="@+id/btn_google_sign_in"
        android:layout_width="0dp"
        android:layout_height="56dp"
        android:text="Sign in with Google"
        android:textColor="?attr/colorPrimary"
        app:icon="@drawable/ic_google"
        app:iconGravity="textStart"
        app:iconPadding="8dp"
        app:cornerRadius="28dp"
        android:backgroundTint="@android:color/white"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginBottom="32dp" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

6. Click **"Commit changes"**

---

### 2. Delete These Files (if they exist):
- `app/src/main/res/mipmap-hdpi/ic_launcher.xml`
- `app/src/main/res/mipmap-hdpi/ic_launcher_round.xml`

**How to delete:**
1. Navigate to each file
2. Click the file
3. Click **trash icon** (Delete)
4. Commit

---

## 🚀 After Updating:

1. Go to **Actions** tab
2. Click **"Build Android APK"**
3. Click **"Run workflow"**
4. Wait for green checkmark ✅
5. Download APK from Artifacts!

---

**This will fix all the errors!** 🎉
