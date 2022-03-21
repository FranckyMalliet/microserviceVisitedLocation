package microserviceVisitedLocation.services;

import com.google.common.util.concurrent.RateLimiter;
import microserviceVisitedLocation.models.VisitedLocation;
import microserviceVisitedLocation.utilities.SleepUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Service
public class VisitedLocationService {

    private final static Logger logger = LoggerFactory.getLogger(VisitedLocationService.class);
    private static final RateLimiter rateLimiter = RateLimiter.create(10000);
    private final SleepUtilities sleepUtilities = new SleepUtilities();

    /**
     * Using a UUID userID, this method create a visitedLocation object
     * with random longitude and latitude.
     * @param userId
     * @return a visitedLocation object
     */

    public VisitedLocation createVisitedLocation(UUID userId) {
        rateLimiter.acquire();
        this.sleepUtilities.sleep();

        VisitedLocation visitedLocation = new VisitedLocation(userId, generateRandomLatitude(), generateRandomLongitude(), getRandomTime());

        logger.debug("Creating a new VisitedLocation, userId : " + visitedLocation.getUserId()
                + ", latitude : " + visitedLocation.getLatitude()
                + ", longitude : " + visitedLocation.getLongitude()
                + ", time : " + visitedLocation.getTimeVisited());
        return visitedLocation;
    }

    private double generateRandomLongitude() {
        double leftLimit = -180;
        double rightLimit = 180;
        return Math.random() * (rightLimit - leftLimit) + leftLimit;
    }

    private double generateRandomLatitude() {
        double leftLimit = -85.05112878;
        double rightLimit = 85.05112878;
        return Math.random() * (rightLimit - leftLimit) + leftLimit;
    }

    private Date getRandomTime() {
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(new Random().nextInt(30));
        return Date.from(localDateTime.toInstant(ZoneOffset.UTC));
    }
}
