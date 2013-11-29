
package br.com.javamais.hibernate.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil{
    
    private final static SessionFactory sessionFactory;
    private final static ServiceRegistryBuilder serviceRegistryBuilder;
    private final static ServiceRegistry serviceRegistry;
    
    
    static
      {
        
        try {

            Configuration configuration = new Configuration().configure();
           
            serviceRegistryBuilder = new ServiceRegistryBuilder();
           
            serviceRegistryBuilder.applySettings(configuration.getProperties());

            serviceRegistry = serviceRegistryBuilder.buildServiceRegistry();
 
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        catch (HibernateException he){
            System.err.println("Error creating Session: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    } 
    
    
}