package interview.hellier.heroku.SpringREST.Controller;

import interview.hellier.heroku.SpringREST.Model.User;
import interview.hellier.heroku.SpringREST.Service.GetAllUsersService;
import interview.hellier.heroku.SpringREST.Service.GetUsersInAndWithin50MilesOfLondonService;
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

    @Autowired
    GetUsersInAndWithin50MilesOfLondonService getUsersInAndWithin50MilesOfLondonService;

    @GetMapping(value = "/getAllUsers", produces = "application/json")
    public List<User> getAllUsers() {

        User[] allUsersA = getAllUsersService.returnAllUsers();
        List<User> allUsers = Arrays.asList(allUsersA);

        return allUsers;
    }

    @GetMapping(value = "/getUsersInOrWithin50Miles", produces = "application/json")
    public List<User> getFiftyMileUsers() {
        List<User> fiftyMileUsers = getUsersInAndWithin50MilesOfLondonService.UsersInAndWithin50MilesOfLondon();

        return fiftyMileUsers;
    }


}
