package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import dto.MenuDto;

public class MenuView extends JFrame implements ActionListener {
	
	private static MenuView singletonMenuView = null;
	
	public MenuView() {
	
	}
	
	public static MenuView getInstance() {
		if(singletonMenuView == null) {
			singletonMenuView = new MenuView();
		}
		return singletonMenuView;
	}
	
	

	private JTable jtable;
	private JScrollPane jscrPane;
	
	private JButton menuBtn;
	private JButton logoutBtn;
	
	String columnNames[] = {
			"Id", "BEVERAGE", "Short", "Tall","Grande"	
		};
	
	Object rowData[][];	
	DefaultTableModel model;	// table의 넓이를 설정
	
	List<MenuDto> list = null;
	
	public void menu(List<MenuDto> list) {
		setLayout(null);
		
		this.list = list;
		
		rowData = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			MenuDto dto = list.get(i);
			
			rowData[i][0] = i+1;
			rowData[i][1] = dto.getBeverage();// 음료이름
			rowData[i][2] = dto.getShortSize();
			rowData[i][3] = dto.getTallSize(); 
			rowData[i][4] = dto.getGrandeSize(); 
		}
		model = new DefaultTableModel(columnNames,0); // 높이는 신경안쓰겠다 소리
		model.setDataVector(rowData, columnNames);
		
		jtable = new JTable(model);
		jtable.getColumnModel().getColumn(0).setMaxWidth(50);
		jtable.getColumnModel().getColumn(1).setMaxWidth(380); 	//번호가 들어갈 폭 (그폭을 줄임)
		jtable.getColumnModel().getColumn(2).setMaxWidth(60);	//제목이 들어감
		jtable.getColumnModel().getColumn(3).setMaxWidth(60);	//작성자
		jtable.getColumnModel().getColumn(4).setMaxWidth(60);	//작성자
		
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 700, 300);
		add(jscrPane); // 눈에 보는 테이블이라고 강사님이 말하심..
		
		
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 500);
		setVisible(true);
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		

	}

}































