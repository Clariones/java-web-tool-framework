package testing;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysTest {

	@Test
	public void test() {
		Object [] org={"1","2","3","4"};
		
		Object [] news=Arrays.copyOfRange(org, 2, 4);
		
		for(Object o:news){
			System.out.println(o);
		}
		
	}

}
