package microserviceVisitedLocation.controllers;

import microserviceVisitedLocation.models.VisitedLocation;
import microserviceVisitedLocation.services.VisitedLocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class VisitedLocationController {

    private VisitedLocationService visitedLocationService;

    public VisitedLocationController(VisitedLocationService visitedLocationService){
        this.visitedLocationService = visitedLocationService;
    }

    @GetMapping(value = "/createVisitedLocation")
    public VisitedLocation createVisitedLocation(@RequestParam("userId") UUID userId){
        return visitedLocationService.createVisitedLocation(userId);
    }
}
