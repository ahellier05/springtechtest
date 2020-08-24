package interview.hellier.heroku.SpringREST.Service;

import org.springframework.stereotype.Service;

@Service
public class CalculatedDistanceService {

    public static double distance(double londonLat, double londonLon, double userLat, double userLon) {

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

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        double calculatedDistanceFromLondonInKM = 6371 * c;

        //convert this to miles
        double calculatedDistanceFromLondonInMiles = calculatedDistanceFromLondonInKM * 0.621371;
        System.out.println(calculatedDistanceFromLondonInMiles);

        return calculatedDistanceFromLondonInMiles;

    }
}

