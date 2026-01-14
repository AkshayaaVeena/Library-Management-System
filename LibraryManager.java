import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;

public class LibraryManager {
    public static void main(String args[]) {
        JPanel panel = new JPanel();
        final JFrame frame = new JFrame("Library Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        JLabel bookId = new JLabel("Enter BookId : ");
        final JTextField bookIdText = new JTextField("");
        panel.add(bookId);
        panel.add(bookIdText);

        JLabel title = new JLabel("Enter Title : ");
        final JTextField titleText = new JTextField("");
        panel.add(title);
        panel.add(titleText);

        JLabel author = new JLabel("Enter Author name : ");
        final JTextField authorText = new JTextField("");
        panel.add(author);
        panel.add(authorText);

        JLabel quantity = new JLabel("Enter Quantity : ");
        final JSpinner quantityText = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        panel.add(quantity);
        panel.add(quantityText);

        JButton btn = new JButton("Add Book");
        panel.add(new JLabel());
        panel.add(btn);

        String[] columnNames = { "Book ID", "Title", "Author", "Quantity" };
        final DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
        btn.addActionListener(e -> {
            try {
                String bookIdStr = bookIdText.getText().trim();
                String titleStr = titleText.getText().trim();
                String authorStr = authorText.getText().trim();
                int quantityVal = (Integer) quantityText.getValue();

                if (bookIdStr.isEmpty() || titleStr.isEmpty() || authorStr.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled!", "Validation Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                final int bookIdValue = Integer.parseInt(bookIdStr);

                try (Connection conn = DBConnection.getConnection();
                        PreparedStatement pst = conn.prepareStatement(
                                "INSERT INTO books (book_id, title, author, quantity) VALUES (?, ?, ?, ?)")) {
                    pst.setInt(1, bookIdValue);
                    pst.setString(2, titleStr);
                    pst.setString(3, authorStr);
                    pst.setInt(4, quantityVal);

                    pst.executeUpdate();
                    tableModel.addRow(new Object[] { bookIdValue, titleStr, authorStr, quantityVal });

                    bookIdText.setText("");
                    titleText.setText("");
                    authorText.setText("");
                    quantityText.setValue(1);

                    JOptionPane.showMessageDialog(frame, "Book added successfully!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid Book ID (must be a number)", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

    }
}