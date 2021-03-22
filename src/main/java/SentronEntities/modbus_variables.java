package SentronEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class modbus_variables {


    private Long ID;
    private String val_register;
    private boolean status;
    private int val_offset;
    private String default_unit;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getVal_register() {
        return val_register;
    }

    public void setVal_register(String val_register) {
        this.val_register = val_register;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getVal_offset() {
        return val_offset;
    }

    public void setVal_offset(int val_offset) {
        this.val_offset = val_offset;
    }

    public String getDefault_unit() {
        return default_unit;
    }

    public void setDefault_unit(String default_unit) {
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
