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

    public Player() {
    }

    public Player(Coach coach, Long id, String name, int age, String address, String image, String location, double height, double weight, double BMI, long salary, long bonus, String status) {
        this.coach = coach;
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.image = image;
        this.location = location;
        this.height = height;
        this.weight = weight;
        this.BMI = BMI;
        this.salary = salary;
        this.bonus = bonus;
        this.status = status;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getBonus() {
        return bonus;
    }

    public void setBonus(long bonus) {
        this.bonus = bonus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
