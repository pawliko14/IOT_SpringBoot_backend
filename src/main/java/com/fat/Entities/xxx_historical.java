package com.fat.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class xxx_historical {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable =  false)
    private String variable;

    @Column(nullable =  false)
    private String value;

    @Column(nullable =  false)
    private String last_date;

    @Column(nullable =  false)
    private String last_time;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLast_date() {
        return last_date;
    }

    public void setLast_date(String last_date) {
        this.last_date = last_date;
    }

    public String getLast_time() {
        return last_time;
    }

    public void setLast_time(String last_time) {
        this.last_time = last_time;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        xxx_historical that = (xxx_historical) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(variable, that.variable) &&
                Objects.equals(value, that.value) &&
                Objects.equals(last_date, that.last_date) &&
                Objects.equals(last_time, that.last_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, variable, value, last_date, last_time);
    }
}
