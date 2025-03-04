package com.ewis;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            //Create a BookDAO instance
            BookDAO bookDAO = new BookDAO();

            //Add a new book
            Book book1 = new Book(0, "Maze runner", "Nigel chase", "sci-fi", true);
            bookDAO.addBook(book1);
            System.out.println("Book added successfully.");

            //Get all books
            List<Book> books = bookDAO.getAllBooks();
            System.out.println("List of books: ");
            for (Book book : books){
                System.out.println(book);
            }

            //Update a book
            Book bookToUpdate = books.get(0);
            bookToUpdate.setTitle("Updated Title");
            bookDAO.updateBook(bookToUpdate);
            System.out.println("Book updated successfully.");

            //Delete a book
            bookDAO.deleteBook(bookToUpdate.getId());
            System.out.println("Book deleted successfully.");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
