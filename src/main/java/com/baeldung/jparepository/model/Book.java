package com.baeldung.jparepository.model;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    // data jpa pagal nutylejima naudoja AUTO strategy, tada Hibernate pasirenka arba IDENTITY, arba SEQUENCE strategy pagal duomenu bazes bruozus,
    // musu atveju SEQUENCE strategy yra pasirinkta su allocationSize = 50, todel databazeje musu ID padideja 50.
    // priezastis, kodel allocationSize uzset'intas 50 yra todel, nes tai pagerina atlikima, nes db maziau kartu reikia fetch'inti data.
    // Tiek IDENTITY, tiek SEQUENCE veikia. Skiriasi tik tuo, kad SEQUENCE reikia labiau apsirasyti
     @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
//    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
    private Long id;
    private String name;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
