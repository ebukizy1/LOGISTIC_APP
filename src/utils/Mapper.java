package utils;

import data.models.ContactInformation;
import data.models.Package;
import data.models.TrackingInformation;
import dtos.Request.CreatePackageRequest;
import dtos.Response.CreatePackageResponses;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {

    public static void map(CreatePackageRequest createPackageRequest, Package aPackage) {
        ContactInformation senderContact = new ContactInformation();
        ContactInformation receiverContact = new ContactInformation();
        senderContact.setName(createPackageRequest.getSendersName());
        senderContact.setPhoneNumber(createPackageRequest.getSenderPoneNumber());
        aPackage.setSendersContact(senderContact);


        receiverContact.setName(createPackageRequest.getReceiverName());
        receiverContact.setPhoneNumber(createPackageRequest.getReceiverPhoneNumber());
        aPackage.setReceiverNameContact(receiverContact);
    }

    public static void map(CreatePackageResponses createPackageResponses, TrackingInformation trackingInformation, Package savePackage) {
        createPackageResponses.setDescription(savePackage.getDescription());
        createPackageResponses.setTrackingNumber(savePackage.getId()+ "");
        LocalDateTime dateTime = trackingInformation.getDateTime();
        String date = DateTimeFormatter.ofPattern("EEEE, dd/MM,yyyy").format(dateTime);
        String time =  DateTimeFormatter.ofPattern("hh:mm:ss:a").format(dateTime);
        createPackageResponses.setDateCreated(date);
        createPackageResponses.setTimeCreated(time);
    }

}
