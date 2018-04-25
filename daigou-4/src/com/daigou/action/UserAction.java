package com.daigou.action;

/*import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.daigou.dao.UserDao;
import com.daigou.model.User;
import com.opensymphony.xwork2.ActionSupport;




@Controller @Scope("prototype")
public class UserAction extends ActionSupport{
		
	
    @Resource UserDao userDao;
    
    private User user;
    

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String reg() throws Exception{
		userDao.AddUser(user);
		return "show_view";
		
	}
	
	
	private String errMessage;
	
	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
    
	
	public String login() {
		User db_user = (User)userDao.QueryUserInfo(user.getName()).get(0);
		if(db_user== null) { 
			this.errMessage = " �˺Ų����� ";
			System.out.print(this.errMessage);
			return INPUT;
		} else if( !db_user.getPassword().equals(user.getPassword())) {
			this.errMessage = " ���벻��ȷ! ";
			System.out.print(this.errMessage);
			return INPUT;
		}
		return "show_view";
	}
}*/
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.daigou.dao.UserDao;
import com.daigou.model.User;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class UserAction extends ActionSupport implements SessionAware{
	
	private Map<String,Object> session ;   //������¼���أ�Ҫ���setter��getter
	private String prePage ;
	
	public Map<String,Object> getSession() {
		return session;
	}

	public void setSession(Map<String,Object> 

session) {
		this.session = session;
	}
	public String getPrePage() {
		return prePage;
	}

	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}

	/*ҵ������*/
    @Resource UserDao userDao;
    
    private User user;
    

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String reg() throws Exception{
		userDao.AddUser(user);
		session.put("user",user);
		return "show_view";
		
		}
	
	
	private String errMessage;
	
	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
    
	/* ��֤�û���¼ */
	public String login() {		
		ArrayList<User> listUser = userDao.QueryUserInfo(user.getName());
		if(listUser.size() == 0){ 
			this.errMessage = "�˺Ų�����";
			System.out.print(this.errMessage);
			return "input";
		}		
		else{
		    User db_user = listUser.get(0);				
		    if( !db_user.getPassword().equals(user.getPassword())) {   
		    	this.errMessage = " ���벻��ȷ! ";
			    System.out.print(this.errMessage);
			    return "input";
		    }
		    else{
		    	session.put("user",db_user);  
		    	/*prePage = (String) session.get("prePage");
		    	System.out.println("��Ҫ����:" + prePage);
		    	session.remove("prePage");    */
		    	return "success";
		    }		    
		}		
	}		
}