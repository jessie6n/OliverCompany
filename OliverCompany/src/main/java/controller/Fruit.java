package controller;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

import model.Cart;
import service.impl.CartServiceImpl;
import service.impl.ProductServiceImpl;
import util.Tool;
import vo.CartTable;

import javax.swing.JButton;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Fruit extends JPanel {
	int[] ffruit=new int[5];
	JSpinner orange,apple,banana,grape,kiwi;
	CartServiceImpl cartsi=new CartServiceImpl();
	ProductServiceImpl psi=new ProductServiceImpl();
	String memberid=Tool.readMember().getMemberid();

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Fruit() {
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 198, 198));
		panel_2.setBounds(10, 10, 625, 429);
		add(panel_2);
		
		JLabel fruit = new JLabel("水　果");
		fruit.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		fruit.setBounds(10, 0, 100, 33);
		panel_2.add(fruit);
		
		JLabel fruit0 = new JLabel("橘子10元");
		fruit0.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		fruit0.setBounds(10, 50, 100, 33);
		panel_2.add(fruit0);
		
		JLabel fruit1 = new JLabel("蘋果50元");
		fruit1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		fruit1.setBounds(10, 100, 100, 33);
		panel_2.add(fruit1);
		
		JLabel fruit2 = new JLabel("香蕉20元");
		fruit2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		fruit2.setBounds(10, 150, 100, 33);
		panel_2.add(fruit2);
		
		JLabel fruit3 = new JLabel("葡萄250元");
		fruit3.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		fruit3.setBounds(10, 200, 100, 33);
		panel_2.add(fruit3);
		
		JLabel fruit4 = new JLabel("奇異果25元");
		fruit4.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		fruit4.setBounds(10, 250, 100, 33);
		panel_2.add(fruit4);
		
		orange = new JSpinner();
		orange.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		orange.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		orange.setBounds(112, 50, 50, 33);
		panel_2.add(orange);
		
		apple = new JSpinner();
		apple.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		apple.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		apple.setBounds(112, 100, 50, 33);
		panel_2.add(apple);
		
		banana = new JSpinner();
		banana.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		banana.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		banana.setBounds(112, 150, 50, 33);
		panel_2.add(banana);
		
		grape = new JSpinner();
		grape.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		grape.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		grape.setBounds(112, 200, 50, 33);
		panel_2.add(grape);
		
		kiwi = new JSpinner();
		kiwi.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		kiwi.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		kiwi.setBounds(112, 250, 50, 33);
		panel_2.add(kiwi);
		
		JButton btn_orange = new JButton("加入購物車");
		btn_orange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Cart addcart=new Cart(memberid,psi.selectByProductName("orange").getProductno(),(int)orange.getValue());
				Cart cart=cartsi.selectByProductnoAndMemberid(addcart);
				if(cart != null) {
					cart.setQuantity(addcart.getQuantity()+cart.getQuantity());
					cartsi.updateQuantity(cart);
					JOptionPane.showMessageDialog(null,"已加入購物車");
					orange.setValue(0);
				} else if(cart == null) {
					if(cartsi.addCart(addcart))
					JOptionPane.showMessageDialog(null,"已加入購物車");
					orange.setValue(0);
				};
			}
		});
		btn_orange.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		btn_orange.setBounds(172, 50, 123, 33);
		panel_2.add(btn_orange);
		
		JButton apple_btn = new JButton("加入購物車");
		apple_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Cart addcart=new Cart(memberid,psi.selectByProductName("apple").getProductno(),(int)apple.getValue());
				Cart cart=cartsi.selectByProductnoAndMemberid(addcart);
				if(cart != null) {
					cart.setQuantity(addcart.getQuantity()+cart.getQuantity());
					cartsi.updateQuantity(cart);
					JOptionPane.showMessageDialog(null,"已加入購物車");
					apple.setValue(0);
				} else if(cart == null) {
					if(cartsi.addCart(addcart))
					JOptionPane.showMessageDialog(null,"已加入購物車");
					apple.setValue(0);
				};
			}
		});
		apple_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		apple_btn.setBounds(172, 100, 123, 33);
		panel_2.add(apple_btn);
		
		JButton banana_btn = new JButton("加入購物車");
		banana_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Cart addcart=new Cart(memberid,psi.selectByProductName("banana").getProductno(),(int)banana.getValue());
				Cart cart=cartsi.selectByProductnoAndMemberid(addcart);
				if(cart != null) {
					cart.setQuantity(addcart.getQuantity()+cart.getQuantity());
					cartsi.updateQuantity(cart);
					JOptionPane.showMessageDialog(null,"已加入購物車");
					banana.setValue(0);
				} else if(cart == null) {
					if(cartsi.addCart(addcart))
					JOptionPane.showMessageDialog(null,"已加入購物車");
					banana.setValue(0);
				};
			}
		});
		banana_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		banana_btn.setBounds(172, 150, 123, 33);
		panel_2.add(banana_btn);
		
		JButton grape_btn = new JButton("加入購物車");
		grape_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Cart addcart=new Cart(memberid,psi.selectByProductName("grape").getProductno(),(int)grape.getValue());
				Cart cart=cartsi.selectByProductnoAndMemberid(addcart);
				if(cart != null) {
					cart.setQuantity(addcart.getQuantity()+cart.getQuantity());
					cartsi.updateQuantity(cart);
					JOptionPane.showMessageDialog(null,"已加入購物車");
					grape.setValue(0);
				} else if(cart == null) {
					if(cartsi.addCart(addcart))
					JOptionPane.showMessageDialog(null,"已加入購物車");
					grape.setValue(0);
				};
			}
		});
		grape_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		grape_btn.setBounds(172, 200, 123, 33);
		panel_2.add(grape_btn);
		
		JButton kiwi_btn = new JButton("加入購物車");
		kiwi_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Cart addcart=new Cart(memberid,psi.selectByProductName("kiwi").getProductno(),(int)kiwi.getValue());
				Cart cart=cartsi.selectByProductnoAndMemberid(addcart);
				if(cart != null) {
					cart.setQuantity(addcart.getQuantity()+cart.getQuantity());
					cartsi.updateQuantity(cart);
					JOptionPane.showMessageDialog(null,"已加入購物車");
					kiwi.setValue(0);
				} else if(cart == null) {
					if(cartsi.addCart(addcart))
					JOptionPane.showMessageDialog(null,"已加入購物車");
					kiwi.setValue(0);
				};
			}
		});
		kiwi_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		kiwi_btn.setBounds(172, 250, 123, 33);
		panel_2.add(kiwi_btn);
		
	    addComponentListener(new ComponentAdapter() {
	        @Override
	        public void componentShown(ComponentEvent e) {
	        orange.setValue(0);
	        apple.setValue(0);
	        banana.setValue(0);
	        grape.setValue(0);
	        kiwi.setValue(0);
	        }
	    });

	}
}
