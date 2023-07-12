package services;

import dtos.Request.CreatePackageRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageServicesImplTest {
    private  PackageServices packageServices;
    private CreatePackageRequest createPackageRequest;
    @BeforeEach
    void StartWith() { packageServices = new PackageServicesImpl();
        createPackageRequest = new CreatePackageRequest();
        createPackageRequest.setDescription("iphone 12");
        createPackageRequest.setSendersName("emmanuel");
        createPackageRequest.setSenderPoneNumber("08141221945");
        createPackageRequest.setReceiverName("mary");
        createPackageRequest.setReceiverPhoneNumber("08141221945");

    }

    @Test
    public void testSaveOnePackage_AndCountIsOne(){
        packageServices.createPackage(createPackageRequest);
        assertEquals(1, packageServices.countNumberOfPackage());


    }

}