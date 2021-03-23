package com.fat.sqlObjects;

import java.util.Objects;

public class object_variables {

    private String ID;
    private String Last_changed_time;
    private String Status;
    private String Var;
    private String last_changed_date;
    private String Var_meaning;
    private String Value;
    private String Var_path;

    public object_variables(String ID, String last_changed_time, String status, String var, String last_changed_date, String var_meaning, String value, String var_path ) {
        this.ID = ID;
        Last_changed_time = last_changed_time;
        Status = status;
        Var = var;
        this.last_changed_date = last_changed_date;
        Var_meaning = var_meaning;
        Value = value;
        Var_path = var_path;
    }

    public object_variables() {

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLast_changed_time() {
        return Last_changed_time;
    }

    public void setLast_changed_time(String last_changed_time) {
        Last_changed_time = last_changed_time;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getVar() {
        return Var;
    }

    public void setVar(String var) {
        Var = var;
    }

    public String getLast_changed_date() {
        return last_changed_date;
    }

    public void setLast_changed_date(String last_changed_date) {
        this.last_changed_date = last_changed_date;
    }

    public String getVar_meaning() {
        return Var_meaning;
    }

    public void setVar_meaning(String var_meaning) {
        Var_meaning = var_meaning;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getVar_path() {
        return Var_path;
    }

    public void setVar_path(String var_path) {
        Var_path = var_path;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        object_variables that = (object_variables) o;
        return Objects.equals(ID, that.ID) &&
                Objects.equals(Last_changed_time, that.Last_changed_time) &&
                Objects.equals(Status, that.Status) &&
                Objects.equals(Var, that.Var) &&
                Objects.equals(last_changed_date, that.last_changed_date) &&
                Objects.equals(Var_meaning, that.Var_meaning) &&
                Objects.equals(Value, that.Value) &&
                Objects.equals(Var_path, that.Var_path) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Last_changed_time, Status, Var, last_changed_date, Var_meaning, Value, Var_path);
    }
}
