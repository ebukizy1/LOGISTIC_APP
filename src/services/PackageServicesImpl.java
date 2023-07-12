package services;

import data.models.Package;
import data.models.TrackingInformation;
import data.repositories.PackageRepository;
import data.repositories.PackageRepositoryImpl;
import dtos.Request.CreatePackageRequest;
import dtos.Request.TrackingInformationRequest;
import dtos.Response.AddTrackingInformationResponse;
import dtos.Response.CreatePackageResponses;
import utils.Converter;
import utils.Mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PackageServicesImpl  implements PackageServices{
    private PackageRepository packageRepository = new PackageRepositoryImpl();
    private TrackingInformationServicesImplement trackingInformationServicesImplement = new TrackingInformationServicesImplement();

    @Override
    public CreatePackageResponses createPackage(CreatePackageRequest createPackageRequest) {
        Package aPackage = new Package();
       Mapper.map(createPackageRequest, aPackage);

        TrackingInformationRequest trackingInformationRequest = new TrackingInformationRequest();
        TrackingInformation trackingInformation =  trackingInformationServicesImplement.saveTrackingInformation(trackingInformationRequest);
        aPackage.getTrackingInformations().add(trackingInformation);
        var savePackage = packageRepository.save(aPackage);

        CreatePackageResponses createPackageResponses = new CreatePackageResponses();
        Mapper.map(createPackageResponses,trackingInformation, savePackage);


        return createPackageResponses;
           
           
        }




    public AddTrackingInformationResponse addTrackingInformation(TrackingInformationRequest trackingInformationRequest){
        TrackingInformation trackingInformation = trackingInformationServicesImplement.saveTrackingInformation(trackingInformationRequest);
        Package foundPackage = packageRepository.findByID(trackingInformation.getId());
        foundPackage.getTrackingInformations().add(trackingInformation);
        Package saveFoundPackage = packageRepository.save(foundPackage);

       AddTrackingInformationResponse addTrackingInformationResponse = new AddTrackingInformationResponse();
       addTrackingInformationResponse.setSetTrackingInformation(String.valueOf(saveFoundPackage.getId()));
        LocalDateTime dateTime = trackingInformation.getDateTime();
        Converter.converter(dateTime, addTrackingInformationResponse);

        return  addTrackingInformationResponse;
    }


    public List<TrackingInformation> trackPackage(int aPackageID){
        Package foundPackage = packageRepository.findByID(aPackageID);
        if(foundPackage == null) throw  new IllegalArgumentException("you do not have a package here");
        return foundPackage.getTrackingInformations();
    }



    @Override
    public long countNumberOfPackage() {
        return packageRepository.count();
    }
}
