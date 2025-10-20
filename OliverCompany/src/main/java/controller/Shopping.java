package controller;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Product;
import util.Tool;

import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.JTextArea;

public class Shopping extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Fruit fruit=new Fruit();
	Meat meat=new Meat();
	Seafood seafood=new Seafood();
	CheckOut checkout=new CheckOut();
	CartPanel cartpanel=new CartPanel(checkout);
	MyOorder myoorder=new MyOorder();
	Product pd=new Product();
	JLabel clock;
	CardLayout cardLayout;
	JPanel cardPanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shopping frame = new Shopping();
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
	public Shopping() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 731, 108);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Tool.readMember().getName()+"您好");
		lblNewLabel.setBounds(10, 10, 109, 36);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Oliver購物中心");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(128, 0, 255));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(213, 21, 253, 59);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("登出");
		btnNewButton_1_1_1_1.setBounds(604, 10, 109, 36);
		panel.add(btnNewButton_1_1_1_1);
		btnNewButton_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login=new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JButton btnNewButton_1_1_1_1_1_1 = new JButton("查看購物車");
		btnNewButton_1_1_1_1_1_1.setBounds(476, 10, 118, 36);
		panel.add(btnNewButton_1_1_1_1_1_1);
		btnNewButton_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel,"carttable");
			}
		});
		btnNewButton_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		clock = new JLabel();
		clock.setBounds(476, 62, 243, 36);
		panel.add(clock);
		clock.setFont(new Font("微軟正黑體", Font.PLAIN, 20));

		cardLayout=new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setBounds(123, 113, 600, 434);
		contentPane.add(cardPanel);
		cardPanel.setLayout(cardLayout);
		
		cardPanel.add(fruit,"fruit");
		cardPanel.add(meat,"meat");
		cardPanel.add(seafood,"seafood");
		cardPanel.add(cartpanel,"carttable");
		cardPanel.add(checkout,"checkout");
		
		/***************Event***************/
		
		/*****時鐘*****/
		Timer time=new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				clock.setText(time);
				checkout.setDate(clock.getText());
			}});
		time.start();
		
		
		JButton btn_fruit = new JButton("水果");
		btn_fruit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel,"fruit");
			}
		});
		btn_fruit.setBounds(10, 113, 103, 43);
		contentPane.add(btn_fruit);
		btn_fruit.setFont(new Font("微軟正黑體", Font.PLAIN, 16));

		JButton btn_meat = new JButton("肉類");
		btn_meat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel,"meat");
			}
		});
		btn_meat.setBounds(10, 166, 103, 43);
		contentPane.add(btn_meat);
		btn_meat.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JButton btn_seafood = new JButton("海鮮");
		btn_seafood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel,"seafood");
			}
		});
		btn_seafood.setBounds(10, 219, 103, 43);
		contentPane.add(btn_seafood);
		btn_seafood.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JButton btnNewButton_1_1_1_1_1_1_1 = new JButton("我的訂單");
		btnNewButton_1_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardPanel.add(myoorder,"myoorder");
				cardLayout.show(cardPanel,"myoorder");
			}
		});
		btnNewButton_1_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		btnNewButton_1_1_1_1_1_1_1.setBounds(129, 11, 102, 36);
		panel.add(btnNewButton_1_1_1_1_1_1_1);
	}
}
