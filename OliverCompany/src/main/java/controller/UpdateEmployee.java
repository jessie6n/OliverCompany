package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import config.Regex;
import model.Employee;
import service.impl.EmployeeServiceImpl;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;
	private JTextField address;
	private JTextField idnumber;
	private EmployeeServiceImpl esi=new EmployeeServiceImpl();
	private JTextField employeeid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployee frame = new UpdateEmployee();
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
	public UpdateEmployee() {
		setBounds(100, 100, 450, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 613);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel2 = new JLabel("員工資料修改");
		lblNewLabel2.setForeground(new Color(128, 0, 255));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel2.setBounds(143, 22, 149, 34);
		panel.add(lblNewLabel2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("姓名");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(72, 176, 87, 45);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("電話");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(72, 286, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("地址");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(72, 341, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("權限");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(72, 396, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		employeeid = new JTextField();
		employeeid.setBounds(159, 67, 141, 43);
		panel.add(employeeid);
		employeeid.setColumns(10);
		employeeid.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(159, 176, 141, 43);
		panel.add(name);
		name.setColumns(10);
		name.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		phone = new JTextField();
		phone.setEditable(false);
		phone.setColumns(10);
		phone.setBounds(159, 286, 141, 43);
		panel.add(phone);
		phone.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		address = new JTextField();
		address.setEditable(false);
		address.setColumns(10);
		address.setBounds(159, 341, 141, 43);
		panel.add(address);
		address.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		JComboBox permission = new JComboBox();
		permission.setEnabled(false);
		permission.setModel(new DefaultComboBoxModel(new String[] {"請選擇", "管理員", "一般權限", "會計權限"}));
		permission.setBounds(159, 396, 141, 45);
		panel.add(permission);
		permission.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("身分證字號");
		lblNewLabel_1_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(47, 231, 113, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1_2);
		
		idnumber = new JTextField();
		idnumber.setEditable(false);
		idnumber.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		idnumber.setColumns(10);
		idnumber.setBounds(160, 231, 141, 43);
		panel.add(idnumber);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("員工編號");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(35, 66, 124, 45);
		panel.add(lblNewLabel_1_1_1_1);
		
		JComboBox status = new JComboBox();
		status.setEnabled(false);
		status.setModel(new DefaultComboBoxModel(new String[] {"請選擇", "在職", "離職"}));
		status.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		status.setBounds(159, 453, 141, 45);
		panel.add(status);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("狀態");
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(72, 453, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Employee em=esi.selectByEmployeeid(employeeid.getText());
				
				if(employeeid.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入員工編號");
				} else if (em==null) {
					JOptionPane.showMessageDialog(null,"請輸入正確員工編號");
				} else {
					name.setText(em.getName());
					name.setEditable(true);
					idnumber.setText(em.getIdnumber());
					idnumber.setEditable(true);
					phone.setText(em.getPhone());
					phone.setEditable(true);
					address.setText(em.getAddress());
					address.setEditable(true);
					permission.setSelectedItem(em.getPermission());
					permission.setEnabled(true);
					status.setSelectedItem(em.getStatus());
					status.setEnabled(true);
				}
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnNewButton_1.setBounds(310, 66, 79, 42);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("密碼重置");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Employee em=esi.selectByEmployeeid(employeeid.getText());
			
				
				if(employeeid.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入員工編號");
				} else if (em==null) {
					JOptionPane.showMessageDialog(null,"請輸入正確員工編號");
				} else {
					int result= JOptionPane.showConfirmDialog(
							null,
							"是否重置"+employeeid.getText()+"密碼",
							"訊息",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (result==JOptionPane.YES_OPTION) {
						esi.resetPassword(em.getEmployeeid());
						JOptionPane.showMessageDialog(null,"已重置密碼");
					}
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(159, 119, 141, 42);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton = new JButton("確認修改");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				Regex regex=new Regex();
				
				String eemployeeid=esi.selectByEmployeeid(employeeid.getText()).getEmployeeid();
				String nname=name.getText();
				String iidnumber=idnumber.getText();
				String ppassword=esi.selectByEmployeeid(employeeid.getText()).getPassword();
				String pphone=phone.getText();
				String aaddress=address.getText();
				String ppermission=permission.getSelectedItem().toString();
				String sstatus = status.getSelectedItem().toString();
			
				Employee emp=new Employee(eemployeeid,nname,iidnumber,ppassword,pphone,aaddress,ppermission,sstatus);
				
				if(name.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入姓名");
				} else if(idnumber.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入身分證字號");
				} else if(!idnumber.getText().matches(regex.idNumberRegex())) {
					JOptionPane.showMessageDialog(null,"身分證字號格式請輸入正確");
				} else if(phone.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入電話");
				} else if(!phone.getText().matches(regex.phoneRegex())) {
					JOptionPane.showMessageDialog(null,"電話格式請輸入正確");
				} else if(address.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入地址");
				} else if(permission.getSelectedItem().toString().equals("請選擇")) {
					JOptionPane.showMessageDialog(null,"請選擇權限");
				} else if (esi.updateEmployee(emp)) {
					JOptionPane.showMessageDialog(null,"修改完成");
					AdminMenu am=new AdminMenu();
					am.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(72, 519, 141, 42);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JButton btnNewButton_2 = new JButton("返回選單");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMenu am=new AdminMenu();
				am.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnNewButton_2.setBounds(245, 519, 141, 42);
		panel.add(btnNewButton_2);
		
	}
}
