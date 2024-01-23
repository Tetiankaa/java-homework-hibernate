package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.DriverManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //використовуючи hibernate:
        //- створити табличку Word (id, value)
        //- наповнити її
        //- дістати всі value слів та запакувати в List .

 //Створити клас Car з полями:
        //id
        //model,
        //Type (ENUM)
        //power,
        //price,
        //year.

        try (StandardServiceRegistry serviceRegistryBuilder = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build()){

            Metadata metadata = new MetadataSources(serviceRegistryBuilder)
                    .addAnnotatedClass(Word.class)
                    .addAnnotatedClass(Car.class)
                    .getMetadataBuilder()
                    .build();

            try (SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
                 Session session = sessionFactory.openSession()
            ){
                session.beginTransaction();

//                 Word word1 = new Word();
//                 word1.setValue("java");
//
//                Word word2 = new Word();
//                word2.setValue("python");
//
//                Word word3 = new Word();
//                word3.setValue("react");
//
//                session.persist(word1);
//                session.persist(word2);
//                session.persist(word3);

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

                session.persist(car1);
                session.persist(car2);
                 session.getTransaction().commit();

                List<Word> words = session.createNativeQuery("select * from word", Word.class).list();
                System.out.println(words);

                List<Car> cars = session.createNativeQuery("select * from cars", Car.class).list();
                System.out.println(cars);

            }
        }

    }

}