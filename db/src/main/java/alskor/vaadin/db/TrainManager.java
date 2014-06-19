package alskor.vaadin.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Collection;
import java.util.List;

public class TrainManager {
    private SessionFactory sessionFactory;

    public TrainManager()    {
        initDatabase();
    }

    private void initDatabase() {
        // A SessionFactory is set up once for an application
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        sessionFactory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory(serviceRegistry);
    }


    public void save(Trip trip) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(trip);
        session.getTransaction().commit();
        session.close();
    }

    public Trip get(long id) {
        Session session = sessionFactory.openSession();
        Object o = session.get(Trip.class, id);
        return (Trip) o;

    }

    public Collection<Trip> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Trip").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
