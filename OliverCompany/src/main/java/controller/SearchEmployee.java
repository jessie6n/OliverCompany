package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Employee;
import service.impl.EmployeeServiceImpl;

public class SearchEmployee extends JFrame {

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
					SearchEmployee frame = new SearchEmployee();
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
	public SearchEmployee() {
		setBounds(100, 100, 450, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 540);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel2 = new JLabel("員工資料查詢");
		lblNewLabel2.setForeground(new Color(128, 0, 255));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel2.setBounds(143, 22, 149, 34);
		panel.add(lblNewLabel2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("姓名");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(71, 120, 87, 45);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("電話");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(71, 230, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("地址");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(71, 285, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("權限");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(71, 340, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		employeeid = new JTextField();
		employeeid.setBounds(159, 67, 141, 43);
		panel.add(employeeid);
		employeeid.setColumns(10);
		employeeid.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		name = new JTextField();
		name.setBounds(158, 120, 141, 43);
		panel.add(name);
		name.setColumns(10);
		name.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(158, 230, 141, 43);
		panel.add(phone);
		phone.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(158, 285, 141, 43);
		panel.add(address);
		address.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		JComboBox permission = new JComboBox();
		permission.setModel(new DefaultComboBoxModel(new String[] {"請選擇", "管理員", "一般權限", "會計權限"}));
		permission.setBounds(158, 340, 141, 45);
		panel.add(permission);
		permission.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("身分證字號");
		lblNewLabel_1_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(46, 175, 113, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1_2);
		
		idnumber = new JTextField();
		idnumber.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		idnumber.setColumns(10);
		idnumber.setBounds(159, 175, 141, 43);
		panel.add(idnumber);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("員工編號");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(35, 66, 124, 45);
		panel.add(lblNewLabel_1_1_1_1);
		
		JComboBox status = new JComboBox();
		status.setModel(new DefaultComboBoxModel(new String[] {"請選擇", "在職", "離職"}));
		status.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		status.setBounds(158, 397, 141, 45);
		panel.add(status);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("狀態");
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(71, 397, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				try {
				String eemployeeid=employeeid.getText();
				String nname=name.getText();
				String iidnumber=idnumber.getText();
				String pphone=phone.getText();
				String aaddress=address.getText();
				String ppermission = null;
				String sstatus = null;
			
				if(!permission.getSelectedItem().toString().equals("請選擇")) {
					ppermission=permission.getSelectedItem().toString();
				} else if(!status.getSelectedItem().toString().equals("請選擇")) {
					sstatus = status.getSelectedItem().toString();
				}
				
				List<Employee> list = esi.selectByInput(eemployeeid, nname, iidnumber, pphone, aaddress, ppermission, sstatus);
				
				String[] columnNames = {"員工編號","姓名","身份證字號","電話","地址","權限","狀態"};
				
				DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
					public boolean isCellEditable(int row, int colunmn) {
					return false;
					}
				};
			        
			    model.fireTableDataChanged();
			        
			    JTable table = new JTable(model);
			    JScrollPane scrollPane = new JScrollPane(table);
			    table.setFont(new Font("微軟正黑體", Font.PLAIN, 14));

			    // 新增幾筆資料
			    for (Employee em : list) {
			        model.addRow(new Object[]{em.getEmployeeid(), 
			        em.getName(), em.getIdnumber(), em.getPhone(), em.getAddress(), em.getPermission(), em.getStatus()});
			    }
			    
			    if (list.isEmpty()) {
			    		JOptionPane.showMessageDialog(null,"查無資料");
			    } else {
				    JFrame frame = new JFrame("查詢結果");
				    frame.getContentPane().add(scrollPane);
				    frame.setSize(1250, 800);
				    frame.setVisible(true);
			    }

				
				//AdminMenu am=new AdminMenu();
				//am.setVisible(true);
				//dispose();
				} catch (NullPointerException ne) {
					JOptionPane.showMessageDialog(null,"查無資料");
				}
				
			}
		});
		btnNewButton.setBounds(71, 464, 141, 42);
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
		btnNewButton_2.setBounds(244, 464, 141, 42);
		panel.add(btnNewButton_2);
		
	}

}
