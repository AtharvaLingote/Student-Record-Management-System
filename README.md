# 🎓 Student Record Management System (CLI Based)

A simple command-line application built in **Java** to manage student records. It supports **CRUD operations** (Create, Read, Update, Delete) and persists data using a **CSV file**.

---

## 🚀 Features

- ✅ Add new student records
- ✅ View all students
- ✅ Update student details by ID
- ✅ Delete student records by ID
- ✅ Save and load records using CSV file
- ✅ User-friendly menu interface

---

## 🧠 Concepts Covered

- Java Classes & Objects
- Encapsulation
- Collections (ArrayList)
- File I/O with CSV
- Loops and Conditionals
- Scanner (Java Standard Input)

---

## 📁 Project Structure

Task2/
├── StudentRecord/
│ └── students.csv # CSV file to persist student data
├── src/
│ ├── Student.java # Student model class
│ └── StudentManagement.java # Main CLI logic with CRUD + CSV
├── .gitignore # Ignore compiled files and IDE configs
└── README.md

## 💻 How to Run

### 🧾 Requirements
- Java 8 or higher
- Terminal or VS Code

### ⚙️ Steps to Compile and Run

1. Open terminal in the root folder.

2. Compile Java files:
```bash
javac src/*.java
```

3.Run the program:
```
java -cp src StudentManagement
```

## 💾 CSV Persistence

On startup, it loads data from data/students.csv (if available).
On exit, it saves all student records to the same CSV file.
This makes your records available between runs.

## 👨‍💻 Author
- Atharva Lingote
- GitHub:  [@AtharvaLingote](https://github.com/AtharvaLingote)
