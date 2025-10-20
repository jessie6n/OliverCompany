package controller;

import java.awt.Color;
import java.awt.Font;

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

import javax.swing.JButton;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Seafood extends JPanel {

	private static final long serialVersionUID = 1L;
	int[] sseafood=new int[5];
	JSpinner salmon,snapper,shrimp,clams;
	CartServiceImpl cartsi=new CartServiceImpl();
	ProductServiceImpl psi=new ProductServiceImpl();
	String memberid=Tool.readMember().getMemberid();


	/**
	 * Create the panel.
	 */
	public Seafood() {
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 198, 198));
		panel_2.setBounds(10, 10, 625, 429);
		add(panel_2);
		
		JLabel seafood = new JLabel("海　鮮");
		seafood.setBounds(10, 0, 100, 33);
		panel_2.add(seafood);
		seafood.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
			
		JLabel seafood0;
		seafood0 = new JLabel("鮭魚排199元");
		seafood0.setBounds(10, 50, 100, 33);
		panel_2.add(seafood0);
		seafood0.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			
		JLabel seafood1;
		seafood1 = new JLabel("鯛魚片139元");
		seafood1.setBounds(10, 100, 100, 33);
		panel_2.add(seafood1);
		seafood1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			
		JLabel seafood2;
		seafood2 = new JLabel("蝦子160元");
		seafood2.setBounds(10, 150, 100, 33);
		panel_2.add(seafood2);
		seafood2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			
		JLabel seafood3;
		seafood3 = new JLabel("蛤蠣69元");
		seafood3.setBounds(10, 200, 100, 33);
		panel_2.add(seafood3);
		seafood3.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			
		salmon = new JSpinner();
		salmon.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		salmon.setBounds(112, 50, 50, 33);
		panel_2.add(salmon);
		salmon.setFont(new Font("微軟正黑體", Font.PLAIN, 16));

		snapper = new JSpinner();
		snapper.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		snapper.setBounds(112, 100, 50, 33);
		panel_2.add(snapper);
		snapper.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			
		shrimp = new JSpinner();
		shrimp.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		shrimp.setBounds(112, 150, 50, 33);
		panel_2.add(shrimp);
		shrimp.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
			
		clams = new JSpinner();
		clams.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		clams.setBounds(112, 200, 50, 33);
		panel_2.add(clams);
		clams.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JButton salmon_btn = new JButton("加入購物車");
		salmon_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Cart addcart=new Cart(memberid,psi.selectByProductName("salmon").getProductno(),(int)salmon.getValue());
				Cart cart=cartsi.selectByProductnoAndMemberid(addcart);
				if(cart != null) {
					cart.setQuantity(addcart.getQuantity()+cart.getQuantity());
					cartsi.updateQuantity(cart);
					JOptionPane.showMessageDialog(null,"已加入購物車");
					salmon.setValue(0);
				} else if(cart == null) {
					if(cartsi.addCart(addcart))
					JOptionPane.showMessageDialog(null,"已加入購物車");
					salmon.setValue(0);
				};
			}
		});
		salmon_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		salmon_btn.setBounds(170, 50, 123, 33);
		panel_2.add(salmon_btn);
		
		JButton snapper_btn = new JButton("加入購物車");
		snapper_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Cart addcart=new Cart(memberid,psi.selectByProductName("snapper").getProductno(),(int)snapper.getValue());
				Cart cart=cartsi.selectByProductnoAndMemberid(addcart);
				if(cart != null) {
					cart.setQuantity(addcart.getQuantity()+cart.getQuantity());
					cartsi.updateQuantity(cart);
					JOptionPane.showMessageDialog(null,"已加入購物車");
					snapper.setValue(0);
				} else if(cart == null) {
					if(cartsi.addCart(addcart))
					JOptionPane.showMessageDialog(null,"已加入購物車");
					snapper.setValue(0);
				};
			}
		});
		snapper_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		snapper_btn.setBounds(170, 100, 123, 33);
		panel_2.add(snapper_btn);
		
		JButton shrimp_btn = new JButton("加入購物車");
		shrimp_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Cart addcart=new Cart(memberid,psi.selectByProductName("shrimp").getProductno(),(int)shrimp.getValue());
				Cart cart=cartsi.selectByProductnoAndMemberid(addcart);
				if(cart != null) {
					cart.setQuantity(addcart.getQuantity()+cart.getQuantity());
					cartsi.updateQuantity(cart);
					JOptionPane.showMessageDialog(null,"已加入購物車");
					shrimp.setValue(0);
				} else if(cart == null) {
					if(cartsi.addCart(addcart))
					JOptionPane.showMessageDialog(null,"已加入購物車");
					shrimp.setValue(0);
				};
			}
		});
		shrimp_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		shrimp_btn.setBounds(170, 150, 123, 33);
		panel_2.add(shrimp_btn);
		
		JButton clams_btn = new JButton("加入購物車");
		clams_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				Cart addcart=new Cart(memberid,psi.selectByProductName("clams").getProductno(),(int)clams.getValue());
				Cart cart=cartsi.selectByProductnoAndMemberid(addcart);
				if(cart != null) {
					cart.setQuantity(addcart.getQuantity()+cart.getQuantity());
					cartsi.updateQuantity(cart);
					JOptionPane.showMessageDialog(null,"已加入購物車");
					clams.setValue(0);
				} else if(cart == null) {
					if(cartsi.addCart(addcart))
					JOptionPane.showMessageDialog(null,"已加入購物車");
					clams.setValue(0);
				};}
		});
		clams_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clams_btn.setBounds(170, 200, 123, 33);
		panel_2.add(clams_btn);

	    addComponentListener(new ComponentAdapter() {
	        @Override
	        public void componentShown(ComponentEvent e) {
	        	salmon.setValue(0);
	        	snapper.setValue(0);
	        	shrimp.setValue(0);
	        	clams.setValue(0);
	        }
	    });
	}

}
