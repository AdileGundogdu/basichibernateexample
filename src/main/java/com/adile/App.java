package com.adile;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;


import java.util.Arrays;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Parent parent = new Parent(1,"adile","gundogdu",20);
        parent.setChild(Arrays.asList(
                new Child(2,"busra","irmak",20)
        ));
        session.save(parent);

        session.getTransaction().commit();
        System.out.println("child name" + parent.getChild());
        session.close();
    }
}
