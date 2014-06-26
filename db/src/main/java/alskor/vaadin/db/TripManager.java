package alskor.vaadin.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;

public class TripManager {
    private EntityManagerFactory entityManagerFactory;

    public TripManager() {
        initDatabase();
    }

    private void initDatabase() {
        entityManagerFactory = Persistence.createEntityManagerFactory("alskor.vaadin.db.jpa");
    }

    public void save(Trip trip) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(trip);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public Trip get(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Object o = entityManager.find(Trip.class, id);
        return (Trip) o;
    }

    public Collection<Trip> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT e FROM Trip e");
        return (Collection<Trip>) query.getResultList();
    }
}
