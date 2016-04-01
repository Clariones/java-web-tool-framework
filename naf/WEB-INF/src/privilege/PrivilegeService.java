package privilege;

import java.util.List;

import com.terapico.naf.spring.SpringBeanFactory;

import test.MessageBox;

public class PrivilegeService {
	private UserDAOJDBCTemplateImpl impl;

	public PrivilegeService() {

		SpringBeanFactory factory = new SpringBeanFactory();

		impl = (UserDAOJDBCTemplateImpl) factory.getBean("userDAO");

	}

	public List<User> 新建用户(String 用户名, String 密码) {
		impl.create(用户名, 密码);

		return impl.listUsers();
	}

	public User 找单个用户(Integer 编号) {
		return impl.getUser(编号);
	}

	public List<User> 删除用户(Integer 编号) {
		impl.delete(编号);

		return impl.listUsers();
	}

	public Object 删除所有用户(String 请输入WYSC) {
		if(!请输入WYSC.equals("WYSC")){
			
			return new MessageBox("危险操作，输入不对，不予执行!");
		}
		
		
		int count=impl.deleteAll();
		

		return new MessageBox("成功删除"+count+"用户");
	}
	public List<User> 删除多个用户(Integer 编号之间以逗号分割[]) {
		for (Integer id : 编号之间以逗号分割) {
			impl.delete(id);
		}

		return impl.listUsers();
	}

	public void 更新用户资料(Integer 编号, Integer 密码) {
		impl.update(编号, 密码);
	}

	public List<User> 列出所有用户() {
		// TODO Auto-generated method stub

		return impl.listUsers();

	}

}
