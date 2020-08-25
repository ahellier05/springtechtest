package interview.hellier.heroku.SpringREST.Service;

import interview.hellier.heroku.SpringREST.Config.AppConfig;
import interview.hellier.heroku.SpringREST.Model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service to return an array containing all users that are located within a
 * certain distance of a certain location (in this case- London)
 *
 * Bugs: none known
 *
 * @author       Ashley Hellier
 * @version      SNAPSHOT-0.0.1
 *
 */
@Service
public class GetUsersWithinDistanceOfLondonService {

    private static final Logger LOG = LoggerFactory.getLogger(GetUsersWithinDistanceOfLondonService.class);

    String allUserEndpoint;

    private final double londonLatitude;

    private final double londonLongitude;

    @Autowired
    private GetAllUsersService getAllUsersService;

    @Autowired
    GetUsersWithinDistanceOfLondonService(@Value("${heroku.api.url}")String allUserEndpoint,
                                          @Value("${london.latitude}")double londonLatitude,
                                          @Value("${london.longitude}")double londonLongitude) {
        this.allUserEndpoint = allUserEndpoint;
        this.londonLatitude = londonLatitude;
        this.londonLongitude = londonLongitude;
    }

    /**
     * Returns an arraylist of users with co-ordinates that are 50 miles away from London
     *
     * @param distance
     * @return List<User> listToFilter - arraylist containing results of condition statement
     */

    public List<User> getUsersWithin50MilesOfLondon(final long distance) {

        User[] allUsersToFilter = getAllUsersService.returnAllUsers();

        // Conversion of array to ArrayList using Arrays.asList
        List<User> listToFilter = Arrays.asList(allUsersToFilter);
        System.out.println(listToFilter);

        return listToFilter.stream()
                .parallel() //to iterate over large data set- the results do not need to be in order
                .filter(i -> {
                    try {
                        return CalculatedDistanceService.distance(londonLatitude, londonLongitude, i.getLatitude(), i.getLongitude()) <= distance; //return all users that have locations less than the distance specified
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList());

    }
}
