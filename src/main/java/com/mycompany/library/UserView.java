package com.mycompany.library;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserView {
    public static void main(String userID) {
        JFrame frame = new JFrame("User View");
        JTextField searchBox = new JTextField();
        JButton all = new JButton("All Books");
        JButton add = new JButton("Add Book");
        JButton available = new JButton("Available Books");
        JButton update = new JButton("Update Book");
        JButton issued = new JButton("Issued List");
        JButton issue = new JButton("Issue Book");
        JButton returnBook = new JButton("Return Book");
        JButton logout = new JButton("Log out");
        all.setBounds(25, 20, 120, 25);
        all.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame frame = new JFrame("Library");
                Connection connection = Main.connect();
                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("USE lib;");
                    ResultSet result = statement.executeQuery("SELECT * FROM books;");
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("ID");
                    model.addColumn("Title");
                    model.addColumn("Author");
                    model.addColumn("Genre");
                    model.addColumn("Published");
                    model.addColumn("Language");
                    model.addColumn("Pages");
                    model.addColumn("Quantity");
                    while (result.next()) {
                        model.addRow(new Object[] { result.getString(1), result.getString(2), result.getString(3),
                                result.getString(4), result.getString(5), result.getString(6), result.getString(7),
                                result.getString(8) });
                    }
                    JTable tb = new JTable(model);
                    JScrollPane sp = new JScrollPane(tb);
                    frame.add(sp);
                    frame.setSize(1200, 500);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });
        add.setBounds(25, 60, 120, 25);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame frame = new JFrame("Add Book Details");
                JLabel l1 = new JLabel("Title");
                JLabel l2 = new JLabel("Author");
                JLabel l3 = new JLabel("Genre");
                JLabel l4 = new JLabel("Language");
                JLabel l5 = new JLabel("Published");
                JLabel l6 = new JLabel("Pages");
                JLabel l7 = new JLabel("Quantity");
                JTextField t1 = new JTextField();
                JTextField t2 = new JTextField();
                JTextField t3 = new JTextField();
                JTextField t4 = new JTextField();
                JTextField t5 = new JTextField();
                JTextField t6 = new JTextField();
                JTextField t7 = new JTextField();
                JButton btn = new JButton("ADD");
                l1.setBounds(30, 20, 70, 25);
                l2.setBounds(30, 60, 70, 25);
                l3.setBounds(30, 100, 70, 25);
                l4.setBounds(30, 140, 70, 25);
                l5.setBounds(30, 180, 70, 25);
                l6.setBounds(30, 220, 70, 25);
                l7.setBounds(30, 260, 70, 25);
                t1.setBounds(100, 20, 200, 25);
                t2.setBounds(100, 60, 200, 25);
                t3.setBounds(100, 100, 200, 25);
                t4.setBounds(100, 140, 200, 25);
                t5.setBounds(100, 180, 200, 25);
                t6.setBounds(100, 220, 200, 25);
                t7.setBounds(100, 260, 200, 25);
                btn.setBounds(130, 305, 80, 25);
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        String title = t1.getText();
                        String author = t2.getText();
                        String genre = t3.getText();
                        String language = t4.getText();
                        String published = t5.getText();
                        String pages = t6.getText();
                        String quantity = t7.getText();
                        Connection connection = Main.connect();
                        try {
                            Statement statement = connection.createStatement();
                            statement.executeUpdate("USE lib;");
                            statement.executeUpdate(
                                    "INSERT INTO books(title, author, genre, language, published, pages, quantity) VALUES('"
                                            + title + "','" + author + "','" + genre + "','" + language + "','"
                                            + published + "'," + pages + "," + quantity + ")");
                            JOptionPane.showMessageDialog(null, "Book added!");
                            System.out.println("Added new book!");
                            frame.dispose();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                });
                frame.add(l1);
                frame.add(l2);
                frame.add(l3);
                frame.add(l4);
                frame.add(l5);
                frame.add(l6);
                frame.add(l7);
                frame.add(t1);
                frame.add(t2);
                frame.add(t3);
                frame.add(t4);
                frame.add(t5);
                frame.add(t6);
                frame.add(t7);
                frame.add(btn);
                frame.setSize(350, 385);
                frame.setLayout(null);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
        available.setBounds(285, 20, 140, 25);
        update.setBounds(435, 20, 120, 25);
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame frame = new JFrame("Enter details");
                JLabel l1 = new JLabel("Book ID");
                JLabel l2 = new JLabel("Book Title");
                JLabel l3 = new JLabel("Book Quantity");
                JTextField t1 = new JTextField();
                JTextField t2 = new JTextField();
                JTextField t3 = new JTextField();
                JButton more = new JButton("More");
                JButton submit = new JButton("Submit");
                l1.setBounds(30, 20, 100, 25);
                l2.setBounds(30, 60, 100, 25);
                l3.setBounds(30, 100, 100, 25);
                t1.setBounds(130, 20, 120, 25);
                t2.setBounds(130, 60, 120, 25);
                t3.setBounds(130, 100, 120, 25);
                more.setBounds(50, 150, 80, 25);
                submit.setBounds(150, 150, 80, 25);
                more.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        JFrame frame = new JFrame("Update more information");
                        JLabel l1 = new JLabel("Book Title");
                        JLabel l2 = new JLabel("Author");
                        JLabel l3 = new JLabel("Genre");
                        JLabel l4 = new JLabel("Pulished");
                        JLabel l5 = new JLabel("Language");
                        JLabel l6 = new JLabel("Total Pages");
                        JLabel l7 = new JLabel("Quantity");
                        JLabel l8 = new JLabel("Book ID");
                        JTextField t1 = new JTextField();
                        JTextField t2 = new JTextField();
                        JTextField t3 = new JTextField();
                        JTextField t4 = new JTextField();
                        JTextField t5 = new JTextField();
                        JTextField t6 = new JTextField();
                        JTextField t7 = new JTextField();
                        JTextField t8 = new JTextField();
                        JButton submit = new JButton("Submit");
                        l1.setBounds(30, 20, 100, 25);
                        l2.setBounds(30, 60, 100, 25);
                        l3.setBounds(30, 100, 100, 25);
                        l4.setBounds(30, 140, 100, 25);
                        l5.setBounds(30, 180, 100, 25);
                        l6.setBounds(30, 220, 100, 25);
                        l7.setBounds(30, 260, 100, 25);
                        l8.setBounds(30, 300, 100, 25);
                        t1.setBounds(130, 20, 150, 25);
                        t2.setBounds(130, 60, 150, 25);
                        t3.setBounds(130, 100, 150, 25);
                        t4.setBounds(130, 140, 150, 25);
                        t5.setBounds(130, 180, 150, 25);
                        t6.setBounds(130, 220, 150, 25);
                        t7.setBounds(130, 260, 150, 25);
                        t8.setBounds(130, 300, 150, 25);
                        submit.setBounds(120, 350, 80, 25);
                        submit.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                String s1 = t1.getText();
                                String s2 = t2.getText();
                                String s3 = t3.getText();
                                String s4 = t4.getText();
                                String s5 = t5.getText();
                                String s6 = t6.getText();
                                String s7 = t7.getText();
                                String id = t8.getText();
                                String query = "UPDATE books SET title = '" + s1 + "', author = '" + s2 + "', genre = '"
                                        + s3 + "', published = '" + s4 + "', language = '" + s5 + "', pages = " + s6
                                        + ", quantity = " + s7 + " WHERE id = " + id + " ;";
                                Connection connection = Main.connect();
                                try {
                                    Statement statement = connection.createStatement();
                                    statement.executeUpdate("USE lib;");
                                    statement.executeUpdate(query);
                                    JOptionPane.showMessageDialog(null, "Book updated!");
                                    System.out.println("Updated book!");
                                    frame.dispose();
                                } catch (SQLException e) {
                                    JOptionPane.showMessageDialog(null, e);
                                }
                            }
                        });
                        frame.add(l1);
                        frame.add(l2);
                        frame.add(l3);
                        frame.add(l4);
                        frame.add(l5);
                        frame.add(l6);
                        frame.add(l7);
                        frame.add(l8);
                        frame.add(t1);
                        frame.add(t2);
                        frame.add(t3);
                        frame.add(t4);
                        frame.add(t5);
                        frame.add(t6);
                        frame.add(t7);
                        frame.add(t8);
                        frame.add(submit);
                        frame.setSize(330, 430);
                        frame.setLayout(null);
                        frame.setVisible(true);
                        frame.setLocationRelativeTo(null);

                    }
                });
                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        String s1 = t1.getText();
                        String s2 = t2.getText();
                        String s3 = t3.getText();
                        String query = "UPDATE books SET title = '" + s2 + "', quantity = " + s3 + " WHERE id = " + s1
                                + ";";
                        Connection connection = Main.connect();
                        try {
                            Statement st = connection.createStatement();
                            st.executeUpdate("USE lib;");
                            st.executeUpdate(query);
                            JOptionPane.showMessageDialog(null, "Update successfully!");
                            frame.dispose();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                });
                frame.dispose();
                frame.add(l1);
                frame.add(l2);
                frame.add(l3);
                frame.add(t1);
                frame.add(t2);
                frame.add(t3);
                frame.add(more);
                frame.add(submit);
                frame.setSize(300, 230);
                frame.setLayout(null);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
        issue.setBounds(155, 60, 120, 25);
        issue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame frame = new JFrame("Issue a book");
                JLabel l1 = new JLabel("Student Name");
                JLabel l2 = new JLabel("Student ID");
                JLabel l3 = new JLabel("Book ID");
                JLabel l4 = new JLabel("Date");
                JLabel l5 = new JLabel("Period");
                JTextField t1 = new JTextField();
                JTextField t2 = new JTextField();
                JTextField t3 = new JTextField();
                JTextField t4 = new JTextField();
                JTextField t5 = new JTextField();
                JButton button = new JButton("ISSUE");
                l1.setBounds(30, 30, 100, 25);
                l2.setBounds(30, 70, 100, 25);
                l3.setBounds(30, 110, 100, 25);
                l4.setBounds(30, 150, 100, 25);
                l5.setBounds(30, 190, 100, 25);
                t1.setBounds(130, 30, 200, 25);
                t2.setBounds(130, 70, 200, 25);
                t3.setBounds(130, 110, 200, 25);
                t4.setBounds(130, 150, 200, 25);
                t5.setBounds(130, 190, 200, 25);
                button.setBounds(150, 235, 80, 25);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        String s1 = t1.getText();
                        String s2 = t2.getText();
                        String s3 = t3.getText();
                        String s4 = t4.getText();
                        String s5 = t5.getText();
                        Connection connection = Main.connect();
                        String query = "INSERT INTO issued(studentName, studentID, bookID, issuedDate, period) VALUES('"
                                + s1 + "'," + s2 + "," + s3 + ",'" + s4 + "'," + s5 + ");";
                        try {
                            Statement statement = connection.createStatement();
                            statement.executeUpdate("USE lib;");
                            statement.executeUpdate(query);
                            JOptionPane.showMessageDialog(null, "Book is issued!");
                            System.out.println("issued");
                            frame.dispose();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                });
                frame.add(l1);
                frame.add(l2);
                frame.add(l3);
                frame.add(l4);
                frame.add(l5);
                frame.add(t1);
                frame.add(t2);
                frame.add(t3);
                frame.add(t4);
                frame.add(t5);
                frame.add(button);
                frame.setSize(380, 330);
                frame.setLayout(null);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
        issued.setBounds(155, 20, 120, 25);
        returnBook.setBounds(285, 60, 140, 25);
        logout.setBounds(435, 60, 120, 25);
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frame.dispose();
                Main.login();
            }
        });
        frame.dispose();
        frame.add(searchBox);
        frame.add(add);
        frame.add(all);
        frame.add(available);
        frame.add(issued);
        frame.add(update);
        frame.add(issue);
        frame.add(returnBook);
        frame.add(logout);
        frame.setSize(600, 150);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
