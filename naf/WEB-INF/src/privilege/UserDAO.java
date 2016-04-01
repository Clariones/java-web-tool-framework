package privilege;

import java.util.List;

public interface UserDAO {
	  public int create(String username, String password);
	  public List<User> listUsers();
}


