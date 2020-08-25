package interview.hellier.heroku.SpringREST.Service;

import interview.hellier.heroku.SpringREST.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class GetUsersInAndWithin50MilesOfLondonServiceTest {

    @Autowired
    private GetUsersInAndWithin50MilesOfLondonService getUsersInAndWithin50MilesOfLondonService;

    @Test
    public void usersInLondonOrWithin50MileRadius() {

        List<User> uInLondonOr50MRadius = getUsersInAndWithin50MilesOfLondonService.UsersInAndWithin50MilesOfLondon();

        assertTrue(uInLondonOr50MRadius.size() > 0);

    }
}
