package data.repositories;

import data.models.TrackingInformation;

import java.util.List;

public interface TrackingInformationRepository {
    TrackingInformation save (TrackingInformation trackingInformation);
    void delete(TrackingInformation trackingInformation);
    void  delete(int id );
    long count();
    TrackingInformation findByID(int id);
    List<TrackingInformation> findAll();

}
