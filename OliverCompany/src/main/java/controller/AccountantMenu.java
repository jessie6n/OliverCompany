package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import util.Tool;

public class AccountantMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountantMenu frame = new AccountantMenu();
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
	public AccountantMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Tool.readEmployee().getName()+"您好");
		lblNewLabel.setBounds(10, 10, 173, 42);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel2 = new JLabel("財會人員選單");
		lblNewLabel2.setForeground(new Color(128, 0, 255));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel2.setBounds(62, 10, 304, 73);
		panel.add(lblNewLabel2);
		
		JLabel lblNewLabel_1 = new JLabel("系統建置中");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(129, 113, 174, 49);
		panel.add(lblNewLabel_1);

	}
}
