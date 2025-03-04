package com.ewis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    //Add a new book
    public void addBook(Book book) throws SQLException{
        String sql = "INSERT INTO books(title, author, genre, available) VALUES (?,?,?,?)";
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement stmt =  con.prepareStatement(sql)){
           stmt.setString(1, book.getTitle());
           stmt.setString(2, book.getAuthor());
           stmt.setString(3, book.getGenre());
           stmt.setBoolean(4, book.isAvailable());
           stmt.executeUpdate();
        }
    }

    //Get all books
    public List<Book> getAllBooks() throws SQLException{
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
           while (rs.next()){
               Book book = new Book(
                       rs.getInt("id"),
                       rs.getString("title"),
                       rs.getString("author"),
                       rs.getString("genre"),
                       rs.getBoolean("available")

               );
               books.add(book);
           }

        }
        return books;
    }

    //Update a book
    public void updateBook(Book book) throws SQLException{
        String sql = "UPDATE books SET title = ?, author = ?, genre = ?, available = ? WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getGenre());
            stmt.setBoolean(4, book.isAvailable());
            stmt.setInt(5, book.getId());
            stmt.executeUpdate();

        }
    }

    //Delete a book
    public void  deleteBook(int id) throws SQLException{
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
