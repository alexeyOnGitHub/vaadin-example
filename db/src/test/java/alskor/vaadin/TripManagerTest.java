package alskor.vaadin;

import alskor.vaadin.db.Trip;
import alskor.vaadin.db.TrainManager;
import org.junit.Test;

import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TripManagerTest {
    @Test
    public void tripAdded() {
        TrainManager manager = new TrainManager();
        Trip trip = new Trip();
        trip.setStartLocation("SF");
        trip.setFinishLocation("Berkeley");
        manager.save(trip);

        Collection<Trip> trains = manager.getAll();
        assertEquals(1, trains.size());
        Trip onlyTrain = trains.iterator().next();
        assertThat(onlyTrain.getStartLocation()).isEqualTo("SF");
    }
}
