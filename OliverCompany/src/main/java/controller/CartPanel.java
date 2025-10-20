package controller;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import service.impl.CartServiceImpl;
import service.impl.ProductServiceImpl;
import util.Tool;
import vo.CartTable;
import vo.service.impl.CartTableServiceImpl;

import javax.swing.JButton;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CartPanel extends JPanel {
	CartTableServiceImpl ctsi=new CartTableServiceImpl();
	CartServiceImpl csi=new CartServiceImpl();
	ProductServiceImpl psi=new ProductServiceImpl();
	String memberid=Tool.readMember().getMemberid();
	DefaultTableModel model;
	CheckOut checkout=new CheckOut();
	int total;

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CartPanel(CheckOut checkout) {
		setLayout(new BorderLayout(0, 0));
		UIManager.put("OptCartPanel()ionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
		UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
		
		String[] columnNames = {"選取","商品名稱","單價","數量","小計",};
		
		model = new DefaultTableModel(columnNames, 0) {
			
            public boolean isCellEditable(int row, int column) {
                // 只允許 "選取" 欄可編輯 (checkbox)
                return getColumnName(column).equals("選取");
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) return Boolean.class;
                return super.getColumnClass(columnIndex);
            }
        };
        
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        add(scrollPane,BorderLayout.CENTER);
        
	    addComponentListener(new ComponentAdapter() {
	        @Override
	        public void componentShown(ComponentEvent e) {
	        	model.setRowCount(0);
	    		List<CartTable> list=ctsi.cartViewByMemberid(memberid);
	    		model.fireTableDataChanged();
	    	
	    		for (CartTable c:list) {
	    			model.addRow(new Object[]{false,c.getChi_name(),c.getPrice(),c.getQuantity(),c.getSum()});
	    		}
	        }
	    });
	    
        JButton button1 = new JButton("結　帳");
        button1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				UIManager.put("OptionPane.buttonFont",(new Font("微軟正黑體", Font.PLAIN, 16)));
				
				if(total==0) {
					JOptionPane.showMessageDialog(null,"請選取欲購買商品");
				} else {
					// 取得 CardLayout 並切換頁面
					Container parent = getParent();
					if (parent.getLayout() instanceof CardLayout layout) {
						layout.show(parent, "checkout");
					}
                }
        	}
        });
        button1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        
        JButton button2 = new JButton("刪　除");
        button2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
                List<Integer> selectedIds = new ArrayList<>();
                List<Integer> selectedRows = new ArrayList<>();
                	for (int i = 0; i < model.getRowCount(); i++) {
                		Boolean checked = (Boolean) model.getValueAt(i, 0); // 取選取欄
                		if (checked != null && checked) {
                			String chi_name=model.getValueAt(i, 1).toString();
                			int id= ctsi.getCartIdByMemberidAndChi_name(memberid,chi_name).get(0).getId();
                			selectedIds.add(id);
                			selectedRows.add(i);
                			
                			}
                	}
                    
                    if (selectedIds.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "沒有選取任何商品！");
                    } else {
    						int result= JOptionPane.showConfirmDialog(
    							null,
    							"確認是否刪除?",
    							"訊息",
    							JOptionPane.YES_NO_OPTION,
    							JOptionPane.QUESTION_MESSAGE);
    						if (result==JOptionPane.YES_OPTION) {    						
    							for(int s:selectedIds) {
    								csi.deleteCart(s);
    							}
    							for(int s:selectedRows) {
    								model.removeRow(s);
    							}
    							JOptionPane.showMessageDialog(null, "購物車已刪除" );
    							model.fireTableDataChanged();
    							table.revalidate();
    							table.repaint();
    						}
                    }
        	}
        });
        button2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        
        JButton button3 = new JButton("全　選");
        button3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		for (int i = 0; i < model.getRowCount(); i++) {
        				model.setValueAt(true, i, 0);
        		}
        	}
        });
        button3.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        
        JButton button4 = new JButton("取消全選");
        button4.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		for (int i = 0; i < model.getRowCount(); i++) {
        				model.setValueAt(false, i, 0);
        		}
        	}
        });
        button4.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
 
	    
        // ===== 下方新增按鈕 =====
        JPanel buttonPanel = new JPanel(); // 預設是FlowLayout(水平排列)
        JLabel label = new JLabel("總金額");
        label.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        JTextArea text=new JTextArea();
        text.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        
        // 加到按鈕Panel
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(label);
        buttonPanel.add(text);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        
        // 把按鈕Panel放到最下方
        add(buttonPanel, BorderLayout.SOUTH);
        
        // ===== 上方新增標題 =====
        JPanel buttonPanel2 = new JPanel(); // 預設是FlowLayout(水平排列)
        JLabel label2 = new JLabel("購物車");
        label2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
        
        buttonPanel2.add(label2);
        add(buttonPanel2, BorderLayout.NORTH);
	    
        
        // ===== 事件監聽 =====
        // 計算勾選商品總金額
        model.addTableModelListener(e -> {
        		
        		total=0;
        		String str="";
        		List<CartTable> selectedItems=new ArrayList();
        		CartTable cartcheck=null;
            for (int i = 0; i < model.getRowCount(); i++) {
                Boolean checked = (Boolean) model.getValueAt(i, 0);
                int sum = (int) model.getValueAt(i, 4);
                

                if (checked != null && checked) {
                    total += sum;
                    cartcheck=ctsi.getCartIdByMemberidAndChi_name(memberid, model.getValueAt(i, 1).toString()).get(0);
                    selectedItems.add(cartcheck);
                }
            }
            text.setText(String.valueOf(total)); 
            checkout.setCheckoutData(selectedItems);
        		
        });
        
	}
}