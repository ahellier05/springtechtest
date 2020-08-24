package interview.hellier.heroku.SpringREST.Service;

import interview.hellier.heroku.SpringREST.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetOneUserTestServiceTest {

    @Autowired
    private GetOneUserService getOneUserService;

    @Test
    public void getOneUser() {
        User users = getOneUserService.getOneSpecifiedUser();
        System.out.println("ID is: " + users.getId());
        System.out.println("First Name:  " + users.getFirst_name());
        System.out.println("Last Name: " + users.getLast_name());
        System.out.println("Email Address: " + users.getEmail());
        System.out.println("IP Address: " + users.getIp_address());
        System.out.println("TEST SUCCESSFUL");

    }

}
