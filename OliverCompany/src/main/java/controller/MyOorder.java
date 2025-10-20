package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Member;
import util.Tool;
import vo.DetailView;
import vo.OorderExcelByEmployee;
import vo.OorderView;
import vo.service.impl.DetailViewServiceImpl;
import vo.service.impl.OorderExcelByEmployeeServiceImpl;
import vo.service.impl.OorderViewServiceImpl;
import java.awt.CardLayout;

public class MyOorder extends JPanel {
	private DefaultTableModel model,model2;
	private JTable table,table2;
	private static final long serialVersionUID = 1L;
	private Member member=Tool.readMember();
	OorderViewServiceImpl ovsi=new OorderViewServiceImpl();
	List<OorderView> list;

	/**
	 * Create the panel.
	 */
	public MyOorder() {
		
		/*JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 198, 198));
		panel_2.setBounds(10, 10, 625, 429);
		add(panel_2);*/
		
		String[] columnName= {"訂單日期","訂單編號","訂購人","服務人員","訂單金額","訂單明細"};
		model=new DefaultTableModel(columnName,0){
			
            public boolean isCellEditable(int row, int column) {
                // 只允許 "選取" 欄可編輯 (checkbox)
                return getColumnName(column).equals("訂單明細");
            }
        };
        setLayout(new CardLayout(0, 0));
		
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        add(scrollPane, "name_70135834255099");
        
        table.getColumn("訂單明細").setCellRenderer((table1, value, isSelected, hasFocus, row, column) -> {
            JButton btn = new JButton("查看");
            return btn;
        });
        
        //按"查看"顯示訂單內容
        DetailViewServiceImpl dvsi=new DetailViewServiceImpl();
        
        table.getColumn("訂單明細").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            JButton btn = new JButton("查看");

            {
                btn.addActionListener(e -> {
                    int row = table.getSelectedRow();
                    String orderId = (String) model.getValueAt(row, 1);
                    
                    //訂單明細table
                    JFrame frame=new JFrame("訂單明細");
                    frame.setVisible(true);
                    frame.setBounds(300, 200, 500, 300);
                    
                    String[] columnName2= {"商品名稱","單價","數量","小計"};
                    model2=new DefaultTableModel(columnName2,0);
                    
                    table2=new JTable(model2);
                    table2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
                    JScrollPane scrollPane2 = new JScrollPane(table2);
                    frame.getContentPane().add(scrollPane2,BorderLayout.CENTER);
                    
                    List<DetailView> dv=dvsi.selectDetailByOorderNo(orderId);
                    
                    /*for(DetailView d:dv) {
                    		model2.addRow(new Object[] {d.getProductname(),d.getPrice(),d.getQuantity(),d.getSubtotal()});
                    }*/
                    
                    Stream<DetailView> d=dv.stream();
                    d.forEach((t)->model2.addRow(new Object[]
                    		{t.getProductname(),t.getPrice(),t.getQuantity(),t.getSubtotal()}));
                    
                   
                  
                    //table上方資料顯示日期+訂購人
                    OorderViewServiceImpl ovsi=new OorderViewServiceImpl();
                    JPanel buttonPanel = new JPanel(); // 預設是FlowLayout(水平排列)
                    JLabel label = new JLabel("訂單日期："+
                    		ovsi.searchOoderByInput(orderId, null, null, null, null, null, null).get(0).getDate().substring(0,11));
                    label.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
                    
                    JLabel label3 = new JLabel("訂購人："+
                    		ovsi.searchOoderByInput(orderId, null, null, null, null, null, null).get(0).getMembername());
                    label3.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
                    
                    // 加到按鈕Panel
                    buttonPanel.add(label);
                    buttonPanel.add(label3);
                    // 把按鈕Panel放到最下方
                    frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
                    
                    //table下方顯示訂單金額
                    JPanel buttonPanel2 = new JPanel(); // 預設是FlowLayout(水平排列)
                    JLabel label2 = new JLabel("訂單金額："+
                    		ovsi.searchOoderByInput(orderId, null, null, null, null, null, null).get(0).getFinalamount());
                    label2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
                    // 加到按鈕Panel
                    buttonPanel2.add(label2);
                    // 把按鈕Panel放到最下方
                    frame.getContentPane().add(buttonPanel2, BorderLayout.SOUTH);

                });
            }
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                return btn;
            }
        });
        
	    addComponentListener(new ComponentAdapter() {
	        @Override
	        public void componentShown(ComponentEvent e) {
		      	model.setRowCount(0); 
		        list=ovsi.searchOoderByInput(null, null, null, member.getMemberid(), null, null, null);
	            model.fireTableDataChanged();
	            for(OorderView o:list) {	            	
	            		model.addRow(new Object[]{o.getDate(),o.getOorderno(),o.getMembername(),o.getEmployeename(),o.getFinalamount()});
	            }
	    		revalidate();
	    		repaint();
	        }
	    });

	}

}
