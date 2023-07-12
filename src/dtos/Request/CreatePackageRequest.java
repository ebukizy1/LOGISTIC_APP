package dtos.Request;

import data.repositories.PackageRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePackageRequest {
    private String description;
    private String sendersName;
    private String senderPoneNumber;
    private String receiverName;
    private String receiverPhoneNumber;
    private String receiverCountry;
    private String receiverCity;
    private String postalCode;
    private String homeAddress;


}
