package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import util.Tool;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdminMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
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
	public AdminMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Tool.readEmployee().getName()+"您好");
		lblNewLabel.setBounds(10, 10, 173, 42);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 584);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel2 = new JLabel("管理員選單");
		lblNewLabel2.setForeground(new Color(128, 0, 255));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel2.setBounds(81, 10, 262, 73);
		panel.add(lblNewLabel2);
		
		JComboBox em_comboBox = new JComboBox();
		em_comboBox.setToolTipText("員工");
		em_comboBox.setModel(new DefaultComboBoxModel(new String[] {"員工資料新增", "員工資料查詢", "員工資料修改"}));
		em_comboBox.setEditable(true);
		em_comboBox.setBounds(81, 76, 204, 53);
		panel.add(em_comboBox);
		em_comboBox.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JButton em_button = new JButton("確認");
		em_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String em_selected=em_comboBox.getSelectedItem().toString();
				
				if(em_selected.equals("員工資料新增")) {
					AddEmployee am=new AddEmployee();
					am.setVisible(true);
					dispose();	
				}
				
				if(em_selected.equals("員工資料查詢")) {
					SearchEmployee ue=new SearchEmployee();
					ue.setVisible(true);
					dispose();	
				}
				
				if(em_selected.equals("員工資料修改")) {
					UpdateEmployee ue=new UpdateEmployee();
					ue.setVisible(true);
					dispose();	
				}
				
			}
		});
		em_button.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		em_button.setBounds(300, 76, 77, 53);
		panel.add(em_button);
		
		JComboBox mem_comboBox = new JComboBox();
		mem_comboBox.setModel(new DefaultComboBoxModel(new String[] {"會員資料查詢", "會員資料刪除"}));
		mem_comboBox.setToolTipText("員工");
		mem_comboBox.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		mem_comboBox.setEditable(true);
		mem_comboBox.setBounds(81, 139, 204, 53);
		panel.add(mem_comboBox);
		
		JButton em_button_1 = new JButton("確認");
		em_button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mem_selected=mem_comboBox.getSelectedItem().toString();
				
				if(mem_selected.equals("會員資料查詢")) {
					SearchMember sm=new SearchMember();
					sm.setVisible(true);
					dispose();;	
				}
				
				if(mem_selected.equals("會員資料刪除")) {
					DeleteMember dm=new DeleteMember();
					dm.setVisible(true);
					dispose();	
				}
				
			}
		});
		em_button_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		em_button_1.setBounds(300, 139, 77, 53);
		panel.add(em_button_1);
		
		JComboBox order_comboBox = new JComboBox();
		order_comboBox.setModel(new DefaultComboBoxModel(new String[] {"訂單資料查詢"}));
		order_comboBox.setToolTipText("員工");
		order_comboBox.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		order_comboBox.setEditable(true);
		order_comboBox.setBounds(81, 202, 204, 53);
		panel.add(order_comboBox);
		
		JButton em_button_1_1 = new JButton("確認");
		em_button_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String order_selected=order_comboBox.getSelectedItem().toString();
				if(order_selected.equals("訂單資料查詢")) {
					SearchOorder so=new SearchOorder();
					so.setVisible(true);
					dispose();
				}
			}
		});
		em_button_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		em_button_1_1.setBounds(300, 202, 77, 53);
		panel.add(em_button_1_1);
		

	}
}
