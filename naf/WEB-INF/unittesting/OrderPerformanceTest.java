import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.lineitem.LineItem;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.order.OrderJDBCTemplateDAO;
import com.terapico.b2b.order.OrderNotFoundException;
import com.terapico.b2b.sellercompany.SellerCompany;
import com.terapico.b2btemplate.OrderDAOImpl;
import com.terapico.caf.SpringBeanFactory;

public class OrderPerformanceTest {

	
	public void test() {
		//fail("Not yet implemented");
		
		SpringBeanFactory factory=new SpringBeanFactory();
		
		OrderDAOImpl order=(OrderDAOImpl)factory.getBean("order");
		
		/*
		Order o=order.loadOrder("O000001");
		System.out.print(o.toString());
		*/
		OrderJDBCTemplateDAO gorder=(OrderJDBCTemplateDAO)factory.getBean("orderDAO");
		
		
		
		
	}
	
	public void test1() throws Exception {
		//fail("Not yet implemented");
		
		SpringBeanFactory factory=new SpringBeanFactory();
		
		
		
		OrderJDBCTemplateDAO gorder=(OrderJDBCTemplateDAO)factory.getBean("orderDAO");
		
		System.out.println(gorder);
		Map<String,Object> options= new HashMap<String, Object>();
		//options.add("lineItemList");
		System.out.println(System.currentTimeMillis());
		
		for(int i=0;i<10000;i++){
			Order order = gorder.load("O000001", options);
				
		}
		System.out.println(System.currentTimeMillis());
		
		//System.out.println(order.toString());
		//System.out.println(order.getLineItemList());
	}
	
	public void test2() throws Exception {
		//fail("Not yet implemented");
		
		SpringBeanFactory factory=new SpringBeanFactory();
		
		
		
		OrderJDBCTemplateDAO gorder=(OrderJDBCTemplateDAO)factory.getBean("gorder");
		
		System.out.println(gorder);
		Map<String,Object> options= new HashMap<String, Object>();
		//options.add("lineItemList");
		System.out.println(System.currentTimeMillis());
		
		Order order=gorder.load("O000001", options);
		
		order.setTitle("No title");
		order.setType("quote");
		gorder.save(order, options);
		
		System.out.println(System.currentTimeMillis());
		
		//System.out.println(order.toString());
		//System.out.println(order.getLineItemList());
	}
	
	//@Test
	public void testDelete() throws Exception {
		//fail("Not yet implemented");
		
		SpringBeanFactory factory=new SpringBeanFactory();
		
		
		
		OrderJDBCTemplateDAO gorder=(OrderJDBCTemplateDAO)factory.getBean("orderDAO");
		
		System.out.println(gorder);
		Map<String,Object> options= new HashMap<String, Object>();
		//options.add("lineItemList");
		System.out.println(System.currentTimeMillis());
		
		gorder.delete("O000011",10);
		
		
		
		//System.out.println(order.toString());
		//System.out.println(order.getLineItemList());
	}
	
	
	
	@Test
	public void testClone() throws Exception {
		//fail("Not yet implemented");
		
		SpringBeanFactory factory=new SpringBeanFactory();
		
		
		
		OrderJDBCTemplateDAO gorder=(OrderJDBCTemplateDAO)factory.getBean("orderDAO");
		
		System.out.println(gorder);
		Map<String,Object> options= new HashMap<String, Object>();
		options.put("__all__","");
		System.out.println(System.currentTimeMillis());
		
		//gorder.delete("O000011",10);
		
		
		Order order = gorder.clone("O000003", options);
		
		
		
		
		System.out.println(order.toString());
		//System.out.println(order.getLineItemList());
	}
	

}
