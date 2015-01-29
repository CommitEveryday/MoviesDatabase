package utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.logging.Logger;
import java.util.logging.Level;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        //фильтруем сообщения в лог от hibernate
//        Logger logger = Logger.getLogger("org.hibernate");
//        logger.setLevel(Level.WARNING);

        try {
            Configuration configuration = new Configuration();
//            configuration.setProperty("hibernate.show_sql", "true");
            configuration.configure("/hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            return configuration.buildSessionFactory(serviceRegistry);
//            return new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().build());
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
