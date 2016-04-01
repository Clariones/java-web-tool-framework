package privilege;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User student = new User();
		student.setId(rs.getInt("id"));
		student.setUsername(rs.getString("username"));
		student.setPassword(rs.getString("password"));
		return student;
	}
	
}

