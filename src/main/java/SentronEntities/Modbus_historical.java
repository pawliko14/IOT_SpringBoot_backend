package SentronEntities;

import java.util.Objects;

public class Modbus_historical {

    private String variable;
    private String value;
    private String last_date;
    private String last_time;

    public Modbus_historical( String variable, String value, String last_date, String last_time) {

        this.variable = variable;
        this.value = value;
        this.last_date = last_date;
        this.last_time = last_time;
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
    public String toString() {
        return "Modbus_historical{" +
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
        return Objects.equals(variable, that.variable) &&
                Objects.equals(value, that.value) &&
                Objects.equals(last_date, that.last_date) &&
                Objects.equals(last_time, that.last_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variable, value, last_date, last_time);
    }
}
