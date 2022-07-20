package Sample;

import org.testng.annotations.Test;

public class ProductTest {
		
		@Test
		public void createProductTest() {
			System.out.println("contact Product");
		}
		
		@Test
		public void createProductwithItemTest()
		{
			System.out.print("contact created with Product");
		}
}