package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dto.OrderDto;

public class OrderCompleteView extends JFrame implements ActionListener {

	private JButton orderBtn;
	
	private JTable jtable;
	private JScrollPane jscrPane;
	
	String columnNames[] = {
		"주문한 커피", "주문시간", "사이즈", "잔","총 금액"	
	};
	
	Object rowData[][];	
	DefaultTableModel model;
	
	List<OrderDto> list = null;
	
	public OrderCompleteView(List<OrderDto> list) {
		super("주문한 커피");
		setLayout(null);
		
		this.list = list;
		
		JLabel coffeeOrderL = new JLabel("주문한 커피");
		coffeeOrderL.setBounds(100, 10, 2, 15);
		add(coffeeOrderL);
		
		rowData = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			OrderDto dto = list.get(i);
			
			rowData[i][0] = dto.getBeverage();
			rowData[i][1] = dto.getWdate();
			if(dto.getShortS() == 1) {
				rowData[i][2] = "Short";
			}
			if(dto.getTallS() == 1) {
				rowData[i][2] = "Tall";
			}
			if(dto.getGrandeS() == 1) {
				rowData[i][2] = "Grande";
			}
			rowData[i][3] = dto.getCup();
			rowData[i][4] = dto.getPrice();
		}
		model = new DefaultTableModel(columnNames, 0); // 높이는 신경안쓰겠다 소리
		model.setDataVector(rowData, columnNames);
		
		jtable = new JTable(model);
		
		jtable.getColumnModel().getColumn(0).setMaxWidth(150); // 번호가 들어갈 폭 (그폭을 줄임)
		jtable.getColumnModel().getColumn(1).setMaxWidth(100); // 제목이 들어감
		jtable.getColumnModel().getColumn(2).setMaxWidth(100);
		jtable.getColumnModel().getColumn(3).setMaxWidth(100);
		jtable.getColumnModel().getColumn(4).setMaxWidth(100);
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 630, 300);
		add(jscrPane);
		
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 660, 480);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

























