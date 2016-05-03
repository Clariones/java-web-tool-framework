package privilege;

import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAOJDBCTemplateImpl implements UserDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
		
		jdbcTemplateObject.setFetchSize(100);
	}

	public int create(String username, String password) {
		// TODO Auto-generated method stub
		String SQL = "insert into user_data (id,username, password) values (?, ?, ?)";
		
		
		return jdbcTemplateObject.update(SQL,  UUID.randomUUID().toString(), username,password);
		// System.out.println("Created Record Name = " + name + " Age = " +
		// age);

	}

	
	public List<User> listUsers() {
		// TODO Auto-generated method stub

		String SQL = "select * from user_data limit 1000";
		List<User> students = jdbcTemplateObject.query(SQL, new UserMapper());
		return students;

	}

	public User getUser(Integer id) throws UserNotFoundException {
		try {
			String SQL = "select * from user_data where id = ?";
			User student = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new UserMapper());
			return student;
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException("找不到ID为: "+id+" 的用户");
		}

		
	}

	public void delete(Integer id) throws UserNotFoundException {

		try {
			String SQL = "delete from user_data where id = ?";
			jdbcTemplateObject.update(SQL, id);
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException("找不到ID为: "+id+" 的用户");
		}

		System.out.println("Deleted Record with ID = " + id);
		return;
	}

	public int deleteAll() {
		String SQL = "delete from user_data";
		return jdbcTemplateObject.update(SQL);
	}

	public void update(Integer id, String password) throws UserNotFoundException {
		try {
			String SQL = "update user_data set password = ? where id = ?";
			jdbcTemplateObject.update(SQL, password, id);

		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException("找不到ID为: "+id+" 的用户");
		}
		// System.out.println("Updated Record with ID = " + id);
		return;
	}
	// }

}
