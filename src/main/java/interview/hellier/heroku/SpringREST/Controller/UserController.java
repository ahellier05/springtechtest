package interview.hellier.heroku.SpringREST.Controller;

import interview.hellier.heroku.SpringREST.Model.User;
import interview.hellier.heroku.SpringREST.Service.GetAllUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/user/api")
public class UserController {

    @Autowired
    GetAllUsersService getAllUsersService;

    @GetMapping(value = "/getAllUsers", produces = "application/json")
    public List<User> getAllUsers() {

        User[] allUsersA = getAllUsersService.returnAllUsers();
        List<User> allUsers = Arrays.asList(allUsersA);

        return allUsers;
    }


}
