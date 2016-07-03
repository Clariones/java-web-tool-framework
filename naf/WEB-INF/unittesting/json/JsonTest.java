package json;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JsonTest {

	@Test
	public void test() {
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule testModule = new SimpleModule("MyModule");
		testModule.addSerializer(new OrderSerializer()); // assuming
															// serializer
															// declares correct
															// class to bind to
		mapper.registerModule(testModule);
	}

}
