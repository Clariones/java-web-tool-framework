import static org.junit.Assert.*;

import org.junit.Test;

import com.terapico.b2btemplate.OrderDAOImpl;
import com.terapico.caf.SpringBeanFactory;

public class OrderPerformanceTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		SpringBeanFactory factory=new SpringBeanFactory();
		
		OrderDAOImpl order=(OrderDAOImpl)factory.getBean("order");
		
		while(true){
			order.loadOrder("ORDER000001");
		}
		
	}

}
