package services;
import data.models.TrackingInformation;
import dtos.Request.CreatePackageRequest;
import dtos.Request.TrackingInformationRequest;
import dtos.Response.AddTrackingInformationResponse;
import dtos.Response.CreatePackageResponses;

import java.util.List;


public interface PackageServices {
    CreatePackageResponses createPackage (CreatePackageRequest createPackageRequest);
    AddTrackingInformationResponse addTrackingInformation(TrackingInformationRequest trackingInformationRequest);
    List<TrackingInformation> trackPackage(int aPackageID);
    long countNumberOfPackage();


}
