package sqlObjects;

public class GateBounce {

    private String action;
    private String date;

   public GateBounce(String a , String d)
    {
        this.action =a;
        this.date = d;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
