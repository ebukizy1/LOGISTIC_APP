package services;

import dtos.Response.AddTrackingInformationResponse;
import dtos.Request.TrackingInformationRequest;
import dtos.Response.FindTrackingResponses;
import dtos.Response.TrackingPackageResponse;

public interface TrackingInformationServices {

    long countNumberOfTrack();
    TrackingPackageResponse trackPackage(int packageId);

}
