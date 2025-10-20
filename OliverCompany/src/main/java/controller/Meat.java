package controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

import model.Cart;
import service.impl.CartServiceImpl;
import service.impl.ProductServiceImpl;
import util.Tool;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Meat extends JPanel {

	private static final long serialVersionUID = 1L;
	int[] mmeat=new int[4];
	JSpinner pork,beef,chicken,lamb;
	CartServiceImpl cartsi=new CartServiceImpl();
	ProductServiceImpl psi=new ProductServiceImpl();
	String memberid=Tool.readMember().getMemberid();


	/**
	 * Create the panel.
	 */
	public Meat() {
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 198, 198));
		panel_2.setBounds(10, 10, 625, 429);
		add(panel_2);
		
		JLabel meat = new JLabel("肉　類");
		meat.setBounds(10, 0, 100, 33);
		panel_2.add(meat);
		meat.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
			
		JLabel meat0;
		meat0 = new JLabel("豬肉80元");
		meat0.setBounds(10, 50, 100, 33);
		panel_2.add(meat0);
		meat0.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			
		JLabel meat1;
		meat1 = new JLabel("牛肉150元");
		meat1.setBounds(10, 100, 100, 33);
		panel_2.add(meat1);
		meat1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			
		JLabel meat2;
		meat2 = new JLabel("雞肉80元");
		meat2.setBounds(10, 150, 100, 33);
		panel_2.add(meat2);
		meat2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			
		JLabel meat3;
		meat3 = new JLabel("羊肉100元");
		meat3.setBounds(10, 200, 100, 33);
		panel_2.add(meat3);
		meat3.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			
		pork = new JSpinner();
		pork.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		pork.setBounds(102, 50, 50, 33);
		panel_2.add(pork);
		pork.setFont(new Font("微軟正黑體", Font.PLAIN, 16));

		beef = new JSpinner();
		beef.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		beef.setBounds(102, 100, 50, 33);
		panel_2.add(beef);
		beef.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			
		chicken = new JSpinner();
		chicken.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		chicken.setBounds(102, 150, 50, 33);
		panel_2.add(chicken);
		chicken.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			
		lamb = new JSpinner();
		lamb.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		lamb.setBounds(102, 200, 50, 33);
		panel_2.add(lamb);
		lamb.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JButton pork_btn = new JButton("加入購物車");
		pork_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Cart addcart=new Cart(memberid,psi.selectByProductName("pork").getProductno(),(int)pork.getValue());
				Cart cart=cartsi.selectByProductnoAndMemberid(addcart);
				if(cart != null) {
					cart.setQuantity(addcart.getQuantity()+cart.getQuantity());
					cartsi.updateQuantity(cart);
					JOptionPane.showMessageDialog(null,"已加入購物車");
					pork.setValue(0);
				} else if(cart == null) {
					if(cartsi.addCart(addcart))
					JOptionPane.showMessageDialog(null,"已加入購物車");
					pork.setValue(0);
				};
			}
		});
		pork_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		pork_btn.setBounds(162, 50, 123, 33);
		panel_2.add(pork_btn);
		
		JButton beef_btn = new JButton("加入購物車");
		beef_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Cart addcart=new Cart(memberid,psi.selectByProductName("beef").getProductno(),(int)beef.getValue());
				Cart cart=cartsi.selectByProductnoAndMemberid(addcart);
				if(cart != null) {
					cart.setQuantity(addcart.getQuantity()+cart.getQuantity());
					cartsi.updateQuantity(cart);
					JOptionPane.showMessageDialog(null,"已加入購物車");
					beef.setValue(0);
				} else if(cart == null) {
					if(cartsi.addCart(addcart))
					JOptionPane.showMessageDialog(null,"已加入購物車");
					beef.setValue(0);
				};
			}
		});
		beef_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		beef_btn.setBounds(162, 100, 123, 33);
		panel_2.add(beef_btn);
		
		JButton chicken_btn = new JButton("加入購物車");
		chicken_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Cart addcart=new Cart(memberid,psi.selectByProductName("chicken").getProductno(),(int)chicken.getValue());
				Cart cart=cartsi.selectByProductnoAndMemberid(addcart);
				if(cart != null) {
					cart.setQuantity(addcart.getQuantity()+cart.getQuantity());
					cartsi.updateQuantity(cart);
					JOptionPane.showMessageDialog(null,"已加入購物車");
					chicken.setValue(0);
				} else if(cart == null) {
					if(cartsi.addCart(addcart))
					JOptionPane.showMessageDialog(null,"已加入購物車");
					chicken.setValue(0);
				};
			}
		});
		chicken_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		chicken_btn.setBounds(162, 150, 123, 33);
		panel_2.add(chicken_btn);
		
		JButton lamb_btn = new JButton("加入購物車");
		lamb_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Cart addcart=new Cart(memberid,psi.selectByProductName("lamb").getProductno(),(int)lamb.getValue());
				Cart cart=cartsi.selectByProductnoAndMemberid(addcart);
				if(cart != null) {
					cart.setQuantity(addcart.getQuantity()+cart.getQuantity());
					cartsi.updateQuantity(cart);
					JOptionPane.showMessageDialog(null,"已加入購物車");
					lamb.setValue(0);
				} else if(cart == null) {
					if(cartsi.addCart(addcart))
					JOptionPane.showMessageDialog(null,"已加入購物車");
					lamb.setValue(0);
				};}
		});
		lamb_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lamb_btn.setBounds(162, 200, 123, 33);
		panel_2.add(lamb_btn);
		
	    addComponentListener(new ComponentAdapter() {
	        @Override
	        public void componentShown(ComponentEvent e) {
	        	pork.setValue(0);
	        	beef.setValue(0);
	        	chicken.setValue(0);
	        	lamb.setValue(0);
	        }
	    });

	}
}
