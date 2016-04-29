package privilege;

import java.util.List;

import com.terapico.naf.baseelement.MessageBox;
import com.terapico.naf.spring.SpringBeanFactory;

public class PrivilegeService {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public PrivilegeService() {

	}

	public List<User> 新建用户(String 用户名, String 密码) {
		getUserDAO().create(用户名, 密码);

		return getUserDAO().listUsers();
	}

	public User 找单个用户(Integer 编号) throws UserNotFoundException {
		return getUserDAO().getUser(编号);
	}

	public List<User> 删除用户(Integer 编号) throws UserNotFoundException {
		getUserDAO().delete(编号);

		return getUserDAO().listUsers();
	}

	public Object 删除所有用户(String 输入WYSC以确认你没有喝醉) {
		if (!输入WYSC以确认你没有喝醉.equals("WYSC")) {

			return new MessageBox("危险操作，输入不对，不予执行!");
		}

		int count = getUserDAO().deleteAll();

		return new MessageBox("成功删除" + count + "用户");
	}

	public List<User> 删除多个用户(Integer 编号之间以分号分割[]) throws UserNotFoundException {
		for (Integer id : 编号之间以分号分割) {
			getUserDAO().delete(id);
		}

		return getUserDAO().listUsers();
	}

	public void 更新用户资料(Integer 编号, String 密码) throws UserNotFoundException {
		getUserDAO().update(编号, 密码);
	}

	public List<User> 列出所有用户() {

		return getUserDAO().listUsers();

	}

}
