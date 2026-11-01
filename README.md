# MEMORY FLIP: THE ULTIMATE MATCH

A polished Java 17 + JavaFX + Maven desktop memory-card game.

## Requirements
- JDK 17+
- Maven 3.9+
- VS Code with Extension Pack for Java (recommended)

## Run
```powershell
cd MemoryFlip
mvn clean javafx:run
```

If `mvn` is not on PATH, use your Maven executable:
```powershell
"C:\path\to\maven\bin\mvn.cmd" clean javafx:run
```

## Project
The application uses MVC-style separation, model classes, managers, reusable UI components, JavaFX CSS, local JSON-like text storage for scores/achievements/settings, and optional JavaFX audio resources.

No database or server is required. Missing audio files are ignored safely.

## Storage
Local data is saved under the user's home directory in `.memoryflip/`.

## Controls
Click cards to flip. Match all pairs. Use Hint, Pause, Restart and Main Menu as needed.