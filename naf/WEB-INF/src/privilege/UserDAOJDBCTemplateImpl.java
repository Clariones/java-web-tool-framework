package privilege;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAOJDBCTemplateImpl implements UserDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);

		jdbcTemplateObject.setFetchSize(1000);
	}

	public int create(String username, String password) {
		// TODO Auto-generated method stub
		String SQL = "insert into user_data (id,username, password,version) values (?, ?, ?,1)";

		return jdbcTemplateObject.update(SQL, getNextId(), username, password);
		// System.out.println("Created Record Name = " + name + " Age = " +
		// age);

	}
	
	//String.format(od.getObjName().toUpperCase()+"%06d",cc)
	static final String ID_FORMAT="USER%06d"; 
	protected String getNextId()
	{
		
		try {
			String SQL = "select max(id) from user_data";
			String maxId = jdbcTemplateObject.queryForObject(SQL, String.class);
			if(maxId==null){
				return  String.format(ID_FORMAT,1);
			}
			
			Object ret[]=parse(maxId);
			
			return String.format(ID_FORMAT,((Long)ret[1]+1));
			
			//return  String.format(ID_FORMAT,1);
			//return student;
		} catch (EmptyResultDataAccessException e) {
			return  String.format(ID_FORMAT,1);
		}
	}

	public List<User> listUsers() {
		// TODO Auto-generated method stub

		String SQL = "select * from user_data limit 1000";
		List<User> students = jdbcTemplateObject.query(SQL, new UserMapper());
		return students;

	}
	public List<User> listUsersWithGroup() {
		// TODO Auto-generated method stub

		String SQL = "select * from user_data limit 1000";
		List<User> students = listUsers();
		return students;

	}

	public User getUser(String id) throws UserNotFoundException {
		try {
			String SQL = "select * from user_data where id = ?";
			User student = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new UserMapper());
			return student;
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException("找不到ID为: " + id + " 的用户");
		}

	}

	public void delete(String id) throws UserNotFoundException {

		try {
			String SQL = "delete from user_data where id = ?";
			jdbcTemplateObject.update(SQL, id);
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException("找不到ID为: " + id + " 的用户");
		}

		System.out.println("Deleted Record with ID = " + id);
		return;
	}

	static boolean inCloseCharRang(char test, char start, char end) {
		if (test < start) {
			return false;
		}
		if (test > end) {
			return false;
		}
		return true;
	}

	static Object[] parse(String maxId) {
		
		if(maxId==null){
			return new Object[]{"USER",1L};
		}
		
		Object ret[] = new Object[2];
		StringBuilder prefixBuffer = new StringBuilder();
		StringBuilder numberBuffer = new StringBuilder();

		char[] chs = maxId.toCharArray();
		for (char ch : chs) {
			
			if(inCloseCharRang(ch,'A','Z')){
				prefixBuffer.append(ch);
				continue;
			}
			if(inCloseCharRang(ch,'a','z')){
				prefixBuffer.append(ch);
				continue;
			}
			if(inCloseCharRang(ch,'0','9')){
				numberBuffer.append(ch);
				continue;
			}

		}
		ret[0] = prefixBuffer.toString();
		String numberExpr=numberBuffer.toString();
		if(numberExpr.isEmpty()){
			ret[1] = 0L;
			return ret;
		}
		
		ret[1] = Long.parseLong(numberExpr);
		return ret;

	}

	public static void main(String[] args) {

		String x = "USER000001";
		Object ret[]=parse(x);
		System.out.println(ret[0]);
		System.out.println(ret[1]);

		
		
	}

	public int deleteAll() {
		String SQL = "delete from user_data";
		return jdbcTemplateObject.update(SQL);
	}
	protected int getVersion(String id){
		int version=jdbcTemplateObject.queryForObject("select version from user_data where id=?",Integer.class,id);
		return version;
	}
	public void updatePassword(String id, String password, int version) throws UserNotFoundException {
		try {
			String SQL = "update user_data set password = ? , version=version+1 where id = ? and version=?";
			int updated=jdbcTemplateObject.update(SQL, password, id,version);
			if(updated<1){
				int currentVersion = getVersion(id);
				throw new UserNotFoundException("ID为: " + id + " 的用户, 现在的版本已经是: "+ currentVersion);
			}
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException("找不到ID为: " + id + " 的用户");
		}
		// System.out.println("Updated Record with ID = " + id);
		return;
	}
	// }

	public void updatePassword(String id, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			String SQL = "update user_data set password = ?  where id = ? ";
			jdbcTemplateObject.update(SQL, password, id);

		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException("找不到ID为: " + id + " 的用户");
		}
		// System.out.println("Updated Record with ID = " + id);
		return;
	}

}
