package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import singleton.Singleton;

public class LoginView extends JFrame implements ActionListener {
	private JTextField idTextF;
	private JPasswordField pwTextF;
	
	private JButton logBtn;
	private JButton accountBtn;
	
	public LoginView() {
		super("로그인");
		setLayout(null);
		
		JLabel loginLabel = new JLabel("로그인 화면");
		loginLabel.setBounds(100, 10, 120, 15);
		add(loginLabel);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(31, 60, 67, 15);
		add(idLabel);
		
		idTextF = new JTextField(10);
		idTextF.setBounds(100, 60, 150, 20);
		add(idTextF);
		
		JLabel passLabel = new JLabel("PW:");
		passLabel.setBounds(31, 104, 67, 15);
		add(passLabel);
		
		pwTextF = new JPasswordField();
		pwTextF.setBounds(100, 104, 150, 20);
		add(pwTextF);
				
		logBtn = new JButton("log-in");
		logBtn.setBounds(270, 60, 100, 60);
		logBtn.addActionListener(this);
		add(logBtn);
		
		accountBtn = new JButton("회원가입");
		accountBtn.setBounds(100, 150, 250, 25);
		accountBtn.addActionListener(this);
		add(accountBtn);
		
		setBounds(100, 100, 400, 250);
		getContentPane().setBackground(Color.gray);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {				
				System.exit(0);				
			}			
		});
	}
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		
		Singleton s = Singleton.getInstace();
		
		if(btn == logBtn) {
			s.memCtrl.loginAf(idTextF.getText(), pwTextF.getText());
		}
		else if(btn == accountBtn) {
			s.memCtrl.regi();
		}
		this.dispose();
		
	}
}






















