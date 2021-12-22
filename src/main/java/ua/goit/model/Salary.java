/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 21.12.2021
 */

package ua.goit.model;

import ua.goit.dao.to_interface.Identity;

import java.util.Objects;

public class Salary implements Identity {

    private String projectName;
    private Double sumSalary;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Double getSumSalary() {
        return sumSalary;
    }

    public void setSumSalary(Double sumSalary) {
        this.sumSalary = sumSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return Objects.equals(projectName, salary.projectName) && Objects.equals(sumSalary, salary.sumSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, sumSalary);
    }

    @Override
    public String toString() {
        return "Salary{" +
                "projectName='" + projectName + '\'' +
                ", sumSalary=" + sumSalary +
                '}';
    }

    @Override
    public Long getId() {
        return null;
    }
}
