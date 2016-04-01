package privilege;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAOJDBCTemplateImpl implements UserDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int create(String username, String password) {
		// TODO Auto-generated method stub
		String SQL = "insert into user_data (id,username, password) values (?, ?, ?)";

		return jdbcTemplateObject.update(SQL, System.currentTimeMillis()%1000, username, password);
		// System.out.println("Created Record Name = " + name + " Age = " +
		// age);
		
	}

	public List<User> listUsers() {
		// TODO Auto-generated method stub

		String SQL = "select * from user_data";
		List<User> students = jdbcTemplateObject.query(SQL, new UserMapper());
		return students;

	}

	public User getUser(Integer id) {
		String SQL = "select * from user_data where id = ?";
		User student = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new UserMapper());
		return student;
	}

	public void delete(Integer id) {
		String SQL = "delete from user_data where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
		return;
	}
	public void deleteAll() {
		String SQL = "delete from user_data ";
		jdbcTemplateObject.update(SQL);
		return;
	}

	public void update(Integer id, Integer password) {
		String SQL = "update user_data set password = ? where id = ?";
		jdbcTemplateObject.update(SQL, password, id);
		System.out.println("Updated Record with ID = " + id);
		return;
	}
//	}

}
