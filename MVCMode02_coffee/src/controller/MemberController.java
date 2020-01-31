package controller;

import javax.swing.JOptionPane;

import dto.MemberDto;
import service.MemberService;
import service.impl.MemberServiceImpl;
import singleton.Singleton;
import view.AccountView;
import view.LoginView;

public class MemberController {
	
	MemberService memServ = new MemberServiceImpl();
	
	public void login() {
		new LoginView();
	}
	
	public void regi() {
		new AccountView();
	}
	
	public void regiAf(String id, String pwd, String name, String email) {
		boolean b = memServ.addMember(new MemberDto(id, pwd, name, email, 3)); // 사용자는 3번
		if(b) {
			JOptionPane.showMessageDialog(null, "회원가입 성공!");
			login(); 
		}else {
			JOptionPane.showMessageDialog(null, "회원가입 실패");
			regi(); // 다시 기입해라. 
		}
	}
	
	public boolean idCheck(String id) {
		return memServ.getId(id);
	}
	
	public void loginAf(String id, String pwd) {
		
		MemberDto dto = memServ.login(id, pwd);
		if(dto == null) {
			JOptionPane.showMessageDialog(null, "id나 password가 틀렸습니다");
			login();
		}else {
			JOptionPane.showMessageDialog(null, dto.getId() + "님 환영합니다");
			Singleton s = Singleton.getInstace();
			s.setLoginId(dto.getId());
			
			s.menuCtrl.order();
			
			
		}
	}
}
