package libraryinformationsystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ButtonGroup;

public class SortForm extends JFrame {

    private JPanel contentPane;
    private JPanel booksPanel;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SortForm frame = new SortForm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SortForm() {
        Book bk[] = MainForm.getBarr();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 620, 530);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblSortForm = new JLabel("Show Sorted Information Of Books");
        lblSortForm.setBounds(112, 43, 408, 25);
        lblSortForm.setForeground(Color.YELLOW);
        lblSortForm.setFont(new Font("Tekton Pro Ext", Font.BOLD, 20));
        contentPane.add(lblSortForm);

        JRadioButton rdbtnISBN = new JRadioButton("Sort By ISBN");
        rdbtnISBN.setBounds(46, 89, 147, 23);
        rdbtnISBN.setBackground(Color.YELLOW);
        contentPane.add(rdbtnISBN);

        JRadioButton rdbtnPrice = new JRadioButton("Sort By Price");
        rdbtnPrice.setBounds(214, 89, 147, 23);
        rdbtnPrice.setBackground(Color.ORANGE);
        contentPane.add(rdbtnPrice);

        JRadioButton rdbtnAuthorName = new JRadioButton("Sort By Author Name");
        rdbtnAuthorName.setBounds(46, 149, 147, 23);
        rdbtnAuthorName.setBackground(Color.PINK);
        contentPane.add(rdbtnAuthorName);

        JRadioButton rdbtnBookTitle = new JRadioButton("Sort By Book Title");
        rdbtnBookTitle.setBounds(214, 149, 147, 23);
        rdbtnBookTitle.setBackground(Color.GREEN);
        contentPane.add(rdbtnBookTitle);

        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnISBN);
        group.add(rdbtnPrice);
        group.add(rdbtnAuthorName);
        group.add(rdbtnBookTitle);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 208, 586, 247);
        scrollPane.setVisible(false);
        contentPane.add(scrollPane);

        booksPanel = new JPanel();
        booksPanel.setLayout(null);
        booksPanel.setBackground(Color.DARK_GRAY);
        scrollPane.setViewportView(booksPanel);

        JButton btnSort = new JButton("Sort");
        btnSort.setBounds(446, 149, 89, 23);
        btnSort.setBackground(Color.RED);
        contentPane.add(btnSort);

        btnSort.addActionListener(e -> {
            scrollPane.setVisible(true);

            if (rdbtnISBN.isSelected()) SortByISBN(bk);
            else if (rdbtnPrice.isSelected()) SortByPrice(bk);
            else if (rdbtnAuthorName.isSelected()) SortByAuthorName(bk);
            else if (rdbtnBookTitle.isSelected()) SortByBookTitle(bk);

            showBooksAsButtons(bk);
        });

        JButton btnMainForm = new JButton("Go To Main Form");
        btnMainForm.setBackground(Color.WHITE);
        btnMainForm.setBounds(435, 459, 137, 23);
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

    private void SortByPrice(Book bk[]) {
        int n = bk.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 1; j < n - i; j++)
                if (bk[j - 1].getPrice() > bk[j].getPrice()) {
                    Book temp = bk[j - 1];
                    bk[j - 1] = bk[j];
                    bk[j] = temp;
                }
    }

    private void SortByAuthorName(Book bk[]) {
        int n = bk.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 1; j < n - i; j++)
                if (bk[j - 1].getAuthorName().compareTo(bk[j].getAuthorName()) > 0) {
                    Book temp = bk[j - 1];
                    bk[j - 1] = bk[j];
                    bk[j] = temp;
                }
    }

    private void SortByISBN(Book bk[]) {
        int n = bk.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 1; j < n - i; j++)
                if (bk[j - 1].getIsbn().compareTo(bk[j].getIsbn()) > 0) {
                    Book temp = bk[j - 1];
                    bk[j - 1] = bk[j];
                    bk[j] = temp;
                }
    }

    private void SortByBookTitle(Book bk[]) {
        int n = bk.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 1; j < n - i; j++)
                if (bk[j - 1].getBookTitle().compareTo(bk[j].getBookTitle()) > 0) {
                    Book temp = bk[j - 1];
                    bk[j - 1] = bk[j];
                    bk[j] = temp;
                }
    }
}
