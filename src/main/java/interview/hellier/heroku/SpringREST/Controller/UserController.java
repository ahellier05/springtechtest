package interview.hellier.heroku.SpringREST.Controller;

import interview.hellier.heroku.SpringREST.Model.User;
import interview.hellier.heroku.SpringREST.Service.GetAllUsersService;
import interview.hellier.heroku.SpringREST.Service.GetUsersInAndWithin50MilesOfLondonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Controller class for API code using request mappings to expose end points.
 *
 * Bugs: none known
 *
 * @author       Ashley Hellier
 * @version      SNAPSHOT-0.0.1
 *
 */

@RestController
@RequestMapping("/v1/users") //prefix of all requests in this class
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    GetAllUsersService getAllUsersService;

    @Autowired
    GetUsersInAndWithin50MilesOfLondonService getUsersInAndWithin50MilesOfLondonService;

    /**
     * Endpoint for retrieving all users by calling getAllUsersService
     *
     * @return List<User> - Array list of all users in json format
     */
    @GetMapping(value = "/getAllUsers", produces = "application/json") //full uri will be localhost:8080/user/api/getAllUsers
    public List<User> getAllUsers() {


        LOG.info("/getAllUsers endpoint hit");

        User[] allUsersA = getAllUsersService.returnAllUsers();
        List<User> allUsers = Arrays.asList(allUsersA);

        return allUsers;
    }

    /**
     * Endpoint for retrieving users In London or within 50 miles of London by calling
     * getUsersInAndWithin50MilesOfLondonService
     *
     * @return List<User> - Array list of filtered users in json format
     */
    @GetMapping(value = "/getUsersInOrWithin50MilesOfLondon", produces = "application/json")
    public List<User> getFiftyMileUsers() {

        LOG.info("/getUsersInOrWithin50MilesOfLondon hit");

        List<User> fiftyMileUsers = getUsersInAndWithin50MilesOfLondonService.UsersInAndWithin50MilesOfLondon();

        return fiftyMileUsers;
    }

}
