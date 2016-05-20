package privilege;

import java.util.List;

public interface UserDAO {
	public int create(String username, String password);

	public List<User> listUsers();

	public User getUser(String 编号) throws UserNotFoundException;

	public void delete(String 编号) throws UserNotFoundException;

	public int deleteAll();

	public void updatePassword(String 编号, String 密码, int version) throws UserNotFoundException;
}
