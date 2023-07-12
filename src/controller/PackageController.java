package controller;

import data.models.TrackingInformation;
import dtos.Request.CreatePackageRequest;
import dtos.Request.TrackingInformationRequest;
import dtos.Response.AddTrackingInformationResponse;
import dtos.Response.CreatePackageResponses;
import services.PackageServices;
import services.PackageServicesImpl;

import java.util.List;


public class PackageController {

    PackageServices packageServices = new PackageServicesImpl();

    
    public CreatePackageResponses createPackage (CreatePackageRequest request){
        return packageServices.createPackage(request);
    }

    public AddTrackingInformationResponse addTrackingInformation (TrackingInformationRequest request){
        return packageServices.addTrackingInformation(request);
    }
    public List<TrackingInformation> trackPackage (int packageId){
        return packageServices.trackPackage(packageId);
    }

}
