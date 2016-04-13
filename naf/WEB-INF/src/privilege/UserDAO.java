package privilege;

import java.util.List;

public interface UserDAO {
	public int create(String username, String password);

	public List<User> listUsers();

	public User getUser(Integer 编号) throws UserNotFoundException;

	public void delete(Integer 编号) throws UserNotFoundException;

	public int deleteAll();

	public void update(Integer 编号, String 密码) throws UserNotFoundException;
}
