package data.repositories;

import data.models.TrackingInformation;

import java.util.ArrayList;
import java.util.List;


public class TrackingInformationImpl implements TrackingInformationRepository{

        private int count = 1;
        private List<TrackingInformation> trackingInformations = new ArrayList<>();
        @Override
        public TrackingInformation save(TrackingInformation trackingInformation) {
            boolean isCorrect = trackingInformation.getId() == 0;
            if(isCorrect) {
                trackingInformations.add(trackingInformation);
                trackingInformation.setId(generateID());
            }
            else trackingInformations.set(generateID()-1, trackingInformation);
            return trackingInformation;
        }

        @Override
        public void delete(TrackingInformation trackingInformation) {
            trackingInformations.remove(trackingInformation);

        }
        private int generateID(){
            return count++;
        }

        @Override
        public void delete(int id) {
            delete(findByID(id));
        }

        @Override
        public long count() {
            return trackingInformations.size();
        }

        @Override
        public TrackingInformation findByID(int id) {
            for (TrackingInformation trackingInformation : trackingInformations) {
                boolean isCorrect = trackingInformation.getId() == id;
                if(isCorrect)return trackingInformation;
            }
            return null;
        }



        @Override
        public List<TrackingInformation> findAll() {
            return trackingInformations;
        }
    }


