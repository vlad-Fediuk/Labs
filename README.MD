# Student Journal

A simple console application for managing students and their grades.

## Entities

- **Student** — stores a student's name, age, and group.
- **Grade** — stores a student's name, subject, and grade value from `0.0` to `10.0`.
- **Subject** — defines the available subjects: `Java`, `Python`, `Cpp`, and `Csharp`.
- **Journal** — stores students and grades and provides operations for working with this data.
- **MyIO** — handles the user interface: menu display, input prompts, validation, and output messages.
- **IO** — provides basic console input and output methods used by `MyIO`.
- **Lab** — contains the application entry point and connects `Journal` with `MyIO`.

The `Journal` class contains only data-management logic. It does not read from or write to the console.

## Project structure

```text
Java/
├── src/       # Java source files
├── out/       # Compiled .class files
└── README.MD
```

## Requirements

- Java 25 or later

## Compilation and running

Run these commands from the project root directory:

```powershell
javac -d out src\*.java
java -cp out Lab
```

The application displays a menu for viewing students, adding students and grades, viewing grades, calculating average grades, and exiting the application.
