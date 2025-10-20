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

import model.Employee;
import model.Member;
import service.impl.EmployeeServiceImpl;
import service.impl.MemberServiceImpl;
import vo.OorderView;
import vo.service.impl.OorderViewServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SearchOorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private EmployeeServiceImpl esi=new EmployeeServiceImpl();
	private OorderViewServiceImpl ovsi=new OorderViewServiceImpl();
	MemberServiceImpl msi=new MemberServiceImpl();
	private CardLayout cardLayout;
	private JPanel cardPanel;
	JTextField memberid;
	JTextField oorderno;
	JTextField datefrom;
	JTextField dateto;
	JTextField membername;
	JTextField employeeid;
	JTextField employeename;
	OorderPanel oorderPanel=new OorderPanel();
	List<OorderView> oorderlist;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchOorder frame = new SearchOorder();
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
	public SearchOorder() {
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1186, 164);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel2 = new JLabel("訂單資料查詢");
		lblNewLabel2.setForeground(new Color(128, 0, 255));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel2.setBounds(509, 10, 149, 34);
		panel.add(lblNewLabel2);
		
		memberid = new JTextField();
		memberid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Member mb=msi.selectByMemberid(memberid.getText());
				if(mb !=null) {membername.setText(mb.getName());}
			}
		});
		memberid.setBounds(133, 104, 116, 43);
		panel.add(memberid);
		memberid.setColumns(10);
		memberid.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		oorderno = new JTextField();
		oorderno.setColumns(10);
		oorderno.setBounds(133, 51, 116, 43);
		panel.add(oorderno);
		oorderno.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("訂單編號");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(10, 50, 124, 45);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		datefrom = new JTextField();
		datefrom.setEditable(false);
		datefrom.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		datefrom.setColumns(10);
		datefrom.setBounds(371, 52, 116, 43);
		panel.add(datefrom);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("訂單日期");
		lblNewLabel_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_2.setBounds(248, 51, 123, 45);
		panel.add(lblNewLabel_1_1_1_1_2);
		
		dateto = new JTextField();
		dateto.setEditable(false);
		dateto.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		dateto.setColumns(10);
		dateto.setBounds(608, 51, 116, 43);
		panel.add(dateto);
		
		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("~");
		lblNewLabel_1_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_2_1.setBounds(584, 52, 23, 43);
		panel.add(lblNewLabel_1_1_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("會員編號");
		lblNewLabel_1_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_3.setBounds(10, 104, 124, 43);
		panel.add(lblNewLabel_1_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_1_3_1 = new JLabel("會員姓名");
		lblNewLabel_1_1_1_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_3_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_3_1.setBounds(248, 102, 124, 43);
		panel.add(lblNewLabel_1_1_1_1_3_1);
		
		membername = new JTextField();
		membername.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		membername.setColumns(10);
		membername.setBounds(371, 102, 116, 43);
		panel.add(membername);
		
		JLabel lblNewLabel_1_1_1_1_3_1_1 = new JLabel("員工姓名");
		lblNewLabel_1_1_1_1_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_3_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_3_1_1.setBounds(724, 102, 124, 43);
		panel.add(lblNewLabel_1_1_1_1_3_1_1);
		
		JLabel lblNewLabel_1_1_1_1_3_2 = new JLabel("員工編號");
		lblNewLabel_1_1_1_1_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_3_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_3_2.setBounds(486, 104, 124, 43);
		panel.add(lblNewLabel_1_1_1_1_3_2);
		
		employeeid = new JTextField();
		employeeid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Employee em=esi.selectByEmployeeid(employeeid.getText());
				if(em !=null) {
				employeename.setText(em.getName());}
			}
		});
		employeeid.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		employeeid.setColumns(10);
		employeeid.setBounds(609, 104, 116, 43);
		panel.add(employeeid);
		
		employeename = new JTextField();
		employeename.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		employeename.setColumns(10);
		employeename.setBounds(847, 102, 116, 43);
		panel.add(employeename);
		
		cardLayout=new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setBounds(0, 174, 1186, 659);
		contentPane.add(cardPanel);
		cardPanel.setLayout(cardLayout);
		
		//datefrom
        JFrame framefrom = new JFrame("JCalendar");
        framefrom.setSize(400, 400);
        framefrom.setLocationRelativeTo(null);

		JCalendar calendarfrom=new JCalendar();

        calendarfrom.getDayChooser().addPropertyChangeListener("day", evt -> {
        		Date selectedDatefrom = calendarfrom.getDate();
        		SimpleDateFormat sdffrom = new SimpleDateFormat("yyyy-MM-dd");
        		datefrom.setText(sdffrom.format(selectedDatefrom));
        });
        framefrom.getContentPane().setLayout(null);
        calendarfrom.setBounds(50, 50, 300, 200);
        framefrom.getContentPane().add(calendarfrom);
        
        //dateto
        JFrame frameto = new JFrame("JCalendar");
        frameto.setSize(400, 400);
        frameto.setLocationRelativeTo(null);

		JCalendar calendarto=new JCalendar();

        calendarto.getDayChooser().addPropertyChangeListener("day", evt -> {
        		Date selectedDateto = calendarto.getDate();
        		SimpleDateFormat sdfto = new SimpleDateFormat("yyyy-MM-dd");
        		dateto.setText(sdfto.format(selectedDateto));
        });
        frameto.getContentPane().setLayout(null);
        calendarto.setBounds(50, 50, 300, 200);
        frameto.getContentPane().add(calendarto);
		
		JButton datefrom_btn = new JButton("日期");
		datefrom_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				framefrom.setVisible(true);
			}
		});
		datefrom_btn.setVerticalAlignment(SwingConstants.TOP);
		datefrom_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		datefrom_btn.setBounds(486, 55, 72, 39);
		panel.add(datefrom_btn);
		
		JButton dateto_btn = new JButton("日期");
		dateto_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameto.setVisible(true);
			}
		});
		dateto_btn.setVerticalAlignment(SwingConstants.TOP);
		dateto_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		dateto_btn.setBounds(723, 55, 72, 39);
		panel.add(dateto_btn);
		
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				oorderlist=ovsi.searchOoderByInput(
						oorderno.getText(),
						datefrom.getText(),
						dateto.getText(),
						memberid.getText(),
						membername.getText(),
						employeeid.getText(),
						employeename.getText());
				
				oorderPanel.setSearchOrder(oorderlist);

				cardPanel.add(oorderPanel, "oorderTable");
				cardLayout.show(cardPanel,"oorderPanel");
			}
		});
		btnNewButton.setBounds(1011, 65, 141, 42);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JButton btnNewButton_2 = new JButton("返回選單");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMenu am=new AdminMenu();
				am.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnNewButton_2.setBounds(1011, 110, 141, 42);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("清空條件");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				oorderno.setText("");
				datefrom.setText("");
				dateto.setText("");
				memberid.setText("");
				membername.setText("");
				employeeid.setText("");
				employeename.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnNewButton_1.setBounds(1011, 20, 141, 42);
		panel.add(btnNewButton_1);

	}
}
