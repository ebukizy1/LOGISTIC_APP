package services;

import dtos.Request.TrackingInformationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackingInformationServicesImplementTest {
    private TrackingInformationServices trackingInformationServices;
    @BeforeEach
    void startWith(){ trackingInformationServices = new TrackingInformationServicesImplement();
    }
    @Test
    public void testTrackingInformationIsNotNull(){
    assertNotNull(trackingInformationServices);
    }
    @Test
    public void testAddTrackingInformation_AndCountIsOne(){
        TrackingInformationRequest trackingInformationRequest = new TrackingInformationRequest();
        trackingInformationRequest.setTrackingNo(12);
        trackingInformationRequest.setDescription(" indomie");
        trackingInformationServices.addTrackingInformation(trackingInformationRequest);
        assertEquals(1, trackingInformationServices.countNumberOfTrack());
    }

}