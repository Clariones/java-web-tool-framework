package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBaseTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		 AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring.xml");
		 
		 System.out.println(ctx.getBean("firstObject"));
		 
		 for(String name:ctx.getBeanDefinitionNames()){
			 System.out.println(name);
			 System.out.println(ctx.getBean(name).getClass());
		 }
		
		 
	}
	
	@Test
	public void testParameter() {
		//fail("Not yet implemented");
		
		 
		
		 
	}
	
	

}
