package com.jai.practice;

import com.jai.practice.hibernate.dto.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class HibernateMain
{
    public static void main(String[] args)
    {
        Address address = new Address();
        address.setCity("fbd");
        address.setPincode(121001);
        address.setStreet("NIT-5");
        address.setState("HRY");

        Address address1 = new Address();
        address1.setCity("del");
        address1.setPincode(111001);
        address1.setStreet("Sar-5");
        address1.setState("DEL");

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Bike");

        Set<Address> addresses = new HashSet<>();
        addresses.add(address);
        addresses.add(address1);

        UserDetails user = new UserDetails();
        user.setUserName("First User");
        user.setUserAddresses(addresses);
        user.setJoinedDate(new Date());
        user.setDescription("User Description!!");
        user.setVehicle(vehicle);

        /*UserDetails user1 = new UserDetails();
        Address address1 = new Address();
        address1.setCity("del");
        address1.setPincode(111001);
        address1.setStreet("Sar-5");
        address1.setState("DEL");
        user1.setUserName("Second User");
        user1.setUserAddress(address1);
        user1.setCompanyAddress(address1);
        user1.setJoinedDate(new Date());
        user1.setDescription("User2 Description!!");*/


        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Car");

        TwoWheeler twoWheeler = new TwoWheeler();
        twoWheeler.setVehicleName("Bike");
        twoWheeler.setSteeringHandle("Bike Steering Handle");

        FourWheeler fourWheeler = new FourWheeler();
        fourWheeler.setVehicleName("Porsche");
        fourWheeler.setSteeringWheel("Porsche Steering Wheel");

        SessionFactory sessionFactory = null;
        Session session = null;

        try
        {
            sessionFactory = new Configuration().configure(new File("hibernate.cfg.xml")).buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(user);
            session.save(vehicle1);
            session.save(twoWheeler);
            session.save(fourWheeler);
            //session.save(vehicle);  /*** Using Cascade*/
            //session.save(user1);

            Query query = session.getNamedQuery("UserDetails.byId");
            //query.setInteger("userId", 1);
            query.setParameter("userId", 1);
            System.out.println(query.list().size());


            Criteria criteria = session.createCriteria(UserDetails.class);
            criteria.add(Restrictions.eq("userName", "First User"));
            System.out.println("Criteria : "+criteria.list().size());

            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }

        /*user = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
        user =  session.get(UserDetails.class, 1);
        session.close();

        System.out.println("User Fetched from UserDetails: " + user.getUserName());
        System.out.println(user.getUserAddresses().size());*/

    }
}
