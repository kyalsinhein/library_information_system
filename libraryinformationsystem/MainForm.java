//This is the coding of library information system's main form

/*
 * This form is written by using JFrame. 
 * In this from user can go to search form and 
 * can go to sort form and can also view
 * books' information.
 */

package libraryinformationsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private JTable tblBook;
	private static Book barr[] = new Book[25];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainForm() {

		barr[0] = new Book("9781488077494", "The Lost Apothecary", 
				           "Novel", "First Edition", "Sarah Penner", 5.39);
		barr[1] = new Book("9780062943484", "The Rose Code", 
				           "Novel", "First Edition", "Kate Quinn", 11.49);
		barr[2] = new Book("9781488055447", "The Henna Artist", 
				           "Novel", "First Edition", "Alka Joshi", 10.49);
		barr[3] = new Book("9780062941527", "My Dark Vanessa", 
				           "Novel", "First Edition", "Kate Elizabeth Russell",17.29);
		barr[4] = new Book("9780062896896", "The Third Daughter", 
				           "Novel", "First Edition", "Talia Carner", 11.29);
		barr[5] = new Book("9781974728176", "Spy x Family, Vol. 5", 
				           "Manga", "Second Edition", "Tatsuya Endo", 5.39);
		barr[6] = new Book("9781974729210", "Jujutsu Kaisen, Vol. 11", 
				           "Manga", "Second Edition", "Gege Akutami", 5.39);
		barr[7] = new Book("9781975342227", "The Case Study of Vanitas Chapter 55", 
				           "Manga", "Second Edition","Jun Mochizuki", 3.93);
		barr[8] = new Book("9781974706150", "Demon Slayer: Kimetsu no Yaiba, Vol.2", 
				           "Manga", "Second Edition","Koyoharu Gotouge", 5.39);
		barr[9]  = new Book("9781974723096", "Chainsaw Man, Vol.1", 
				            "Manga", "Second Edition", "Tatsuki Fujimoto", 5.39);
		barr[10] = new Book("9780008354718", "The Lighthouse Witches", 
				            "Thriller", "Thrid Edition", "C.J. Cooke", 7.99);
		barr[11] = new Book("9781488073960", "Local Woman Missing", 
				            "Thriller", "Thrid Edition", "Nina Varela", 10.49);
		barr[12] = new Book("9781488076749", "The Wrong Family", 
				            "Thriller", "Thrid Edition", "Tarryn Fisher", 8.49);
		barr[13] = new Book("9781800194946", "The Marriage", 
				            "Thriller", "Third Edition", "K.L. Slatter", 3.99);
		barr[14] = new Book("9780062085511", "The Drowning Girls", 
				            "Thriller", "Third Edition", "Thereh Mafi", 4.99);
		barr[15] = new Book("9780062823960", "Shatter Me", 
				            "Science Fiction", "Fourth Edition", "Nina Varela", 2.99);
		barr[16] = new Book("9780998425962", "Crier's War", 
				            "Science Fiction", "Fourth Edition", "Amira K.Makansi",3.99);
		barr[17] = new Book("9781399602174", "The Paths Between The Stars: Book One of the Many Skies Series",
				            "Science Fiction", "Fourth Edition", "Bradon Sanderson," + "Janci Patterson", 0.99);
		barr[18] = new Book("9781473217966", "Sunreach", "Science Fiction", "Fourth Edition", "Bradon Sanderson",13.59);
		barr[19] = new Book("9781496732934", "Cytonic", 
				            "Science Fiction", "Fourth Edition", "Lisa Jakson", 20.49);
		barr[20] = new Book("9781119689010", "Networking All-in-One For Dummies (For Dummies (Computer/Tech))",
				            "Tecchnology Book", "Fifth Edition", "Doung Lowe", 33.45);
		barr[21] = new Book("9781451648539", "Steve Jobs: The Exclusive Biography", 
				            "Technology Book", "Fifth Edition","Walter Issacson", 1.55);
		barr[22] = new Book("9781781575703", "The Nostalgia Nerd's Retro Tech: Computer, Consoles and Games",
				            "Technology Book", "Fifth Edition", "Peter Leigh", 22.34);
		barr[23] = new Book("9781984825438",
				            "The Ultimate History of Video Games, Volume 2: Nintendo, Sony, Microsoft, "
						  + "and the Billion-Dollar Battle to Shape Modern Gaming",
				            "Technology Book", "Fifth Edition", "Steven L.Kent", 13.69);
		barr[24] = new Book("9798654241658","Cisco Networking Essentials:Complete Guide To Computer Networking For "
						  + "Beginners And Intermediates (Code tutorials)Cisco Networking Essentials:"
						  + " Complete Guide To Computer Networking For Beginners "
						  + "And Intermediates (Code tutorials)",
				            "Technology Book", "Fifth Edition", "Criag Berg", 12.85);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(63, 43, 757, 229);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 757, 229);
		panel.add(scrollPane);

		tblBook = new JTable();
		tblBook.getTableHeader().setBackground(new Color(255, 205, 0));
		tblBook.setBackground(Color.YELLOW);
		tblBook.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ISBN", "Book Title", "Category", "Edition", "Author Name", "Price" }));
		tblBook.getColumnModel().getColumn(0).setPreferredWidth(83);
		scrollPane.setViewportView(tblBook);

		DefaultTableModel model = (DefaultTableModel) tblBook.getModel();

		for (int i = 0; i < barr.length; i++) 
		{
			String isbn = barr[i].getIsbn();
			String bookTitle = barr[i].getBookTitle();
			String category = barr[i].getCategory();
			String edition = barr[i].getEdition();
			String authorName = barr[i].getAuthorName();
			double price = barr[i].getPrice();
			
			Object rowdata[] = new Object[] { isbn, bookTitle, category, edition, authorName, price };
			model.addRow(rowdata);

		} // end of for

		JLabel lblMainForm = new JLabel("Main Form");
		lblMainForm.setForeground(Color.YELLOW);
		lblMainForm.setBackground(Color.WHITE);
		lblMainForm.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 20));
		lblMainForm.setBounds(381, 11, 115, 35);
		contentPane.add(lblMainForm);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(176, 283, 529, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnSearchForm = new JButton("Go To Search Form");
		btnSearchForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchForm sf = new SearchForm();
				sf.setVisible(true);
				dispose();
			}
		});
		btnSearchForm.setBackground(new Color(255, 255, 0));
		btnSearchForm.setBounds(29, 11, 206, 39);
		panel_1.add(btnSearchForm);

		JButton btnSortForm = new JButton("Go To Sort Form");
		btnSortForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortForm sof = new SortForm();
				sof.setVisible(true);
				dispose();
			}
		});
		btnSortForm.setBackground(Color.RED);
		btnSortForm.setBounds(288, 11, 206, 39);
		panel_1.add(btnSortForm);

		btnSearchForm.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnSearchForm.setBackground(new Color(233, 233, 32));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnSearchForm.setBackground(new Color(255, 255, 0));
			}

		});

		btnSortForm.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnSortForm.setBackground(new Color(199, 29, 29));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnSortForm.setBackground(Color.RED);
			}

		});

	}

	public static Book[] getBarr() {
		return barr;
	}
}// end of class
