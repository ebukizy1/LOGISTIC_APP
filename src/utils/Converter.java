package utils;

import dtos.Response.AddTrackingInformationResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Converter {


    public static void converter(LocalDateTime dateTime, AddTrackingInformationResponse addTrackingInformationResponse) {
        String date = DateTimeFormatter.ofPattern("EEEE, dd/MM,yyyy").format(dateTime);
        String time =  DateTimeFormatter.ofPattern("hh:mm:ss:a").format(dateTime);
        addTrackingInformationResponse.setSetDateEntered(date);
        addTrackingInformationResponse.setTimeEntered(time);
    }

}
