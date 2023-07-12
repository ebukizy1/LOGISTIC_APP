package data.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TrackingInformation {

    private LocalDateTime dateTime = LocalDateTime.now();
    private String description;
    private int id;
    private int trackingNumber;
    private int packageID;


}
