# Library Management System (Console Based)

## Description

This project is a simple **Library Management System** implemented in Java. The system runs completely in memory and allows users to manage books, members, and borrowing activities through a console-based menu.

## Features

* Add new books with unique Book ID
* Register library members with unique Member ID
* Borrow books (maximum 3 books per member)
* Return books and calculate overdue fine
* Search books by title or author (supports partial match)
* View member borrowing report
* View book availability report
* Display top borrowers based on total books borrowed

## Functional Rules

* A member can borrow **maximum 3 books** at a time.
* **Borrow duration is 14 days**.
* **Fine: Rs.2 per overdue day**.
* A member cannot borrow the **same book twice simultaneously**.
* Book and Member IDs must be **unique**.
* All data is stored **in memory only** (no database or file storage).

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Collections (ArrayList)
* Console-based user interface

## How to Run

1. Compile the Java files.
2. Run the `MainApp` class.
3. Use the menu to perform library operations.

### Output

<img width="688" height="733" alt="image" src="https://github.com/user-attachments/assets/ac5479f0-2d93-409a-b0d4-4f0a0534f75c" />
<img width="554" height="800" alt="image" src="https://github.com/user-attachments/assets/216bc7a2-3c90-4ba2-9413-cfc5f39b5c7e" />
<img width="657" height="787" alt="image" src="https://github.com/user-attachments/assets/36df0065-edd2-4898-8d82-898629588f23" />
<img width="538" height="772" alt="image" src="https://github.com/user-attachments/assets/a905f9ab-83a7-42dd-bb56-9286281aee7a" />
<img width="431" height="636" alt="image" src="https://github.com/user-attachments/assets/72d193c3-80c0-4e07-9aa9-d0d16444e1d3" />


