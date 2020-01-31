package view;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dto.MenuDto;
import dto.OrderDto;
import singleton.Singleton;

public class OrderView extends JFrame implements ActionListener {

	private JButton menuBtn;
	private CheckboxGroup size, syrup;
	private Checkbox shortC, tallC, gradeC;
	private Checkbox vanillaC, caramelC, hazelnutC, noC;

	private JTextField textF;

	private JComboBox<String> choiceList;
	private JButton orderBtn, goBtn;

	JCheckBox etc;
	JCheckBox etc2;

	List<MenuDto> list ;

	public OrderView(List<MenuDto> list) {

		setLayout(null);
		this.list= list;

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		JLabel sizeLable = new JLabel();
		sizeLable.setText("사이즈");
		sizeLable.setBounds(10, 50, 100, 20);
		panel.add(sizeLable);

		size = new CheckboxGroup();
		shortC = new Checkbox("Short", size, true);
		tallC = new Checkbox("Tall", size, false);
		gradeC = new Checkbox("Grande", size, false);

		panel.add(shortC);
		panel.add(tallC);
		panel.add(gradeC);

//	 	JRadioButton shortR = new JRadioButton("Short");
//	 	shortR.setSelected(true);
//	 	shortR.setBounds(0, 100, 100, 20);
//	 	panel.add(shortR);
//	 	
//	 	JRadioButton tallR = new JRadioButton("Tall");
//	 	tallR.setSelected(false);
//	 	tallR.setBounds(0, 100, 120, 20);
//	 	panel.add(tallR);
//	 	
//	 	JRadioButton grandeR = new JRadioButton("Grande");
//	 	grandeR.setSelected(false);
//	 	grandeR.setBounds(0, 100, 120, 20);
//	 	panel.add(grandeR);

		panel.setBounds(60, 150, 140, 160);
		// panel.setBackground(Color.blue);
		add(panel);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(5, 1));
		JLabel syrupLable = new JLabel();
		syrupLable.setText("시럽");
		syrupLable.setBounds(10, 50, 100, 20);
		panel2.add(syrupLable);

		syrup = new CheckboxGroup();
		vanillaC = new Checkbox("바닐라", syrup, false);
		caramelC = new Checkbox("캐러멜", syrup, false);
		hazelnutC = new Checkbox("헤이즐넛", syrup, false);
		noC = new Checkbox("no", syrup, false);

		panel2.add(vanillaC);
		panel2.add(caramelC);
		panel2.add(hazelnutC);
		panel2.add(noC);

//	 	JPanel panel4 = new JPanel();
//	 	panel4.setBounds(290, 150, 60, 60);
//	 	
//	 	JRadioButton noR = new JRadioButton("no");
//	 	noR.setSelected(false);
//	 	noR.setBounds(0, 100, 100, 20);
//	 	panel4.add(noR);
//	 	add(panel4);
//	 	panel2.add(panel4);

//	 	
//	 	JRadioButton caramelR = new JRadioButton("캐러멜");
//	 	caramelR.setSelected(false);
//	 	caramelR.setBounds(0, 100, 100, 20);
//	 	panel2.add(caramelR);
//	 	
//	 	JRadioButton hazelnutR = new JRadioButton("헤이즐넛");
//	 	hazelnutR.setSelected(false);
//	 	hazelnutR.setBounds(0, 100, 100, 20);
//	 	panel2.add(hazelnutR);

		panel2.setBounds(238, 150, 140, 160);
		// panel2.setBackground(Color.blue);
		add(panel2);

		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(3, 1));
		JLabel etcLable = new JLabel();
		etcLable.setText("기타");
		etcLable.setBounds(10, 50, 100, 20);
		panel3.add(etcLable);

		etc = new JCheckBox("샷추가", false);
		etc2 = new JCheckBox("휘핑 크림", false);
		panel3.add(etc);
		panel3.add(etc2);

		panel3.setBounds(410, 150, 140, 160);
		// panel3.setBackground(Color.blue);
		add(panel3);

		menuBtn = new JButton("menu");
		menuBtn.setBounds(500, 20, 100, 30);
		menuBtn.addActionListener(this);
		add(menuBtn);

//		orderBtn = new JButton("주문 담기");
//		orderBtn.setBounds(300, 360, 100, 40);
//		add(orderBtn);

		goBtn = new JButton("주문 하기");
		goBtn.setBounds(420, 360, 100, 40);
		goBtn.addActionListener(this);
		add(goBtn);

		textF = new JTextField();
		textF.setBounds(200, 360, 50, 40);
		add(textF);

		JLabel label = new JLabel();
		label.setText("잔");
		label.setBounds(260, 360, 50, 40);
		add(label);

		String coffeeNames[] = { "헤이즐넛카라멜모카", "카라멜마끼아또", "화이트초콜릿모카", "카라멜모카", "카페모카", "카라멜라떼", "카페라떼", "카푸치노",
				"아메리카노", "오늘의커피" };
		choiceList = new JComboBox<String>(coffeeNames);
		choiceList.setBounds(150, 80, 300, 20);
		choiceList.setBackground(Color.WHITE);
		add(choiceList);

		setBounds(100, 100, 640, 480);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		Singleton s = Singleton.getInstace();

		if (obj == menuBtn) {
			s.menuCtrl.getMenuList();
		} else if (obj == goBtn) {
			JOptionPane.showMessageDialog(null, "주문내역가기");
			
			String coffee = (String) choiceList.getSelectedItem(); // 왜 이거 스트링으로 하면 오류나지
			
			int c_short = 0;
			int c_tall = 0;
			int c_grande = 0;
			int c_price = 0;
			
			if (shortC.getState()) {
				c_short = 1;
				c_grande = 0;
				c_tall = 0;
				
				
				for (int i = 0; i < list.size(); i++) {
					if(coffee.equals(list.get(i).getBeverage())) {
					 c_price = list.get(i).getShortSize();
					}
				}
				
			} else if (tallC.getState()) {
				c_short = 0;
				c_grande = 0;
				c_tall = 1;
				for (int i = 0; i < list.size(); i++) {
					if(coffee.equals(list.get(i).getBeverage())) {
					 c_price = list.get(i).getTallSize();
					 System.out.println(c_price);
					}
				}
				
			} else if (gradeC.getState()) {
				c_short = 0;
				c_grande = 1;
				c_tall = 0;
				for (int i = 0; i < list.size(); i++) {
					if(coffee.equals(list.get(i).getBeverage())) {
					 c_price = list.get(i).getGrandeSize();
					}
				}
			}

			int c_syrup = 0;
			if (vanillaC.getState()) {
				c_syrup = 1;
			} else if (caramelC.getState()) {
				c_syrup = 2;
			} else if (hazelnutC.getState()) {
				c_syrup = 3;
			} else if (noC.getState()) {
				c_syrup = 4;
			}

			int c_cream = 0;
			if (etc2.isSelected()) {
				c_cream = 1;
			}

			int c_shot = 0;
			if (etc.isSelected()) {
				c_shot = 1;
			}

			int c_cup = Integer.parseInt(textF.getText());

			OrderDto dto = new OrderDto(coffee, c_syrup, c_short, c_tall, 
					c_grande, c_shot, c_cream, c_cup, c_price*c_cup);
			
			s.orderCtrl.orderConfirm(dto);
		}

	}

}



























