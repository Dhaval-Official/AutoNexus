package testMethods;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MethodSet11 {
	

	//S51	
	@Parameters({"Baseurl","UserName"})
	@Test
	public void search2(String url, String name) {
		System.out.println("Iphone 13 pro results");
		System.out.println(url+" "+name);
	}


	//S52	
	@Test(dataProvider="search1TD")
	public void search1(String username, String pwd) {
		System.out.println(username+" "+pwd);	
	}
	
	@DataProvider
	public Object[][] search1TD() {
		
		Object[][] td = new Object[3][2];
		
		td[0][0] = "FirstSetName";
		td[0][1] = "FirstSetPassword";
		
		td[1][0] = "SecondSetName";
		td[1][1] = "SecondSetPassword";
		
		td[2][0] = "ThirdSetName";
		
		
//		System.out.println(); 
		return td;
	}
	
	
}
