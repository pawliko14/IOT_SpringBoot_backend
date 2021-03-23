package com.fat.SentronEntities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "modbus_historical")
public class Modbus_historical {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable =  false)
    private String variable;

    @Column(nullable =  false)
    private String value;

    @Column(nullable =  false)
    @Temporal(TemporalType.DATE)
    private Date last_date;

    @Column(nullable =  false)
    @Temporal(TemporalType.TIME)
    private Date last_time;




    public Modbus_historical() {

    }

    public Modbus_historical(Long id, String variable, String value, Date last_date, Date last_time) {
        this.id = id;
        this.variable = variable;
        this.value = value;
        this.last_date = last_date;
        this.last_time = last_time;
    }

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

    public Date getLast_date() {
        return last_date;
    }

    public void setLast_date(Date last_date) {
        this.last_date = last_date;
    }

    public Date getLast_time() {
        return last_time;
    }

    public void setLast_time(Date last_time) {
        this.last_time = last_time;
    }

    @Override
    public String toString() {
        return "Modbus_historical{" +
                "id=" + id +
                ", variable='" + variable + '\'' +
                ", value='" + value + '\'' +
                ", last_date='" + last_date + '\'' +
                ", last_time='" + last_time + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modbus_historical that = (Modbus_historical) o;
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
