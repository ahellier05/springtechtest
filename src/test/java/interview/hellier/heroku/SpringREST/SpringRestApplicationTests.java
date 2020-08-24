package interview.hellier.heroku.SpringREST;

import interview.hellier.heroku.SpringREST.Service.GetOneUserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringRestApplicationTests {

	@Autowired
	private GetOneUserService service;

//	@Test
//	public void getUsersWithin50MilesOfLondon() {
//
//		List<User> miles50Array = client.getUsersWithin50MilesOfLondon();
//
//
//		for(int i = 0; i < miles50Array.size(); i++) {
//			System.out.println("Next User: " + miles50Array.get(i));
//		}
//		System.out.println("TEST SUCCESSFUL");
//	}

}
