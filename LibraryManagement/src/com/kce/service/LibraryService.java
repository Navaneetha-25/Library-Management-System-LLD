package com.kce.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kce.entity.Book;
import com.kce.entity.BorrowRecord;
import com.kce.entity.Member;


public class LibraryService {

    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    public void addBook(int id, String title, String author, int copies) {

        for (Book b : books) {
            if (b.getBookId() == id) {
                System.out.println("Book ID already exists!");
                return;
            }
        }

        Book book = new Book(id, title, author, copies);
        books.add(book);

        System.out.println("Book added successfully.");
    }

    public void registerMember(int id, String name) {

        for (Member m : members) {
            if (m.getMemberId() == id) {
                System.out.println("Member ID already exists!");
                return;
            }
        }

        Member member = new Member(id, name);
        members.add(member);

        System.out.println("Member registered successfully.");
    }

    public Book findBook(int id) {

        for (Book b : books) {
            if (b.getBookId() == id) {
                return b;
            }
        }

        return null;
    }

    public Member findMember(int id) {

        for (Member m : members) {
            if (m.getMemberId() == id) {
                return m;
            }
        }

        return null;
    }

    public void borrowBook(int memberId, int bookId) {

        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member == null || book == null) {
            System.out.println("Member or Book not found.");
            return;
        }

        if (member.getBorrowedBooks().size() == 3) {
            System.out.println("Borrow limit reached.");
            return;
        }

        for (BorrowRecord br : member.getBorrowedBooks()) {
            if (br.getBook().getBookId() == bookId) {
                System.out.println("You already borrowed this book.");
                return;
            }
        }

        if (book.getCopies() == 0) {
            System.out.println("No copies available.");
            return;
        }

        BorrowRecord record = new BorrowRecord(book);

        member.getBorrowedBooks().add(record);
        member.increaseBorrowCount();

        book.decreaseCopy();
        book.getBorrowedMembers().add(member);

        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(int memberId, int bookId) {

        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member == null || book == null) {
            System.out.println("Member or Book not found.");
            return;
        }

        BorrowRecord target = null;

        for (BorrowRecord br : member.getBorrowedBooks()) {
            if (br.getBook().getBookId() == bookId) {
                target = br;
                break;
            }
        }

        if (target == null) {
            System.out.println("This member didn't borrow this book.");
            return;
        }

        LocalDate today = LocalDate.now();

        long days = today.toEpochDay() - target.getDueDate().toEpochDay();

        if (days > 0) {
            int fine = (int) days * 2;
            System.out.println("Fine: Rs." + fine);
        }

        member.getBorrowedBooks().remove(target);

        book.increaseCopy();
        book.getBorrowedMembers().remove(member);

        System.out.println("Book returned successfully.");
    }

    public void searchBook(String key) {

        key = key.toLowerCase();

        for (Book b : books) {

            if (b.getTitle().toLowerCase().contains(key)
                    || b.getAuthor().toLowerCase().contains(key)) {

                System.out.println(
                        b.getBookId() + " | " +
                        b.getTitle() + " | " +
                        b.getAuthor() + " | Copies: " + b.getCopies());
            }
        }
    }

    public void memberReport(int memberId) {

        Member member = findMember(memberId);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        for (BorrowRecord br : member.getBorrowedBooks()) {

            System.out.println("Book: " + br.getBook().getTitle());
            System.out.println("Borrow Date: " + br.getBorrowDate());
            System.out.println("Due Date: " + br.getDueDate());
            System.out.println();
        }
    }

    public void bookReport(int bookId) {

        Book book = findBook(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.println("Available Copies: " + book.getCopies());

        for (Member m : book.getBorrowedMembers()) {
            System.out.println("Borrowed by: " + m.getName());
        }
    }

    public void topBorrowers() {

        Collections.sort(members, (a, b) -> b.getTotalBorrowed() - a.getTotalBorrowed());

        for (Member m : members) {

            System.out.println(
                    m.getName() +
                    " | Total Borrowed: " +
                    m.getTotalBorrowed());
        }
    }
}