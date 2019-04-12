/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w11;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 *
 * @author eyvind
 */
public class W11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Person p=new Person();
        p.setAddress("Lofotengatan 32");
        p.setName("Johan Hult");
        W11 n=new W11();
        n.persist(p);
        p=new Person();
        p.setAddress("Lofotengatan 33");
        p.setName("Greta Nilsson");
  n.persist(p);
        

    }
    
    void persist(Object object)
    {
    EntityManagerFactory ef=Persistence.createEntityManagerFactory("W11PU");
    EntityManager em=ef.createEntityManager();
    em.getTransaction().begin();
    try{
    em.persist(object);
    em.getTransaction().commit();
    }
    catch(Exception e)
    {
    em.getTransaction().rollback();
    }
    finally{
    em.close();
    }
    
    
    }
    
}
