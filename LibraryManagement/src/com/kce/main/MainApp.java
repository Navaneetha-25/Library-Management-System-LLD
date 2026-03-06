package com.kce.main;

import java.util.Scanner;
import com.kce.service.LibraryService;

public class MainApp {

    static Scanner sc = new Scanner(System.in);
    static LibraryService service = new LibraryService();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\nLibrary Management System");
            System.out.println("1.Add Book");
            System.out.println("2.Register Member");
            System.out.println("3.Borrow Book");
            System.out.println("4.Return Book");
            System.out.println("5.Search Book");
            System.out.println("6.Member Report");
            System.out.println("7.Book Report");
            System.out.println("8.Top Borrowers");
            System.out.println("9.Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Number of Copies: ");
                    int copies = sc.nextInt();
                    service.addBook(bookId, title, author, copies);
                    break;
                case 2:
                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Member Name: ");
                    String name = sc.nextLine();
                    service.registerMember(memberId, name);
                    break;
                case 3:
                    System.out.print("Enter Member ID: ");
                    int mId = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();
                    service.borrowBook(mId, bId);
                    break;
                case 4:
                    System.out.print("Enter Member ID: ");
                    int rmId = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int rbId = sc.nextInt();
                    service.returnBook(rmId, rbId);
                    break;
                case 5:
                    System.out.print("Enter title or author keyword: ");
                    sc.nextLine();
                    String key = sc.nextLine();
                    service.searchBook(key);
                    break;
                case 6:
                    System.out.print("Enter Member ID: ");
                    int memId = sc.nextInt();
                    service.memberReport(memId);
                    break;
                case 7:
                    System.out.print("Enter Book ID: ");
                    int bkId = sc.nextInt();
                    service.bookReport(bkId);
                    break;
                case 8:
                    service.topBorrowers();
                    break;
                case 9:
                    System.out.println("Exited");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}