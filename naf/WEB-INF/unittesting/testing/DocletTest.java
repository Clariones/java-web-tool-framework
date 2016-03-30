package testing;

import static org.junit.Assert.*;

import org.junit.Test;



class FromNode{
	
	
}
class ToNode{
	public static void disconnect() {
		// TODO Auto-generated method stub
		
	}
	
}
class A extends FromNode{

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	public static void x()
	{
		B.y();
		
		
	}

	public static void z() {
		// TODO Auto-generated method stub
		
	}

}

class B extends ToNode{
	
	public static void y() {
		disconnect();
	}



	void x()
	{
		A.z();
		
	}

}


public class DocletTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	void x()
	{
		
		
	}

}

