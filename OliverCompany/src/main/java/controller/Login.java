package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MemberServiceImpl msi=new MemberServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 80, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Oliver購物系統");
		lblNewLabel.setForeground(new Color(128, 0, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel.setBounds(62, 10, 304, 73);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號：");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(72, 77, 72, 46);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼：");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(72, 133, 72, 46);
		panel.add(lblNewLabel_1_1);
		
		JTextField username = new JTextField();
		username.setBounds(144, 77, 167, 46);
		panel.add(username);
		username.setColumns(10);
		username.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		JTextField password = new JTextField();
		password.setColumns(10);
		password.setBounds(144, 133, 167, 46);
		panel.add(password);
		password.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
/**************event**************/
		
		JButton button = new JButton("登入");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Member member=msi.login(username.getText(), password.getText());
				
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				if(username.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入帳號");
				} else if(password.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入密碼");
				} else if(member!=null){
					JOptionPane.showMessageDialog(null,"登入成功\n"+member.getName()+" 歡迎光臨");
					Tool.saveMember(member);
					Shopping shopping=new Shopping();
					shopping.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null,"帳號或密碼錯誤\n請重新輸入");
				}

			}
		});
		button.setBounds(5, 199, 100, 40);
		panel.add(button);
		button.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JButton button_1_1_1 = new JButton("註冊會員");
		button_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMember addmember=new AddMember();
				addmember.setVisible(true);
				dispose();
			}
		});
		button_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		button_1_1_1.setBounds(113, 199, 100, 40);
		panel.add(button_1_1_1);
		
		JButton button_1_1 = new JButton("清除");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				username.setText("");
				password.setText("");
				
			}
		});
		button_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		button_1_1.setBounds(221, 199, 100, 40);
		panel.add(button_1_1);
		
		JButton button_1 = new JButton("離開");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		button_1.setBounds(329, 199, 100, 40);
		panel.add(button_1);
		button_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));

	}


}
