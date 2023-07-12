package data.models;
//
//import jdk.internal.util.xml.impl.Pair;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Package {
    private int id;
    private String description;
    private ContactInformation sendersContact;
    private ContactInformation receiverNameContact;

    private List<TrackingInformation> trackingInformations = new ArrayList<>();



    @Override
    public boolean equals(Object o) {
        if (o instanceof Package casted)
   return   casted.id == this.id;
        return false;
    }

}
