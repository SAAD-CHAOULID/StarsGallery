# Starts Gallery - Android Project


https://github.com/user-attachments/assets/48415393-a5bf-4c17-b03e-463e36c51ea0



Starts Gallery is a revitalized Android application designed to showcase a collection of characters. The app provides a clean, modern interface for browsing, searching, and managing character ratings.

## 🚀 Features

- **Animated Splash Screen**: A clean, professional entry point with smooth logo and typography animations.
- **Dynamic Character List**: An optimized `RecyclerView` displaying a feed of characters with circular avatars and ratings.
- **Real-time Search**: Instant filtering of the gallery by name using an integrated `SearchView`.
- **Rating Management**: Interactive `RatingBar` within a custom dialog to update character ratings on the fly.
- **Social Sharing**: Built-in sharing functionality to spread the word about the application.
- **English Localization**: The entire UI and codebase have been revitalized with clear English terminology.

## 🛠️ Architecture & Technologies

- **Language**: Java
- **UI Components**: `RecyclerView`, `ConstraintLayout`, `Material Design`
- **Image Handling**: `Glide` for efficient resource loading
- **Custom Views**: `CircleImageView` for elegant profile displays
- **Design Pattern**: `Singleton` for data management, `DAO` for clean CRUD operations
- **Logic**: Custom `Filterable` implementation for high-performance searching

## 📁 Project Structure

- **`com.example.starsgallery.beans`**: Contains the `Star` model (representing characters) with natural naming conventions.
- **`com.example.starsgallery.dao`**: Defines the generic `IDao` interface for standardized data access.
- **`com.example.starsgallery.service`**: Implements `StarService` for logic and `StarData` for decoupled dataset initialization.
- **`com.example.starsgallery.ui`**: Contains `SplashActivity` and `ListActivity` with clean, refactored logic.
- **`com.example.starsgallery.adapter`**: Features the `StarAdapter`, optimized for filtering and ViewHolder reuse.

## 📊 Key Methods

| Method | Description |
| :--- | :--- |
| `findAll()` | Fetches the complete list of characters from the service. |
| `update()` | Persists rating changes to the character collection. |
| `getFilter()` | Handles the logic for the dynamic search functionality. |
| `onCreate()` | Initializes the UI components and sets up the Toolbar. |

