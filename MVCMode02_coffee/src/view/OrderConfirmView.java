package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.OrderDto;
import singleton.Singleton;

public class OrderConfirmView extends JFrame implements ActionListener {
	private JTable jtable;
	private JScrollPane jscrPane;

	private JButton orderBtn;
	private JButton backBtn;

	String columnNames[] = { "BEVERAGE", "시럽", "크기", "샷추가", "휘핑크림", "잔", "총액" };

	Object rowData[][];
	DefaultTableModel model;

	OrderDto dto;

	public OrderConfirmView(OrderDto dto) {
		super("게시판");
		this.dto = dto;
		setLayout(null);

		JLabel label = new JLabel("주문내역 확인");
		label.setBounds(10, 10, 120, 15);
		add(label);

		rowData = new Object[1][7];

		rowData[0][0] = dto.getBeverage();
		if(dto.getSyrup()== 1) {//1바닐라 2카라멜 3헤이즐넛 4는 없다.
			
			rowData[0][1] = "바닐라";
		}else if(dto.getSyrup() == 2) {
			rowData[0][1] = "카라멜";
		}else if (dto.getSyrup() == 3) {
			rowData[0][1] = "헤이즐넛";
		}else if (dto.getSyrup() == 4) {
			rowData[0][1] = "없음";
		}

		if(dto.getShortS() == 1) {
			rowData[0][2] = "Short";
		}
		if(dto.getTallS() == 1) {
			rowData[0][2] = "Tall";
		}
		if(dto.getGrandeS() == 1) {
			rowData[0][2] = "Grande";
		}
		
		if(dto.getShot() == 1) {
			rowData[0][3] = "샷추가";
		}
		if(dto.getCream() == 1) {
			rowData[0][4] = "휘핑크림 추가";
		}
		
		rowData[0][5] = dto.getCup();
		rowData[0][6] = dto.getPrice();

		model = new DefaultTableModel(columnNames, 0); // 높이는 신경안쓰겠다 소리
		model.setDataVector(rowData, columnNames);

		// 테이블 생성
		jtable = new JTable(model);

		jtable.getColumnModel().getColumn(0).setMaxWidth(150); // 번호가 들어갈 폭 (그폭을 줄임)
		jtable.getColumnModel().getColumn(1).setMaxWidth(100); // 제목이 들어감
		jtable.getColumnModel().getColumn(2).setMaxWidth(100);
		jtable.getColumnModel().getColumn(3).setMaxWidth(100);
		jtable.getColumnModel().getColumn(4).setMaxWidth(100);
		jtable.getColumnModel().getColumn(5).setMaxWidth(50);
		jtable.getColumnModel().getColumn(6).setMaxWidth(100);

		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 630, 300);
		add(jscrPane);

		orderBtn = new JButton("결제하기");
		orderBtn.setBounds(500, 400, 100, 20);
		orderBtn.addActionListener(this);
		add(orderBtn);
		
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 660, 480);
		setVisible(true);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		Singleton s = Singleton.getInstace();
		
		if(obj == orderBtn) {
			JOptionPane.showMessageDialog(null, dto.toString());
			
			s.orderCtrl.orderComAf(dto, s.getLoginId());
		}
	}

}























