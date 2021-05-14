package vo;

import java.util.HashMap;
import java.util.Map;

public class Users {
	private String ID;
	private String password;
	private String role;
	private int integral;
	
	public String getRole() {
		return role;
	}
	public int getIntegral() {
		return integral;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}

	private Map<String, String> errors = new HashMap<String, String>();
	
	public String getID() {
		return ID;
	}
	public String getPassword() {
		return password;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public boolean isValidate() {
		boolean flag = true;
		System.out.println("����Bean,��ʼ��֤");
		if(!this.ID.matches("\\w{4,8}")) {
			flag = false;
			this.ID="";
			this.errors.put("errID","�û�����4~8λ��ĸ������");
		}
		if(!this.password.matches("\\w{4,8}")) {
			flag = false;
			this.password = "";
			this.errors.put("errpass","������4~8λ��ĸ������");
		}
		System.out.println("����Bean,����   ��֤");
		return flag;
	}
	
	public String getErrorMsg(String key) {
		return this.errors.get(key);
		
	}
}
