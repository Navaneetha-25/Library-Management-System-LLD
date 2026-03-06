package com.kce.entity;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private int copies;

    private List<Member> borrowedMembers = new ArrayList<>();

    public Book(int bookId, String title, String author, int copies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopies() {
        return copies;
    }

    public void decreaseCopy() {
        copies--;
    }

    public void increaseCopy() {
        copies++;
    }

    public List<Member> getBorrowedMembers() {
        return borrowedMembers;
    }
}