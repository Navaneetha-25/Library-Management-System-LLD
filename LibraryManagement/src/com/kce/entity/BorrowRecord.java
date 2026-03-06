package com.kce.entity;

import java.time.LocalDate;

public class BorrowRecord {

    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public BorrowRecord(Book book) {
        this.book = book;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(14);
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}