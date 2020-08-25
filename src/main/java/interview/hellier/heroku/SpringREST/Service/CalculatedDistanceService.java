package interview.hellier.heroku.SpringREST.Service;

import interview.hellier.heroku.SpringREST.Config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service to calculate the distance between London and the users location
 *
 * Bugs: none known
 *
 * @author       Ashley Hellier
 * @version      SNAPSHOT-0.0.1
 *
 */

@Service
public class CalculatedDistanceService {

    private static final Logger LOG = LoggerFactory.getLogger(CalculatedDistanceService.class);

    /**
     * Method called to calculate the distance between London and the users location, it is called by the
     * GetUsersInAndWithin50MilesOfLondonService
     * @param londonLat, the latitude co-ordinates of London
     * @param londonLon, the longitude co-ordinates of London
     * @param userLat, the latitude co-ordinates of the current location of the user
     * @param userLon, the longitude co-ordinates of the current location of the user
     * @return a double value (distance) between London and the users current location
     */

    public static double distance(double londonLat, double londonLon, double userLat, double userLon) {

        LOG.info("Calculating distance between London and user destination...");

        //convert all to radians
        double londonLatR = Math.toRadians(londonLat);
        double londonLonR = Math.toRadians(londonLon);
        double userLatR = Math.toRadians(userLat);
        double userLonR = Math.toRadians(userLon);

        //calculate the difference between the users location and london
        double diffLatR = userLatR - londonLatR;
        double diffLonR = userLonR - londonLonR;

        double a = Math.pow(Math.sin(diffLatR / 2), 2)
                + Math.pow(Math.sin(diffLonR / 2), 2) * Math.cos(londonLatR)
                * Math.cos(userLatR);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in KM
        double r = 6371;

        // calculate the result
        double calculatedDistanceFromLondonInKM = r * c;

        //convert this to miles
        double calculatedDistanceFromLondonInMiles = calculatedDistanceFromLondonInKM * 0.621371;
        LOG.info("Calculated distance is: " + calculatedDistanceFromLondonInMiles);

        return calculatedDistanceFromLondonInMiles;

    }
}

