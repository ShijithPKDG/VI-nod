# 📱 VI-nod Visual Guide

## App Flow Diagram

```
┌─────────────────┐
│  Login Screen   │
│                 │
│  [Google Sign]  │
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│  Groups List    │
│                 │
│  ┌───────────┐  │
│  │ My Squad  │  │
│  │ 5 members │  │
│  └───────────┘  │
│                 │
│  [+] [Join]     │
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│   Chat Screen   │
│                 │
│  Friend: Hi!    │
│         You: Hey│
│                 │
│  [Type...][Send]│
└─────────────────┘
```

## Screen Breakdown

### 1. Login Screen
```
╔═══════════════════════════════╗
║                               ║
║         [App Logo]            ║
║                               ║
║          VI-nod               ║
║   Connect with your squad     ║
║                               ║
║                               ║
║                               ║
║  ┌─────────────────────────┐  ║
║  │  Sign in with Google    │  ║
║  └─────────────────────────┘  ║
║                               ║
╚═══════════════════════════════╝
```

**Features:**
- Purple gradient background
- App logo at top
- App name "VI-nod"
- Tagline "Connect with your squad"
- Google sign-in button at bottom

### 2. Groups Screen
```
╔═══════════════════════════════╗
║  Groups                    ☰  ║
╠═══════════════════════════════╣
║                               ║
║  ┌─────────────────────────┐  ║
║  │  My Squad               │  ║
║  │  5 members              │  ║
║  │  Code: ABC123           │  ║
║  └─────────────────────────┘  ║
║                               ║
║  ┌─────────────────────────┐  ║
║  │  College Friends        │  ║
║  │  8 members              │  ║
║  │  Code: XYZ789           │  ║
║  └─────────────────────────┘  ║
║                               ║
║                          [+]  ║
║                      [Join]   ║
╚═══════════════════════════════╝
```

**Features:**
- List of all your groups
- Each group shows:
  - Group name
  - Member count
  - Invite code
- Two floating buttons:
  - [+] Create new group
  - [Join] Join existing group
- Tap group to open chat

### 3. Chat Screen
```
╔═══════════════════════════════╗
║  My Squad                  ←  ║
╠═══════════════════════════════╣
║                               ║
║  ┌─────────────────┐          ║
║  │ Rahul           │          ║
║  │ Hey everyone!   │          ║
║  └─────────────────┘          ║
║                               ║
║          ┌─────────────────┐  ║
║          │ What's up?      │  ║
║          │ You             │  ║
║          └─────────────────┘  ║
║                               ║
║  ┌─────────────────┐          ║
║  │ Priya           │          ║
║  │ Let's meet up!  │          ║
║  └─────────────────┘          ║
║                               ║
╠═══════════════════════════════╣
║  [Type a message...]    [→]   ║
╚═══════════════════════════════╝
```

**Features:**
- Group name at top
- Messages in bubbles:
  - Others' messages: Left side, gray
  - Your messages: Right side, purple
- Sender name shown for others
- Input box at bottom
- Send button (arrow icon)

## Color Scheme

```
Primary Color:    #6B4EFF (Purple)
Primary Dark:     #5639E8 (Dark Purple)
Accent Color:     #FF6B9D (Pink)
Background:       #FFFFFF (White)
Surface:          #F5F5F5 (Light Gray)
Text:             #000000 (Black)
```

### Color Usage
- **Purple (#6B4EFF)**: 
  - Login screen background
  - Your message bubbles
  - Send button
  - Accent elements

- **Pink (#FF6B9D)**:
  - Floating action buttons
  - Highlights
  - Active states

- **Gray (#F5F5F5)**:
  - Others' message bubbles
  - Card backgrounds
  - Inactive elements

## UI Components

### Message Bubbles

**Your Message:**
```
                    ┌─────────────────┐
                    │ Hello everyone! │
                    │                 │
                    └─────────────────┘
```
- Purple background
- White text
- Aligned right
- Rounded corners

**Friend's Message:**
```
┌─────────────────┐
│ Rahul           │
│ Hey there!      │
│                 │
└─────────────────┘
```
- Gray background
- Black text
- Aligned left
- Sender name on top
- Rounded corners

### Group Card
```
┌─────────────────────────────┐
│  My Squad                   │
│  5 members                  │
│  Code: ABC123               │
└─────────────────────────────┘
```
- White background
- Shadow/elevation
- Rounded corners
- Tap to open

### Buttons

**Primary Button (Google Sign-in):**
```
┌─────────────────────────────┐
│  [G]  Sign in with Google   │
└─────────────────────────────┘
```
- White background
- Purple text
- Google icon
- Full width
- Rounded corners

**Floating Action Button:**
```
    ┌───┐
    │ + │
    └───┘
```
- Pink background
- White icon
- Circular
- Shadow

## Navigation

### Bottom Navigation (Future)
```
╔═══════════════════════════════╗
║                               ║
║        [Content Area]         ║
║                               ║
╠═══════════════════════════════╣
║  [Home] [Groups] [Fun] [You]  ║
╚═══════════════════════════════╝
```

Currently only Groups tab is active.

## Dialogs

### Create Group Dialog
```
┌─────────────────────────────┐
│  Create Group               │
├─────────────────────────────┤
│                             │
│  ┌───────────────────────┐  │
│  │ Group Name            │  │
│  └───────────────────────┘  │
│                             │
│  [Cancel]        [Create]   │
└─────────────────────────────┘
```

### Join Group Dialog
```
┌─────────────────────────────┐
│  Join Group                 │
├─────────────────────────────┤
│                             │
│  ┌───────────────────────┐  │
│  │ Invite Code           │  │
│  └───────────────────────┘  │
│                             │
│  [Cancel]          [Join]   │
└─────────────────────────────┘
```

## Icons Used

```
Groups:     👥 (people icon)
Add:        ➕ (plus icon)
Join:       👥+ (people add icon)
Send:       ➡️ (arrow icon)
Back:       ⬅️ (back arrow)
Menu:       ☰ (hamburger menu)
```

## Dark Mode (Automatic)

App automatically switches to dark mode based on system settings:

```
Dark Mode Colors:
Background:   #121212 (Dark Gray)
Surface:      #1E1E1E (Lighter Dark)
Text:         #FFFFFF (White)
Primary:      #8B6EFF (Lighter Purple)
```

## Animations

### Screen Transitions
- Slide in from right when opening chat
- Slide out to left when going back
- Fade in for dialogs

### Message Animations
- New messages slide up from bottom
- Smooth scroll to latest message

### Button Animations
- Ripple effect on tap
- Scale slightly on press

## Typography

```
App Name:        48sp, Bold
Tagline:         16sp, Regular
Group Name:      18sp, Bold
Member Count:    14sp, Regular
Message Text:    15sp, Regular
Sender Name:     12sp, Bold
Button Text:     16sp, Medium
```

## Spacing & Padding

```
Screen Padding:     16dp
Card Margin:        8dp
Card Padding:       16dp
Message Padding:    12dp
Button Height:      56dp
Icon Size:          24dp
```

## Future UI Elements (Phase 2)

### Poll Card
```
┌─────────────────────────────┐
│  Who is always late?        │
├─────────────────────────────┤
│  ○ Rahul        (3 votes)   │
│  ○ Priya        (1 vote)    │
│  ○ You          (0 votes)   │
└─────────────────────────────┘
```

### Badge Display
```
┌─────────────────────────────┐
│  Your Badges                │
├─────────────────────────────┤
│  🏆 Roast King              │
│  😂 Meme Master             │
│  ❤️  Most Loved             │
└─────────────────────────────┘
```

### Leaderboard
```
┌─────────────────────────────┐
│  Friendship Scores          │
├─────────────────────────────┤
│  1. Rahul        850 pts    │
│  2. You          720 pts    │
│  3. Priya        680 pts    │
└─────────────────────────────┘
```

## Responsive Design

App adapts to different screen sizes:
- **Small phones**: Single column, compact spacing
- **Large phones**: Comfortable spacing, larger text
- **Tablets**: Two-column layout (future)

## Accessibility

- High contrast colors
- Large touch targets (48dp minimum)
- Clear text hierarchy
- Screen reader support
- Keyboard navigation support

## Design Principles

1. **Simple**: Clean, uncluttered interface
2. **Colorful**: Fun purple and pink theme
3. **Modern**: Material Design 3 components
4. **Friendly**: Rounded corners, soft shadows
5. **Fast**: Smooth animations, instant feedback

---

This visual guide helps you understand the app's look and feel! 🎨
