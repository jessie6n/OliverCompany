package controller;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import model.Employee;
import model.Oorder;
import model.OorderDetail;
import service.impl.CartServiceImpl;
import service.impl.EmployeeServiceImpl;
import service.impl.OorderDetailServiceImpl;
import service.impl.OorderServiceImpl;
import vo.CartTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckOut extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField totalamount;
	private JTextField discount;
	private JTextField finalamount;
	private List<CartTable> selectedItems;
	EmployeeServiceImpl esi=new EmployeeServiceImpl();
	OorderServiceImpl osi=new OorderServiceImpl();
	CartServiceImpl csi=new CartServiceImpl();
	OorderDetailServiceImpl odsi=new OorderDetailServiceImpl();
	String date;
	
	
	/** ✅ 接收從 CartPanel 傳來的資訊 */
    public void setCheckoutData(List<CartTable> items) {
    		this.selectedItems=items;
    }
    
    public void setDate(String date) {
    		this.date=date;
    }

	/**
	 * Create the panel.
	 */
	public CheckOut() {
		
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 198, 198));
		panel_2.setBounds(10, 10, 625, 429);
		add(panel_2);
		
		totalamount = new JTextField();
		totalamount.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		totalamount.setEditable(false);
		totalamount.setColumns(10);
		totalamount.setBounds(138, 56, 129, 46);
		panel_2.add(totalamount);
		
		JLabel lblNewLabel_1_1 = new JLabel("訂單金額");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 56, 129, 46);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("折扣金額");
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(10, 112, 129, 46);
		panel_2.add(lblNewLabel_1_1_1);
		
		discount = new JTextField();
		discount.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		discount.setEditable(false);
		discount.setColumns(10);
		discount.setBounds(138, 112, 129, 46);
		panel_2.add(discount);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("折扣後金額");
		lblNewLabel_1_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(10, 168, 129, 46);
		panel_2.add(lblNewLabel_1_1_2);
		
		finalamount = new JTextField();
		finalamount.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		finalamount.setEditable(false);
		finalamount.setColumns(10);
		finalamount.setBounds(138, 168, 129, 46);
		panel_2.add(finalamount);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("結帳頁面");
		lblNewLabel_1_1_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1_1_3.setBounds(213, 0, 129, 46);
		panel_2.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("付款方式");
		lblNewLabel_1_1_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_1_1_2_1.setBounds(10, 224, 129, 46);
		panel_2.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("服務人員");
		lblNewLabel_1_1_2_2.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2.setBounds(10, 280, 129, 46);
		panel_2.add(lblNewLabel_1_1_2_2);
		
		JComboBox paymentmethod = new JComboBox();
		paymentmethod.setModel(new DefaultComboBoxModel(new String[] {"請選擇","現金", "刷卡", "LinePay"}));
		paymentmethod.setBounds(138, 230, 129, 40);
		panel_2.add(paymentmethod);
		paymentmethod.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		List<Employee> list=esi.selectSales();
		String[] arr1= {"請選擇"};
		String[] names=Stream.concat(Arrays.stream(arr1),
				Arrays.stream(
						list.stream().map(e->e.getEmployeeid()+ "/" +e.getName()).toArray(String[]::new))
				).toArray(String[]::new);
		
		JComboBox employee = new JComboBox();
		employee.setModel(new DefaultComboBoxModel(names));
		employee.setBounds(138, 286, 129, 40);
		panel_2.add(employee);
		employee.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JTextArea orderText = new JTextArea();
		orderText.setBounds(294, 56, 273, 332);
		panel_2.add(orderText);
		orderText.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		//跳轉畫面-->傳遞總金額
		addComponentListener(new ComponentAdapter() {
	        @Override
	        public void componentShown(ComponentEvent e) {
	        	int sum=0;
	        	for(CartTable ct:selectedItems) {
	        		sum+=ct.getSum();
	        	}
	        	totalamount.setText(String.valueOf(sum));
	        	discount.setText("0");
	        	finalamount.setText(String.valueOf(sum));
	        	paymentmethod.setSelectedIndex(0);
	        	employee.setSelectedIndex(0);
	        	orderText.setText("");
	        	
	        }
	    });

		JButton btnNewButton = new JButton("確認付款");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(totalamount.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"訂單金額不得為0");
				} else if(paymentmethod.getSelectedItem().toString().equals("請選擇")) {
					JOptionPane.showMessageDialog(null,"請選擇付款方式");
				} else if(employee.getSelectedItem().toString().equals("請選擇")) {
					JOptionPane.showMessageDialog(null,"請選擇服務人員");
				} else {
					
				//產生訂單資料
				Oorder oorder=new Oorder();
				oorder.setOorderno(osi.getNextOorderNo());
				oorder.setOorderdate(date);
				oorder.setMemberid(selectedItems.get(0).getMemberid());
				oorder.setEmployeeid(employee.getSelectedItem().toString().substring(0,6));
				oorder.setTotalAmount(Integer.parseInt(totalamount.getText()));
				oorder.setDiscount(Integer.parseInt(discount.getText()));
				oorder.setFinalAmount(Integer.parseInt(finalamount.getText()));
				oorder.setPaymentMethod(paymentmethod.getSelectedItem().toString());
				
				OorderDetail oodetail=null;
				
				
				if (osi.insertOrder(oorder)) {
					orderText.setText("訂單編號:"+oorder.getOorderno()+
								"\n時間"+date+
								"\n訂單已完成");
					for(CartTable s:selectedItems) {
						csi.deleteCart(s.getId());
					}
					
					//產生訂單明細-->加入資料庫
					for(CartTable s:selectedItems) {
						oodetail=new OorderDetail();
						oodetail.setOorderno(oorder.getOorderno());
						oodetail.setOorderdetailno(odsi.getNextOorderDetailNo());
						oodetail.setProductno(s.getProductno());
						oodetail.setQuantity(s.getQuantity());
						odsi.insertOorderDetail(oodetail);
					}
	
					totalamount.setText("");
					discount.setText("");
					finalamount.setText("");
					paymentmethod.setSelectedIndex(0);
					employee.setSelectedIndex(0);
				}
				}
			}
		});
		btnNewButton.setBounds(138, 336, 129, 41);
		panel_2.add(btnNewButton);
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));

	}
}
