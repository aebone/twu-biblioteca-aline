package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaManager {

    private ArrayList<Book> books = new ArrayList<Book>();
    private Scanner reader = new Scanner(System.in);

    public BibliotecaManager(int option) {

        initiateBooks();
        manageMenu(option);

    }

    private void manageMenu(int option) {

        if (option == 1) {
            listBooks();
        } else if (option == 2) {
            return;
        } else {
            System.out.println("Wrong option, try again.");
            int newOption = reader.nextInt();
            manageMenu(newOption);
        }
    }

    private void listBooks() {
        for (Book book : books) {
            System.out.println(String.valueOf("ID: " + book.getId()) + " | " +
                    book.getName() + " | " + book.getAuthor() + " | " +
                    book.getYear() + " | Rented: " + book.isRented());
        }
        System.out.println("\nIf you want to rent a book, type the book ID:");

        rentABook();
    }

    private void rentABook() {
        int chosenBookId = reader.nextInt();

        for (Book book : books) {

            if (book.getId() == chosenBookId) {
                if (book.isRented()) {
                    System.out.println("You can't rent this. It's already rented.\n");
                } else {
                    System.out.println("You rented " + book.getName() + " by " + book.getAuthor() + "\n");
                    book.setRented(true);
                }
            }
        }

        listBooks();
    }

    private void initiateBooks() {
        Book book1 = new Book(1,"Head First Java", "Kathy Sierra", "2011");
        Book book2 = new Book(2,"Test Driven Development: By Example", "Kent Beck", "2000");
        Book book3 = new Book(3,"Bla bla bla", "Nobody", "2011");
        books.add(book1);
        books.add(book2);
        books.add(book3);
    }

}
