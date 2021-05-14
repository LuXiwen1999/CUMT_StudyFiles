package Bean;
import java.util.HashMap;
import java.util.Map;
public class info {
	private String ID;
	private String password;
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
	public String getErrorMsg(String key) {
		return this.errors.get(key);
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public boolean isValidate() {
		boolean flag = true;
		System.out.println("����Bean,��ʼ��֤");
		if(!this.ID.matches("\\w{6,15}")) {
			flag = false;
			this.ID="";
			this.errors.put("errID","�û�����6~15λ��ĸ������");
		}
		if(!this.password.matches("\\w{6,15}")) {
			flag = false;
			this.password = "";
			this.errors.put("errpass","������6~15λ��ĸ������");
		}
		System.out.println("����Bean,����   ��֤");
		return flag;
	}
}
