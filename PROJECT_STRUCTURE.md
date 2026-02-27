# VI-nod Project Structure

## Overview
```
VI-nod/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/vinod/app/
│   │       │   ├── data/
│   │       │   │   ├── model/          # Data models
│   │       │   │   │   ├── User.kt
│   │       │   │   │   ├── Group.kt
│   │       │   │   │   └── Message.kt
│   │       │   │   └── repository/     # Data layer
│   │       │   │       ├── AuthRepository.kt
│   │       │   │       ├── GroupRepository.kt
│   │       │   │       └── ChatRepository.kt
│   │       │   ├── ui/                 # UI layer
│   │       │   │   ├── adapter/
│   │       │   │   │   ├── GroupAdapter.kt
│   │       │   │   │   └── MessageAdapter.kt
│   │       │   │   ├── LoginActivity.kt
│   │       │   │   ├── MainActivity.kt
│   │       │   │   ├── GroupsFragment.kt
│   │       │   │   └── ChatFragment.kt
│   │       │   └── viewmodel/          # ViewModels
│   │       │       ├── AuthViewModel.kt
│   │       │       ├── GroupViewModel.kt
│   │       │       └── ChatViewModel.kt
│   │       ├── res/
│   │       │   ├── drawable/           # Icons
│   │       │   ├── layout/             # XML layouts
│   │       │   ├── menu/               # Navigation menu
│   │       │   ├── navigation/         # Navigation graph
│   │       │   └── values/             # Colors, strings, themes
│   │       └── AndroidManifest.xml
│   ├── build.gradle                    # App dependencies
│   └── google-services.json            # Firebase config (YOU ADD THIS)
├── build.gradle                        # Project build config
├── settings.gradle
├── gradle.properties
├── README.md
├── SETUP_GUIDE.md
├── BUILD_APK_INSTRUCTIONS.md
└── PROJECT_STRUCTURE.md (this file)
```

## Architecture: MVVM (Model-View-ViewModel)

### Data Layer (`data/`)
Handles all data operations and business logic.

**Models** (`data/model/`)
- `User.kt` - User profile data
- `Group.kt` - Group information
- `Message.kt` - Chat message data

**Repositories** (`data/repository/`)
- `AuthRepository.kt` - Authentication (Google sign-in, user profiles)
- `GroupRepository.kt` - Group operations (create, join, list)
- `ChatRepository.kt` - Real-time messaging

### ViewModel Layer (`viewmodel/`)
Manages UI state and business logic.

- `AuthViewModel.kt` - Login state management
- `GroupViewModel.kt` - Group operations state
- `ChatViewModel.kt` - Chat state and message handling

### UI Layer (`ui/`)
User interface components.

**Activities**
- `LoginActivity.kt` - Entry point, Google sign-in
- `MainActivity.kt` - Main container with bottom navigation

**Fragments**
- `GroupsFragment.kt` - List of user's groups
- `ChatFragment.kt` - Group chat interface

**Adapters** (`ui/adapter/`)
- `GroupAdapter.kt` - RecyclerView adapter for groups list
- `MessageAdapter.kt` - RecyclerView adapter for chat messages

### Resources (`res/`)

**Layouts** (`layout/`)
- `activity_login.xml` - Login screen
- `activity_main.xml` - Main screen with navigation
- `fragment_groups.xml` - Groups list screen
- `fragment_chat.xml` - Chat screen
- `item_group.xml` - Single group item
- `item_message_sent.xml` - Sent message bubble
- `item_message_received.xml` - Received message bubble

**Drawables** (`drawable/`)
- Vector icons for UI elements

**Navigation** (`navigation/`)
- `nav_graph.xml` - Navigation flow between screens

**Values** (`values/`)
- `colors.xml` - App color palette
- `strings.xml` - Text strings (includes Firebase config)
- `themes.xml` - App theme (light mode)
- `values-night/themes.xml` - Dark mode theme

## Key Technologies

### Firebase Services
- **Authentication** - Google Sign-in
- **Firestore** - Real-time database for groups and messages
- **Cloud Messaging** - Push notifications (future)

### Android Jetpack
- **Navigation** - Fragment navigation
- **ViewModel** - Lifecycle-aware state management
- **LiveData** - Observable data holder
- **ViewBinding** - Type-safe view access

### UI Components
- **Material Design 3** - Modern UI components
- **RecyclerView** - Efficient lists
- **BottomNavigationView** - Tab navigation
- **FloatingActionButton** - Action buttons

### Kotlin Features
- **Coroutines** - Asynchronous operations
- **Flow** - Real-time data streams
- **Sealed Classes** - Type-safe state management

## Data Flow Example: Sending a Message

```
1. User types message in ChatFragment
2. User clicks send button
3. ChatFragment calls ChatViewModel.sendMessage()
4. ChatViewModel calls ChatRepository.sendMessage()
5. ChatRepository writes to Firestore
6. Firestore triggers snapshot listener
7. ChatRepository emits new message via Flow
8. ChatViewModel updates LiveData
9. ChatFragment observes LiveData
10. MessageAdapter updates RecyclerView
11. New message appears in chat
```

## Firebase Database Structure

```
Firestore Collections:

users/
  {userId}/
    - uid: string
    - name: string
    - email: string
    - photoUrl: string
    - bio: string
    - createdAt: timestamp

groups/
  {groupId}/
    - groupId: string
    - name: string
    - inviteCode: string (6 chars)
    - adminId: string
    - members: array[userId]
    - createdAt: timestamp

messages/
  {messageId}/
    - messageId: string
    - groupId: string
    - senderId: string
    - senderName: string
    - text: string
    - timestamp: timestamp
```

## Adding New Features

### Example: Adding Polls Feature

1. **Create Model** (`data/model/Poll.kt`)
```kotlin
data class Poll(
    val pollId: String = "",
    val groupId: String = "",
    val question: String = "",
    val options: List<String> = emptyList(),
    val votes: Map<String, String> = emptyMap() // userId to optionId
)
```

2. **Create Repository** (`data/repository/PollRepository.kt`)
```kotlin
class PollRepository {
    suspend fun createPoll(poll: Poll): Result<Poll>
    suspend fun vote(pollId: String, userId: String, option: String): Result<Unit>
    fun getGroupPolls(groupId: String): Flow<List<Poll>>
}
```

3. **Create ViewModel** (`viewmodel/PollViewModel.kt`)
```kotlin
class PollViewModel : ViewModel() {
    private val repository = PollRepository()
    val polls: LiveData<List<Poll>>
    fun createPoll(poll: Poll)
    fun vote(pollId: String, option: String)
}
```

4. **Create UI** (`ui/PollsFragment.kt` + layouts)
```kotlin
class PollsFragment : Fragment() {
    private val viewModel: PollViewModel by viewModels()
    // UI implementation
}
```

5. **Add to Navigation** (`res/navigation/nav_graph.xml`)
```xml
<fragment
    android:id="@+id/pollsFragment"
    android:name="com.vinod.app.ui.PollsFragment" />
```

## Code Style Guidelines

### Naming Conventions
- **Classes**: PascalCase (e.g., `GroupRepository`)
- **Functions**: camelCase (e.g., `createGroup`)
- **Variables**: camelCase (e.g., `groupId`)
- **Constants**: UPPER_SNAKE_CASE (e.g., `MAX_MEMBERS`)
- **XML IDs**: snake_case (e.g., `btn_send`)

### File Organization
- One class per file
- File name matches class name
- Group related files in packages

### Kotlin Best Practices
- Use `val` over `var` when possible
- Prefer data classes for models
- Use sealed classes for states
- Leverage coroutines for async operations
- Use Flow for real-time data

## Testing Strategy (Future)

### Unit Tests
- Repository tests (mock Firestore)
- ViewModel tests (mock repositories)

### UI Tests
- Fragment navigation tests
- User interaction tests

### Integration Tests
- End-to-end flow tests
- Firebase integration tests

## Performance Considerations

### Current Optimizations
- ViewBinding (no findViewById)
- RecyclerView with DiffUtil
- Coroutines for async operations
- Firestore query optimization

### Future Optimizations
- Image caching with Glide
- Pagination for large message lists
- Offline support with Firestore cache
- ProGuard for release builds

## Security Features

### Current
- Firebase Authentication
- Firestore security rules (test mode)
- Private groups (invite-only)

### Future
- Production Firestore rules
- Content moderation
- Report/block functionality
- End-to-end encryption

## Roadmap

### Phase 1 (Current) ✅
- Google Authentication
- Create/Join groups
- Real-time chat

### Phase 2 (Next)
- Anonymous teasing
- Polls & voting
- Friendship scores

### Phase 3 (Future)
- Badges & achievements
- Inside jokes section
- Event planner
- Leaderboard

### Phase 4 (Advanced)
- Push notifications
- Media sharing (images, videos)
- Voice messages
- Stories feature

## Contributing

When adding features:
1. Follow MVVM architecture
2. Create models first
3. Implement repository layer
4. Add ViewModel
5. Build UI
6. Test thoroughly
7. Update documentation

## Resources

- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Android Developers](https://developer.android.com/)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Material Design](https://m3.material.io/)

---

Happy coding! 🚀
