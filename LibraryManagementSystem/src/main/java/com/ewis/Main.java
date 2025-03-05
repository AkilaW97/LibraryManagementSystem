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

        System.out.println("\n------------------------------------------------\n");

        try{
            //Create a MemberDAO instance
            MemberDAO memberDAO = new MemberDAO();

            //Add a new member
            Member member1 = new Member(0, "Nethmini", "nw@gmail.com");

            memberDAO.addMember(member1);
            System.out.println("Member added successfully.");

            //Get all members
            List<Member> members = memberDAO.getAllMembers();
            System.out.println("List of members:");

            for (Member member: members){
                System.out.println(member);
            }

            //Update a member
            if(!members.isEmpty()){
                Member memberToUpdate = members.get(0);
                memberToUpdate.setName("Updated Name");
                memberToUpdate.setEmail("updated. email@example.com");
                memberDAO.updateMember(memberToUpdate);
                System.out.println("Member updated successfully.");
            }

            //Delete a member
            if(!members.isEmpty()){
                memberDAO.deleteMember(members.get(0).getId());
                System.out.println("Member deleted successfully.");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
