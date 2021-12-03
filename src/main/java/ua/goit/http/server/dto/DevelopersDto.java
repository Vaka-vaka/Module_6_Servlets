/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 25.11.2021
 */

package ua.goit.http.server.dto;

public class DevelopersDto {

    private Long id;
    private String name_;
    private Long age;
    private String gender;
    private int salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
