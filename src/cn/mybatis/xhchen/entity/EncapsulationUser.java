package cn.mybatis.xhchen.entity;

/**
 * 
 * ClassName: EncapsulationUser
 * 
 * @Description: ��װUserʵ���࣬����POJO
 * @author XHChen
 * @date 2018��10��8�� ����11:37:30
 */
public class EncapsulationUser {

	private int id;

	private String username;

	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EncapsulationUser [id=" + id + ", username=" + username
				+ ", password=" + password + "]";
	}

}
