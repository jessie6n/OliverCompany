package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.toedter.calendar.JCalendar;

import dao.impl.MemberDaoImpl;
import model.Member;

public class SearchMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField address;
	private JTextField name;
	private MemberDaoImpl mdi=new MemberDaoImpl();
	private JTextField memberid;
	private JTextField birthday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchMember frame = new SearchMember();
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
	public SearchMember() {
		setBounds(100, 100, 450, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 440);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel2 = new JLabel("會員資料查詢");
		lblNewLabel2.setForeground(new Color(128, 0, 255));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel2.setBounds(143, 22, 149, 34);
		panel.add(lblNewLabel2);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("地址");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(72, 175, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("性別");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(72, 230, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		memberid = new JTextField();
		memberid.setBounds(159, 67, 141, 43);
		panel.add(memberid);
		memberid.setColumns(10);
		memberid.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(159, 175, 141, 43);
		panel.add(address);
		address.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		JComboBox sex = new JComboBox();
		sex.setModel(new DefaultComboBoxModel(new String[] {"請選擇", "男", "女"}));
		sex.setBounds(159, 230, 141, 45);
		panel.add(sex);
		sex.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("姓名");
		lblNewLabel_1_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(71, 120, 88, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1_2);
		
		name = new JTextField();
		name.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		name.setColumns(10);
		name.setBounds(159, 120, 141, 43);
		panel.add(name);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("會員編號");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(35, 66, 124, 45);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("生日");
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(72, 285, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
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

		
		birthday = new JTextField();
		birthday.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		birthday.setEditable(false);
		birthday.setColumns(10);
		birthday.setBounds(157, 285, 141, 45);
		panel.add(birthday);
		
		
		JButton checkBtn_1 = new JButton("日期");
		checkBtn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(true);
			}
		});
		checkBtn_1.setVerticalAlignment(SwingConstants.TOP);
		checkBtn_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		checkBtn_1.setBounds(308, 285, 73, 39);
		panel.add(checkBtn_1);
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				try {
				String mmemberid=memberid.getText();
				String nname=name.getText();
				String aaddress=address.getText();
				String ssex = null;
				String bbirthday = birthday.getText();
			
				if(!sex.getSelectedItem().toString().equals("請選擇")) {
					ssex=sex.getSelectedItem().toString();
				}
				
				List<Member> list = mdi.selectMemberByInput(mmemberid, nname, aaddress, ssex, bbirthday);
				
				String[] columnNames = {"會員編號","姓名","帳號","電話","地址","性別","生日"};
				
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
			    for (Member m : list) {
			        model.addRow(new Object[]{m.getMemberid(),m.getName(),m.getUsername(),m.getPhone(),m.getAddress(),
			        		m.getSex(),m.getBirthday()});
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
		btnNewButton.setBounds(72, 349, 141, 42);
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
		btnNewButton_2.setBounds(245, 349, 141, 42);
		panel.add(btnNewButton_2);
		
	}
}
