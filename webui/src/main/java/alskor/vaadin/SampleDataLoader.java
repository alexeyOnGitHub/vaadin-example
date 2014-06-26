package alskor.vaadin;

import alskor.vaadin.db.TripManager;
import alskor.vaadin.db.Trip;

public class SampleDataLoader {
    public static void loadSampleData(TripManager manager) {
        manager.save(createDemoTrip("San Francisco", "Berkeley", 50));
        manager.save(createDemoTrip("Foster City", "San Francisco", 70));
        manager.save(createDemoTrip("Foster City", "Daly City", 70));
        manager.save(createDemoTrip("San Francisco", "Daly City", 40));
        manager.save(createDemoTrip("Berkeley", "San Francisco", 55));
    }

    private static Trip createDemoTrip(String from, String finishLocation, float price) {
        Trip trip = new Trip();
        trip.setStartLocation(from);
        trip.setFinishLocation(finishLocation);
        trip.setPrice(price);
        return trip;
    }
}
