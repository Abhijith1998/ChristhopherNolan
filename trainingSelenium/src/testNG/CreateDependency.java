package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateDependency {
	
	@Test()
	public void createAccount() {
		Reporter.log("Account created succesfully", true);
	}
	
	@Test(priority=-1,dependsOnMethods = "createAccount")
	public void editAccount() {
		int i=1/0;
		Reporter.log("Account created succesfully", true);
	}
	
	@Test(priority=-10,dependsOnMethods = {"createAccount","editAccount"})
	public void deleteAccount() {
		Reporter.log("Account created succesfully", true);
	}
}
