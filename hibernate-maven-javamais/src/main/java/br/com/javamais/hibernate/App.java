package br.com.javamais.hibernate;

import br.com.javamais.hibernate.entities.Pessoa;
import br.com.javamais.hibernate.utils.HibernateUtil;
import org.hibernate.Session;

 
public class App {
    
    
    public static void main( String[] args ){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Javamais");

        session.save(pessoa);
        session.getTransaction().commit();
        
        
    }
}
