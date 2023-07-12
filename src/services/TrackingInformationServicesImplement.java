package services;


import data.models.TrackingInformation;
import data.repositories.TrackingInformationImpl;
import data.repositories.TrackingInformationRepository;
import dtos.Request.TrackingInformationRequest;
import dtos.Response.AddTrackingInformationResponse;
import dtos.Response.FindTrackingResponses;
import dtos.Response.TrackingPackageResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TrackingInformationServicesImplement implements TrackingInformationServices {

private TrackingInformationRepository trackingInformationRepository = new TrackingInformationImpl();


    @Override
    public long countNumberOfTrack() {
        return trackingInformationRepository.count();
    }



    @Override
    public TrackingPackageResponse trackPackage(int packageId) {
        return null;
    }


    public TrackingInformation saveTrackingInformation(TrackingInformationRequest trackingInformationRequest) {
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setTrackingNumber(trackingInformation.getTrackingNumber());
        trackingInformation.setDescription("created successfully");
       return trackingInformationRepository.save(trackingInformation);
    }
}
