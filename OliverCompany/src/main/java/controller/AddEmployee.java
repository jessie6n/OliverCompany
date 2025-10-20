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
import dao.impl.EmployeeDaoImpl;
import model.Employee;
import service.impl.EmployeeServiceImpl;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;
	private JTextField address;
	private JTextField idnumber;
	private EmployeeServiceImpl esi=new EmployeeServiceImpl();
	private EmployeeDaoImpl edi=new EmployeeDaoImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
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
	public AddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 463);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel2 = new JLabel("員工資料新增");
		lblNewLabel2.setForeground(new Color(128, 0, 255));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel2.setBounds(143, 22, 149, 34);
		panel.add(lblNewLabel2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("姓名");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(73, 80, 87, 45);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("電話");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(73, 190, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("地址");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(73, 245, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("權限");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(73, 300, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		name = new JTextField();
		name.setBounds(160, 80, 141, 43);
		panel.add(name);
		name.setColumns(10);
		name.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(160, 190, 141, 43);
		panel.add(phone);
		phone.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(160, 245, 141, 43);
		panel.add(address);
		address.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		JComboBox permission = new JComboBox();
		permission.setModel(new DefaultComboBoxModel(new String[] {"請選擇", "管理員", "一般權限", "會計權限"}));
		permission.setBounds(160, 300, 141, 45);
		panel.add(permission);
		permission.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("身分證字號");
		lblNewLabel_1_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(47, 135, 113, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1_2);
		
		idnumber = new JTextField();
		idnumber.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		idnumber.setColumns(10);
		idnumber.setBounds(160, 135, 141, 43);
		panel.add(idnumber);
		
		JButton btnNewButton = new JButton("確認新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				Regex regex=new Regex();
				
				String eemployeeid=edi.addEmployeeid();
				String nname=name.getText();
				String iidnumber=idnumber.getText();
				String ppassword=eemployeeid;
				String pphone=phone.getText();
				String aaddress=address.getText();
				String ppermission=permission.getSelectedItem().toString();
				String sstatus = "在職";
			
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
				} else if (esi.addEmployee(emp)) {
					JOptionPane.showMessageDialog(null,"新增成功,員工編號為"+eemployeeid);
					AdminMenu am=new AdminMenu();
					am.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(71, 370, 141, 42);
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
		btnNewButton_2.setBounds(244, 370, 141, 42);
		panel.add(btnNewButton_2);
		
		
		
	}
}
