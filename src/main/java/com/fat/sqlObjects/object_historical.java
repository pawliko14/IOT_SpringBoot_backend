package com.fat.sqlObjects;

import java.util.Objects;

public class object_historical {

    private String Variable;
    private String Value;
    private String Last_date;
    private String Last_time;


    public object_historical(String variable, String value, String last_date, String last_time) {
        Variable = variable;
        Value = value;
        Last_date = last_date;
        Last_time = last_time;
    }

    public String getVariable() {
        return Variable;
    }

    public void setVariable(String variable) {
        Variable = variable;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getLast_date() {
        return Last_date;
    }

    public void setLast_date(String last_date) {
        Last_date = last_date;
    }

    public String getLast_time() {
        return Last_time;
    }

    public void setLast_time(String last_time) {
        Last_time = last_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        object_historical that = (object_historical) o;
        return Objects.equals(Variable, that.Variable) &&
                Objects.equals(Value, that.Value) &&
                Objects.equals(Last_date, that.Last_date) &&
                Objects.equals(Last_time, that.Last_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Variable, Value, Last_date, Last_time);
    }
}
