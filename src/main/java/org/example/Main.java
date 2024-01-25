package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try(StandardServiceRegistry registryBuilder = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build()
            ){

            Metadata metadata = new MetadataSources(registryBuilder)
                    .addAnnotatedClass(Car.class)
                    .addAnnotatedClass(DriverLicense.class)
                    .addAnnotatedClass(Owner.class)
                    .getMetadataBuilder()
                    .build();

            try(SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
                Session session = sessionFactory.openSession();
            ) {
                session.beginTransaction();

                DriverLicense license1 = new DriverLicense();
                DriverLicense license2 = new DriverLicense();
                DriverLicense license3 = new DriverLicense();
                license1.setSeries("AAA111");
                license2.setSeries("BBB000");
                license3.setSeries("TTT159");

                Car car1 = new Car();
                car1.setModel("Ford");
                car1.setType(Type.SUV);
                car1.setPower(300);
                car1.setPrice(40000);
                car1.setYear(2022);

                Car car2 = new Car();
                car2.setModel("BMW");
                car2.setType(Type.SEDAN);
                car2.setPower(250);
                car2.setPrice(45000);
                car2.setYear(2023);

                Car car3 = new Car();
                car3.setModel("Toyota");
                car3.setType(Type.PICK_UP);
                car3.setPower(270);
                car3.setPrice(35000);
                car3.setYear(2021);

                Car car4 = new Car();
                car4.setModel("Honda");
                car4.setType(Type.MINIVAN);
                car4.setPower(280);
                car4.setPrice(38000);
                car4.setYear(2023);

                Car car5 = new Car();
                car5.setModel("Porshe");
                car5.setType(Type.SPORTS);
                car5.setPower(450);
                car5.setPrice(100000);
                car5.setYear(2023);

                List<Car> cars1 = new ArrayList<>();
                cars1.add(car1);
                cars1.add(car4);

                List<Car> cars2 = new ArrayList<>();
                cars2.add(car2);
                cars2.add(car5);

                List<Car> cars3 = new ArrayList<>();
                cars3.add(car3);


                Owner owner1 = new Owner();
                owner1.setName("Tetiana");
                owner1.setDriverLicense(license1);
                owner1.setCars(cars1);

                Owner owner2 = new Owner();
                owner2.setName("Stas");
                owner2.setDriverLicense(license2);
                owner2.setCars(cars2);

                Owner owner3 = new Owner();
                owner3.setName("Oksana");
                owner3.setDriverLicense(license3);
                owner3.setCars(cars3);

                session.persist(owner1);
                session.persist(owner2);
                session.persist(owner3);


                session.getTransaction().commit();
            }
        }
    }
}