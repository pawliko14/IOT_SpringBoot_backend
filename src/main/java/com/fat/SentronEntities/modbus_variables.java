package com.fat.SentronEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class modbus_variables {

    @Id
    @GeneratedValue
    private Long ID;

    @Column(nullable =  false)
    private String val_register;

    @Column(nullable =  false)
    private boolean status;

    @Column(nullable =  false)
    private int val_offset;

    @Column(nullable =  false)
    private String default_unit;


    public modbus_variables(Long ID, String val_register, boolean status, int val_offset, String default_unit) {

        this.ID = ID;
        this.val_register = val_register;
        this.status = status;
        this.val_offset = val_offset;
        this.default_unit = default_unit;
    }

    @Override
    public String toString() {
        return "modbus_variables{" +
                "ID=" + ID +
                ", val_register='" + val_register + '\'' +
                ", status=" + status +
                ", val_offset=" + val_offset +
                ", default_unit='" + default_unit + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        modbus_variables that = (modbus_variables) o;
        return status == that.status &&
                val_offset == that.val_offset &&
                Objects.equals(ID, that.ID) &&
                Objects.equals(val_register, that.val_register) &&
                Objects.equals(default_unit, that.default_unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, val_register, status, val_offset, default_unit);
    }
}
