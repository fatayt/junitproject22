package com.arcane;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day03_C7_JavaFaker {
    //cogunlukla test icin fake data kullaniriz
    // JavaFaker de fake data kullanmak icin olusturulmustur
    // Java fake dependency'i pox.xml eklemistik
    @Test
    public void fakerTest(){
        //1. Faker data type de object olustur
        Faker faker = new Faker();
        //2. Ardindan fake data kullanabiliriz : firstname, lastname, address, city, state, country

        String fName = faker.name().firstName();
        System.out.println(fName);
        String lName =faker.name().lastName();
        System.out.println(lName);
        String fullname = faker.name().fullName();
        System.out.println(fullname);

        //title
        System.out.println(faker.name().title());
        //city
        System.out.println(faker.address().city());

        //state
        System.out.println(faker.address().state());

        //phone number
        System.out.println(faker.phoneNumber().cellPhone());

        //zipcode/ post code
        System.out.println(faker.address().zipCode());

        //rastgele email adresi
        System.out.println(faker.internet().emailAddress());
        //rastgele rakam
        System.out.println(faker.number().digits(12));

        System.out.println(faker.lordOfTheRings().character());
        System.out.println(faker.animal().name());

        System.out.println(faker.avatar().image());

    }

}