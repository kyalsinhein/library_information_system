package libraryinformationsystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.ButtonGroup;

public class SearchForm extends JFrame {

    private JPanel contentPane;
    private JTextField txtSearch;
    private JPanel booksPanel;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SearchForm frame = new SearchForm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SearchForm() {
        Book bk[] = MainForm.getBarr();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 600);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JRadioButton rdbtnISBN = new JRadioButton("Search By ISBN");
        rdbtnISBN.setBounds(23, 91, 154, 23);
        rdbtnISBN.setBackground(Color.YELLOW);
        contentPane.add(rdbtnISBN);

        JRadioButton rdbtnBookTitle = new JRadioButton("Search By Book Title");
        rdbtnBookTitle.setBounds(23, 131, 154, 23);
        rdbtnBookTitle.setBackground(Color.ORANGE);
        contentPane.add(rdbtnBookTitle);

        JRadioButton rdbtnAuthorName = new JRadioButton("Search By Author Name");
        rdbtnAuthorName.setBounds(188, 91, 174, 23);
        rdbtnAuthorName.setBackground(Color.RED);
        contentPane.add(rdbtnAuthorName);

        JRadioButton rdbtnCategory = new JRadioButton("Search By Category");
        rdbtnCategory.setBounds(188, 131, 174, 23);
        rdbtnCategory.setBackground(Color.PINK);
        contentPane.add(rdbtnCategory);

        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnAuthorName);
        group.add(rdbtnBookTitle);
        group.add(rdbtnISBN);
        group.add(rdbtnCategory);

        JLabel lblSearch = new JLabel("Enter ISBN (OR) Author Name (OR) Book Title (OR) Category: ");
        lblSearch.setForeground(Color.YELLOW);
        lblSearch.setBounds(24, 174, 354, 23);
        contentPane.add(lblSearch);

        txtSearch = new JTextField();
        txtSearch.setBounds(388, 175, 149, 20);
        contentPane.add(txtSearch);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(57, 225, 566, 215);
        scrollPane.setVisible(false);
        contentPane.add(scrollPane);

        booksPanel = new JPanel();
        booksPanel.setLayout(null);
        booksPanel.setBackground(Color.DARK_GRAY);
        scrollPane.setViewportView(booksPanel);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(560, 174, 89, 23);
        btnSearch.setBackground(Color.YELLOW);
        contentPane.add(btnSearch);

        btnSearch.addActionListener(e -> {
            scrollPane.setVisible(true);
            Book[] results = new Book[0];

            if (rdbtnISBN.isSelected()) results = searchByISBN(bk, txtSearch.getText());
            else if (rdbtnAuthorName.isSelected()) results = searchByAuthorName(bk, txtSearch.getText());
            else if (rdbtnBookTitle.isSelected()) results = searchByBookTitle(bk, txtSearch.getText());
            else if (rdbtnCategory.isSelected()) results = searchByCategory(bk, txtSearch.getText());

            showBooksAsButtons(results);
        });

        JLabel lblSearchForm = new JLabel("Search Form");
        lblSearchForm.setForeground(Color.YELLOW);
        lblSearchForm.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 20));
        lblSearchForm.setBounds(287, 23, 174, 23);
        contentPane.add(lblSearchForm);

        JButton btnMainForm = new JButton("Go To Main Form");
        btnMainForm.setBackground(Color.WHITE);
        btnMainForm.setBounds(470, 484, 154, 23);
        btnMainForm.addActionListener(e -> {
            MainForm mf = new MainForm();
            mf.setVisible(true);
            dispose();
        });
        contentPane.add(btnMainForm);
    }

    private void showBooksAsButtons(Book[] bk) {
        booksPanel.removeAll();
        int x = 10, y = 10;
        int btnWidth = 150, btnHeight = 40, gap = 10;

        for (int i = 0; i < bk.length; i++) {
            JButton btnBook = new JButton(bk[i].getBookTitle());
            btnBook.setBounds(x, y, btnWidth, btnHeight);
            btnBook.setBackground(Color.YELLOW);

            int index = i;
            btnBook.addActionListener(e -> {
                Book b = bk[index];
                JOptionPane.showMessageDialog(null,
                        "Title: " + b.getBookTitle() +
                        "\nCategory: " + b.getCategory() +
                        "\nEdition: " + b.getEdition() +
                        "\nAuthor: " + b.getAuthorName() +
                        "\nPrice: $" + b.getPrice(),
                        "Book Details",
                        JOptionPane.INFORMATION_MESSAGE);
            });

            booksPanel.add(btnBook);
            x += btnWidth + gap;
            if (x + btnWidth > booksPanel.getWidth()) {
                x = 10;
                y += btnHeight + gap;
            }
        }
        booksPanel.revalidate();
        booksPanel.repaint();
    }

    private Book[] searchByISBN(Book[] bk, String isbn) {
        return java.util.Arrays.stream(bk).filter(b -> b.getIsbn().equalsIgnoreCase(isbn)).toArray(Book[]::new);
    }

    private Book[] searchByAuthorName(Book[] bk, String author) {
        return java.util.Arrays.stream(bk).filter(b -> b.getAuthorName().equalsIgnoreCase(author)).toArray(Book[]::new);
    }

    private Book[] searchByBookTitle(Book[] bk, String title) {
        return java.util.Arrays.stream(bk).filter(b -> b.getBookTitle().equalsIgnoreCase(title)).toArray(Book[]::new);
    }

    private Book[] searchByCategory(Book[] bk, String category) {
        return java.util.Arrays.stream(bk).filter(b -> b.getCategory().equalsIgnoreCase(category)).toArray(Book[]::new);
    }
}
