package interview.hellier.heroku.SpringREST.Service;

import interview.hellier.heroku.SpringREST.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GetUsersInAndWithin50MilesOfLondonService {

    @Autowired
    private GetUsersInLondonService getUsersInLondonService;

    @Autowired
    private GetUsersWithinDistanceOfLondonService getUsersWithinDistanceOfLondonService;


    public List<User> UsersInAndWithin50MilesOfLondon() {

        List<User> milesArray = getUsersWithinDistanceOfLondonService.getUsersWithin50MilesOfLondon(50);

        User[] londonArray = getUsersInLondonService.getUsersInLondon();

        List<User> londonListArray = Arrays.asList(londonArray);

        List<User> combinedList = Stream.of(milesArray, londonListArray)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());

        System.out.println(combinedList);

        return combinedList;
    }
}
