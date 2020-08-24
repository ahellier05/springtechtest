package interview.hellier.heroku.SpringREST.Service;

import interview.hellier.heroku.SpringREST.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetUsersWithinDistanceOfLondonService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GetUsersWithinDistanceOfLondonService getUsersWithinDistanceOfLondonService;

    @Autowired
    private GetAllUsersService getAllUsersService;

    @Value("${heroku.api.url}")
    String allUserEndpoint;

    private final double londonLatitude;

    private final double londonLongitude;

    @Autowired
    GetUsersWithinDistanceOfLondonService(final RestTemplate restTemplate,
                                          @Value("${heroku.api.url}")String allUserEndpoint,
                                          @Value("${london.latitude}")double londonLatitude,
                                          @Value("${london.longitude}")double londonLongitude) {
        this.restTemplate = restTemplate;
        this.allUserEndpoint = allUserEndpoint;
        this.londonLatitude = londonLatitude;
        this.londonLongitude = londonLongitude;
    }

    public List<User> getUsersWithin50MilesOfLondon(final long distance) {

        User[] allUsersToFilter = getAllUsersService.returnAllUsers();

        // Conversion of array to ArrayList
        // using Arrays.asList
        List<User> listToFilter = Arrays.asList(allUsersToFilter);
        System.out.println(listToFilter);


        ArrayList<User> filteredUserList = new ArrayList<User>();

        return listToFilter.stream()
                .parallel() //to iterate over large data set- the results do not need to be in order
                .filter(i -> CalculatedDistanceService.distance(londonLatitude, londonLongitude, i.getLatitude(), i.getLongitude()) <= distance)
                .collect(Collectors.toList());

    }
}
