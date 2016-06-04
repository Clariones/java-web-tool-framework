import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.lanecrawford.cms.actiontablemeta.ActionTableServiceImpl;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.lineitem.LineItem;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.order.OrderJDBCTemplateDAO;
import com.terapico.b2b.order.OrderNotFoundException;
import com.terapico.b2b.sellercompany.SellerCompany;
import com.terapico.b2btemplate.OrderDAOImpl;
import com.terapico.caf.SpringBeanFactory;

public class SQLGenTest {

	@Test
	public void test() throws Exception {
		//fail("Not yet implemented");
		
		SpringBeanFactory factory=new SpringBeanFactory();
		
		//OrderDAOImpl order=(OrderDAOImpl)factory.getBean("order");
		
		ActionTableServiceImpl service=(ActionTableServiceImpl)factory.getBean("service");
		String s = service.generateSQL("ATM000001");
		System.out.print(s);
		
		
	}
	
	
	

}
