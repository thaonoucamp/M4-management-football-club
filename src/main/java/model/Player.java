package model;

import javax.persistence.*;

@Entity
public class Player {
    @ManyToOne
    private Coach coach;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String address;
    private String image;
    private String location;
    private double height;
    private double weight;
    private double BMI;
    private long salary;
    private long bonus;
    private String status;

}
