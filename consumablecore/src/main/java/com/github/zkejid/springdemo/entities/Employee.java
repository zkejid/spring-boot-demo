package com.github.zkejid.springdemo.entities;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;

/**
 * Employee entity. Represents person, employed on a certain period of time.
 * <p/>
 * Entity has custom equality algorithm: two employee instances are equal if and only if
 * all instance fields are equal 'side by side'.
 */
@Entity
public class Employee extends AbstractPersistable<Long>{
    /**
     * Person name in free form
     */
    private String name;
    /**
     * Person position during given period of time
     */
    private String position;
    /**
     * Date, person was hired.
     */
    private Date hiredDate;
    /**
     * Date, person was fired.
     */
    private Date firedDate;
    /**
     * Salary of the person. Use {@link BigDecimal} instead of {@link Long}
     * due rounding errors.
     * TODO Panfilov I.V. 12.08.17: check rounding issues
     */
    private BigDecimal salary;

    protected Employee() {}

    public Employee(String name, String position, Date hiredDate, Date firedDate, BigDecimal salary) {
        this.name = name;
        this.position = position;
        this.hiredDate = hiredDate;
        this.firedDate = firedDate;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}