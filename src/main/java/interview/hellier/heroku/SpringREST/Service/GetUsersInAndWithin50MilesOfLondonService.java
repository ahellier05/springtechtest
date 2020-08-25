package interview.hellier.heroku.SpringREST.Service;
import interview.hellier.heroku.SpringREST.Config.AppConfig;
import interview.hellier.heroku.SpringREST.Model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Service to return an array containing all users that are within 50 miles of London or who
 * are listed as living in London, this class uses and combines two separate API calls
 * - GetUsersInLondonService
 * - GetUsersWithinDistanceOfLondonService
 *
 * Bugs: none known
 *
 * @author       Ashley Hellier
 * @version      SNAPSHOT-0.0.1
 *
 */
@Service
public class GetUsersInAndWithin50MilesOfLondonService {

    private static final Logger LOG = LoggerFactory.getLogger(GetUsersInAndWithin50MilesOfLondonService.class);

    @Autowired
    private GetUsersInLondonService getUsersInLondonService;

    @Autowired
    private GetUsersWithinDistanceOfLondonService getUsersWithinDistanceOfLondonService;

    long distance;

    @Autowired
    GetUsersInAndWithin50MilesOfLondonService(@Value("${distance.london}")long distance) {
        this.distance = distance;
    }

    /**
     * Returns an arraylist which is the combined result of two API calls in this method
     *
     * @return List<User> combined list
     * @params 50 - distance passed into getUsersWithin50MilesOfLondon
     *
     */
    public List<User> UsersInAndWithin50MilesOfLondon() {

        //first api call
        List<User> milesArray = getUsersWithinDistanceOfLondonService.getUsersWithin50MilesOfLondon(distance);

        //second api call
        User[] londonArray = getUsersInLondonService.getUsersInLondon();

        //convert array to arraylist
        List<User> londonListArray = Arrays.asList(londonArray);

        //use stream api to combine lists
        List<User> combinedList = Stream.of(milesArray, londonListArray)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());

        return combinedList;
    }
}
