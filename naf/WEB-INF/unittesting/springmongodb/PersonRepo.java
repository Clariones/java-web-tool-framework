package springmongodb;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepo extends CrudRepository<Person, Long>
{
		@Query("{'name' : ?0}")
		public Iterable<Person> searchByName(String personName);

}
