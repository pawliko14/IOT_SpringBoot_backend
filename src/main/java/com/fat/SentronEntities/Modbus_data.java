package com.fat.SentronEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Modbus_data {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable =  false)
    private String last_changed_time;

    @Column(nullable =  false)
    private String var;

    @Column(nullable =  false)
    private String last_changed_date;

    @Column(nullable =  false)
    private String value;


    public Modbus_data(){

    }

    public Modbus_data(long id, String last_changed_time, String var, String last_changed_date, String value) {
        this.id = id;
        this.last_changed_time = last_changed_time;
        this.var = var;
        this.last_changed_date = last_changed_date;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLast_changed_time() {
        return last_changed_time;
    }

    public void setLast_changed_time(String last_changed_time) {
        this.last_changed_time = last_changed_time;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getLast_changed_date() {
        return last_changed_date;
    }

    public void setLast_changed_date(String last_changed_date) {
        this.last_changed_date = last_changed_date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Modbus_data{" +
                "id=" + id +
                ", last_changed_time='" + last_changed_time + '\'' +
                ", var='" + var + '\'' +
                ", last_changed_date='" + last_changed_date + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modbus_data that = (Modbus_data) o;
        return id == that.id &&
                Objects.equals(last_changed_time, that.last_changed_time) &&
                Objects.equals(var, that.var) &&
                Objects.equals(last_changed_date, that.last_changed_date) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, last_changed_time, var, last_changed_date, value);
    }
}
