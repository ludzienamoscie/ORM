package main.java;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args){
        EntityManager entityManager= Persistence.createEntityManagerFactory("CINEMA")
                .createEntityManager();
    }
}