package controller;

import java.awt.EventQueue;
import java.awt.Font;
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

public class DeleteMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField memberid;
	private JTextField username;
	private JTextField name;
	private JTextField phone;
	private JTextField birthday;
	private JTextField address;
	private JButton checkBtn;
	private JButton cancelBtn;
	private MemberServiceImpl msi=new MemberServiceImpl();
	private JTextField sex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteMember frame = new DeleteMember();
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
	public DeleteMember() {
		setBounds(120, 120, 450, 600);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員資料刪除");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		lblNewLabel.setBounds(110, 10, 238, 45);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("會員編號");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(34, 65, 87, 45);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(34, 120, 87, 45);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("姓名");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(34, 175, 87, 45);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("電話");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(34, 230, 87, 45);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("性別");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(34, 285, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("生日");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(34, 340, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("地址");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(34, 395, 87, 45);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		

		
		username = new JTextField();
		username.setEditable(false);
		username.setColumns(10);
		username.setBounds(131, 120, 192, 45);
		panel.add(username);
		username.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		
		name = new JTextField();
		name.setEditable(false);
		name.setColumns(10);
		name.setBounds(131, 175, 192, 45);
		panel.add(name);
		name.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		
		phone = new JTextField();
		phone.setEditable(false);
		phone.setColumns(10);
		phone.setBounds(131, 230, 192, 45);
		panel.add(phone);
		phone.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		
		birthday=new JTextField();
		birthday.setEnabled(false);
		birthday.setEditable(false);
		birthday.setColumns(10);
		birthday.setBounds(131, 340, 192, 45);
		panel.add(birthday);
		birthday.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		
		address = new JTextField();
		address.setEditable(false);
		address.setColumns(10);
		address.setBounds(131, 395, 192, 45);
		panel.add(address);
		address.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		sex = new JTextField();
		sex.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		sex.setEditable(false);
		sex.setColumns(10);
		sex.setBounds(131, 285, 192, 45);
		panel.add(sex);
		
		
/**************event**************/
		
		memberid = new JTextField();
		memberid.setBounds(131, 65, 192, 45);
		panel.add(memberid);
		memberid.setColumns(10);
		memberid.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		
		checkBtn = new JButton("確認刪除");
		checkBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				int result= JOptionPane.showConfirmDialog(
						null,
						"請確認是否刪除會員:"+memberid.getText()+name.getText()+"資料",
						"訊息",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (result==JOptionPane.YES_OPTION) {
					msi.delete(memberid.getText());
					JOptionPane.showMessageDialog(null,"會員資料已刪除");
					memberid.setText("");
					username.setText("");
					name.setText("");
					phone.setText("");
					sex.setText("");
					birthday.setText("");
					address.setText("");
				}

			}
		});
		checkBtn.setVerticalAlignment(SwingConstants.TOP);
		checkBtn.setBounds(46, 469, 150, 39);
		panel.add(checkBtn);
		checkBtn.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		cancelBtn = new JButton("返回上一頁");
		cancelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMenu am=new AdminMenu();
				am.setVisible(true);
				dispose();
			}
		});
		cancelBtn.setVerticalAlignment(SwingConstants.TOP);
		cancelBtn.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		cancelBtn.setBounds(249, 469, 150, 39);
		panel.add(cancelBtn);
		
		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Member member=msi.selectByMemberid(memberid.getText());
				
				if(memberid.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"請輸入會員編號");
				} else if(member==null) {
					JOptionPane.showMessageDialog(null,"請輸入正確會員編號");
				} else {
					//帳號姓名電話 性別生日地址
					username.setText(member.getUsername());
					name.setText(member.getName());
					phone.setText(member.getPhone());
					sex.setText(member.getSex());
					birthday.setText(member.getBirthday());
					address.setText(member.getAddress());
					
				}
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnNewButton_1.setBounds(333, 65, 79, 42);
		panel.add(btnNewButton_1);
	

	}
}
