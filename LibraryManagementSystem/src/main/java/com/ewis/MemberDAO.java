package com.ewis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    //Add a new member
    public void addMember(Member member) throws SQLException {
        String sql = "INSERT INTO members (name, email) VALUES (?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, member.getName());
            stmt.setString(2, member.getEmail());
            stmt.executeUpdate();
        }
    }

    //Get all members
    public List<Member> getAllMembers() throws SQLException {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members";
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Member member = new Member(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
                members.add(member);
            }
        }
        return members;
    }

    //Update a member
    public void updateMember(Member member) throws SQLException{
        String sql = "UPDATE members SET name = ?, email = ? WHERE id = ?";
        try(Connection con = DatabaseConnection.getConnection();
           PreparedStatement stmt = con.prepareStatement(sql)){
          stmt.setString(1, member.getName());
          stmt.setString(2, member.getEmail());
          stmt.setInt(3, member.getId());
          stmt.executeUpdate();
        }
    }

    //Delete a member
    public void deleteMember(int id) throws SQLException{
        String sql = "DELETE FROM members WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)){
           stmt.setInt(1, id);
           stmt.executeUpdate();
        }
    }


}
