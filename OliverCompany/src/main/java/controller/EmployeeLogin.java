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

import model.Employee;
import service.impl.EmployeeServiceImpl;
import util.Tool;

public class EmployeeLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private EmployeeServiceImpl esi=new EmployeeServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeLogin frame = new EmployeeLogin();
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
	public EmployeeLogin() {

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
		
		JLabel lblNewLabel = new JLabel("員工登入");
		lblNewLabel.setForeground(new Color(128, 0, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel.setBounds(62, 10, 304, 73);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("員工編號：");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(35, 77, 109, 46);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼：");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(72, 133, 72, 46);
		panel.add(lblNewLabel_1_1);
		
		JTextField employeeid = new JTextField();
		employeeid.setBounds(144, 77, 167, 46);
		panel.add(employeeid);
		employeeid.setColumns(10);
		employeeid.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		JTextField password = new JTextField();
		password.setColumns(10);
		password.setBounds(144, 133, 167, 46);
		panel.add(password);
		password.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		
		JButton button = new JButton("登入");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String eemployeeid=employeeid.getText();
				String ppassword=password.getText();
				Employee employee=esi.employeeLogin(eemployeeid,ppassword);
				
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				if(employeeid.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入員工編號");
				} else if(password.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入密碼");
				} else if(employee!=null){
					if(employee.getStatus().equals("離職")) {
					JOptionPane.showMessageDialog(null,"員工已離職,請重新輸入");
					} else {
						JOptionPane.showMessageDialog(null,"登入成功\n"+employee.getName()+" 歡迎光臨");
						Tool.saveEmployee(employee);
						if(employee.getPermission().equals("管理員")) {
							AdminMenu am=new AdminMenu();
							am.setVisible(true);
							dispose();
						} else if(employee.getPermission().equals("一般權限")) {
							StandarMenu sm=new StandarMenu();
							sm.setVisible(true);
							dispose();
						} else if(employee.getPermission().equals("會計權限")) {
							AccountantMenu acc=new AccountantMenu();
							acc.setVisible(true);
							dispose();
						} 
					} 
				} else {
					JOptionPane.showMessageDialog(null,"帳號或密碼錯誤\n請重新輸入");
				}
			}
		});
		button.setBounds(35, 199, 100, 40);
		panel.add(button);
		button.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		
		JButton button_2 = new JButton("密碼變更");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateEmployeePassword uep=new UpdateEmployeePassword();
				uep.setVisible(true);
				dispose();
			}
		});
		button_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		button_2.setBounds(170, 199, 100, 40);
		panel.add(button_2);
		
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
		button_1.setBounds(305, 199, 100, 40);
		panel.add(button_1);
		button_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));

	}
}
