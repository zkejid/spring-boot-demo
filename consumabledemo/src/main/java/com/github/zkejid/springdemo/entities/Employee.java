package com.github.zkejid.springdemo.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Employee entity. Represents person, employed on a certain period of time.
 * <p/>
 * Entity has custom equality algorithm: two employee instances are equal if and only if
 * all instance fields are equal 'side by side'.
 */
@Entity
public class Employee {

    protected Employee() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    /**
     * Person name in free form
     */
    private String name;
    /**
     * Person grade during given period of time
     */
    private String grade;
    /**
     * Date, person was hired.
     */
    private Date hiredDate;
    /**
     * Date, person was fired.
     */
    private Date firedDate;

    public Employee(String name, String grade, Date hiredDate, Date firedDate) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public Date getFiredDate() {
        return firedDate;
    }

    public void setFiredDate(Date firedDate) {
        this.firedDate = firedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (grade != null ? !grade.equals(employee.grade) : employee.grade != null) return false;
        if (hiredDate != null ? !hiredDate.equals(employee.hiredDate) : employee.hiredDate != null) return false;
        return firedDate != null ? firedDate.equals(employee.firedDate) : employee.firedDate == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (hiredDate != null ? hiredDate.hashCode() : 0);
        result = 31 * result + (firedDate != null ? firedDate.hashCode() : 0);
        return result;
    }
}