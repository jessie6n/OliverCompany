package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Employee;
import service.impl.EmployeeServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateEmployeePassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private EmployeeServiceImpl esi=new EmployeeServiceImpl();
	private JPanel contentPane;
	private JTextField employeeid;
	private JLabel name;
	private JTextField original_password;
	private JLabel lblNewLabel_1_1_2;
	private JTextField new_password;
	private JLabel lblNewLabel_1_1_3;
	private JTextField check_password;
	private JLabel lblNewLabel_1_1_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployeePassword frame = new UpdateEmployeePassword();
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
	public UpdateEmployeePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel2 = new JLabel("員工密碼變更");
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setForeground(new Color(128, 0, 255));
		lblNewLabel2.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel2.setBounds(148, 10, 149, 34);
		contentPane.add(lblNewLabel2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("員工編號");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(41, 54, 111, 45);
		contentPane.add(lblNewLabel_1_1_1);
		
		employeeid = new JTextField();
		employeeid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Employee em=esi.selectByEmployeeid(employeeid.getText());
				
				if(employeeid.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入員工編號");
				} else if (em==null) {
					JOptionPane.showMessageDialog(null,"請輸入正確員工編號");
				} else {
					name.setText(em.getName());
				}
			}
		});
		employeeid.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		employeeid.setColumns(10);
		employeeid.setBounds(152, 54, 141, 43);
		contentPane.add(employeeid);
		
		name = new JLabel();
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		name.setBounds(305, 54, 100, 45);
		contentPane.add(name);
		
		original_password = new JTextField();
		original_password.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		original_password.setColumns(10);
		original_password.setBounds(152, 109, 141, 43);
		contentPane.add(original_password);
		
		lblNewLabel_1_1_2 = new JLabel("舊密碼");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(65, 109, 87, 45);
		contentPane.add(lblNewLabel_1_1_2);
		
		new_password = new JTextField();
		new_password.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		new_password.setColumns(10);
		new_password.setBounds(152, 162, 141, 43);
		contentPane.add(new_password);
		
		lblNewLabel_1_1_3 = new JLabel("新密碼");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_3.setBounds(65, 162, 87, 45);
		contentPane.add(lblNewLabel_1_1_3);
		
		check_password = new JTextField();
		check_password.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		check_password.setColumns(10);
		check_password.setBounds(152, 215, 141, 43);
		contentPane.add(check_password);
		
		lblNewLabel_1_1_4 = new JLabel("確認密碼");
		lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_4.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_4.setBounds(41, 215, 111, 45);
		contentPane.add(lblNewLabel_1_1_4);
		
		JButton btnNewButton = new JButton("確認變更");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String eemployeeid=employeeid.getText();
				String ppassword=original_password.getText();
				Employee employee=esi.employeeLogin(eemployeeid,ppassword);
				
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				if(employeeid.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入員工編號");
				} else if(original_password.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入舊密碼");
				} else if(new_password.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入新密碼");
				} else if(check_password.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入確認新密碼");
				} else if(employee==null) {
					JOptionPane.showMessageDialog(null,"舊密碼錯誤");
				} else if(!new_password.getText().equals(check_password.getText())) {
					JOptionPane.showMessageDialog(null,"新密碼與確認密碼不相符");
				} else {
					esi.updatePassword(employee.getEmployeeid(),new_password.getText());
					JOptionPane.showMessageDialog(null,"密碼變更成功,請重新登入");
					EmployeeLogin el=new EmployeeLogin();
					el.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnNewButton.setBounds(152, 278, 141, 42);
		contentPane.add(btnNewButton);

		

	}
}
