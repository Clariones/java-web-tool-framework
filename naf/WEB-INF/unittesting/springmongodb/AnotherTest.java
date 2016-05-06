package springmongodb;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class AnotherTest {
	@Test
	public void testURL() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new ClassPathResource("springmongodb/spring-mongo.xml").getPath());
		PersonRepo personRepo = context.getBean(PersonRepo.class);
		AddressRepo addressRepo = context.getBean(AddressRepo.class);

		Person personAchilles = new Person();
		personAchilles.setPersonId(1l);
		personAchilles.setName("Achilles");
		personRepo.save(personAchilles);
		Person personHektor = new Person();
		personHektor.setPersonId(2l);
		personHektor.setName("Hektor");

		Address address = new Address(1, "221b Baker Street", "London NW1", "London", 12345l);
		List<Address> addresses = personHektor.getAddresses();
		addresses.add(address);
		personAchilles.setAddresses(addresses);

		addressRepo.save(address);
		personRepo.save(personHektor);

		Iterable<Person> personList = personRepo.findAll();
		System.out.println("Person List : ");
		for (Person person : personList) {
			System.out.println(person);
		}

		System.out.println("Person Record with name Hektor  is " + personRepo.searchByName("Hektor"));

		context.close();
		// System.out.println(getObjectExpr(org));

	}
}
