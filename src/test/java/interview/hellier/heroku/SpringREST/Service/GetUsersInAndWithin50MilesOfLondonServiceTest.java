package interview.hellier.heroku.SpringREST.Service;

import interview.hellier.heroku.SpringREST.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class GetUsersInAndWithin50MilesOfLondonServiceTest {

    @Autowired
    private GetUsersInAndWithin50MilesOfLondonService getUsersInAndWithin50MilesOfLondonService;

    @Autowired
    private GetUsersWithinDistanceOfLondonService getUsersWithinDistanceOfLondonService;

    @Autowired
    private GetUsersInLondonService getUsersInLondonService;

    @Test
    public void usersInLondonOrWithin50MileRadius() {

        User[] fiftyMileAOne = getUsersInLondonService.getUsersInLondon();
        List<User> fiftyMileArrayOne = Arrays.asList(fiftyMileAOne);

        List<User> fiftyMileArrayTwo = getUsersWithinDistanceOfLondonService.getUsersWithin50MilesOfLondon(50);

        List<User> combinedList = Stream.of(fiftyMileArrayOne, fiftyMileArrayTwo)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());

        System.out.println("USERS IN OR LESS THAN 50 MILES AWAY FROM LONDON: " + combinedList);
        System.out.println("AMOUNT OF USERS IN OR LESS THAN 50 MILES AWAY FROM LONDON: " + combinedList.size());
    }
}
