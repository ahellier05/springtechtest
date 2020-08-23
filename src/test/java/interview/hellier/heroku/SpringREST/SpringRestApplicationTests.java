package interview.hellier.heroku.SpringREST;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.io.FileInputStream;
import java.util.Arrays;

@SpringBootTest
class SpringRestApplicationTests {

	@Autowired
	public HerokuRestClient client;

	@Test
	public void getOneUser() {
		User users = client.getOneUser();
		System.out.println("ID is: " + users.getId());
		System.out.println("First Name:  " + users.getFirst_name());
		System.out.println("Last Name: " + users.getLast_name());
		System.out.println("Email Address: " + users.getEmail());
		System.out.println("IP Address: " + users.getIp_address());

	}

	@Test
	public void getAllUsers() {
		User[] userArray = client.returnAllUsers();
		//System.out.println("All Users Returned: " + Arrays.toString(userArray));
		for (int i = 0; i > userArray.length; i++) {
			System.out.println("All Users Returned: " + userArray[i]);
		}
		assertTrue(userArray.length == 1000);
		
	}

}
