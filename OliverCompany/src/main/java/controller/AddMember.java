package controller;

import com.toedter.calendar.JCalendar;

import config.Regex;
import dao.impl.MemberDaoImpl;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;

public class AddMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField username;
	private JTextField password;
	private JTextField name;
	private JTextField phone;
	private JTextField birthday;
	private JTextField address;
	private JButton checkBtn;
	private JButton cancelBtn;
	private MemberServiceImpl msi=new MemberServiceImpl();
	private JRadioButton female;
	private JButton checkBtn_1;
	private Regex regex=new Regex();
	private JTextField check_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMember frame = new AddMember();
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
	public AddMember() {
		setBounds(120, 120, 450, 620);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員註冊");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		lblNewLabel.setBounds(110, 10, 211, 45);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(34, 65, 87, 45);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(34, 120, 87, 45);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("姓名");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(34, 230, 87, 45);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("電話");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(34, 285, 87, 45);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("性別");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(34, 340, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("生日");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(34, 395, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("地址");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(34, 450, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		username = new JTextField();
		username.setBounds(131, 65, 192, 45);
		panel.add(username);
		username.setColumns(10);
		username.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(131, 120, 192, 45);
		panel.add(password);
		password.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(131, 230, 192, 45);
		panel.add(name);
		name.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(131, 285, 192, 45);
		panel.add(phone);
		phone.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		
		birthday=new JTextField();
		birthday.setEditable(false);
		birthday.setColumns(10);
		birthday.setBounds(131, 395, 192, 45);
		panel.add(birthday);
		birthday.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		
        JFrame frame = new JFrame("JCalendar");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

		JCalendar calendar=new JCalendar();

        calendar.getDayChooser().addPropertyChangeListener("day", evt -> {
        		Date selectedDate = calendar.getDate();
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        		birthday.setText(sdf.format(selectedDate));
        });
        frame.getContentPane().setLayout(null);
        calendar.setBounds(50, 50, 300, 200);
        frame.getContentPane().add(calendar);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(131, 450, 192, 45);
		panel.add(address);
		address.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		
		JRadioButton male = new JRadioButton("男");
		male.setBounds(131, 340, 59, 45);
		panel.add(male);
		male.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		female = new JRadioButton("女");
		female.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		female.setBounds(215, 340, 59, 45);
		panel.add(female);
		
		ButtonGroup group=new ButtonGroup();
		group.add(male);
		group.add(female);
		
		JLabel check_password_btn = new JLabel("密碼確認");
		check_password_btn.setHorizontalAlignment(SwingConstants.CENTER);
		check_password_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		check_password_btn.setBounds(10, 175, 109, 45);
		panel.add(check_password_btn);
		
		check_password = new JTextField();
		check_password.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		check_password.setColumns(10);
		check_password.setBounds(129, 175, 192, 45);
		panel.add(check_password);

		
/**************event**************/
		
		checkBtn = new JButton("確認註冊");
		checkBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));

				Member member=new Member();
				member.setUsername(username.getText());
				member.setPassword(password.getText());
				member.setName(name.getText());
				member.setPhone(phone.getText());
				
				if(male.isSelected()){
					member.setSex("男");
				} else if(female.isSelected()){
					member.setSex("女");
				} else member.setSex(null);
				
				if(birthday.getText().isBlank()) {
					member.setBirthday(null);
				} else {				
					member.setBirthday(birthday.getText());
				}
				
				if(address.getText().isBlank()) {
					member.setAddress(null);
				} else {
					member.setAddress(address.getText());
				}
				
				if (msi.addMember(member)) {
					JOptionPane.showMessageDialog(null,"帳號重複\n請重新輸入");
				}else if(username.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入帳號");
				} else if(password.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入密碼");
				} else if(check_password.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入確認密碼");
				} else if(name.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入姓名");
				} else if(phone.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入電話");
				} else if(!phone.getText().matches(regex.phoneRegex())) {
					JOptionPane.showMessageDialog(null,"請正確輸入手機號碼");
				} else if(!password.getText().equals(check_password.getText())) {
					JOptionPane.showMessageDialog(null,"確認密碼不相符");
				} else {
					JOptionPane.showMessageDialog(null,"註冊成功!\n返回登入頁面");
					new MemberDaoImpl().insert(member);
					Login login=new Login();
					login.setVisible(true);
					dispose();
				}
			}
		});
		checkBtn.setVerticalAlignment(SwingConstants.TOP);
		checkBtn.setBounds(55, 513, 124, 39);
		panel.add(checkBtn);
		checkBtn.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		cancelBtn = new JButton("取消註冊");
		cancelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		cancelBtn.setVerticalAlignment(SwingConstants.TOP);
		cancelBtn.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		cancelBtn.setBounds(265, 513, 124, 39);
		panel.add(cancelBtn);
		
		checkBtn_1 = new JButton("日期");
		checkBtn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        frame.setVisible(true);
			}
		});
		checkBtn_1.setVerticalAlignment(SwingConstants.TOP);
		checkBtn_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		checkBtn_1.setBounds(328, 399, 73, 39);
		panel.add(checkBtn_1);
		
	
	}
}
