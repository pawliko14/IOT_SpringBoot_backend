package sqlObjects;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

import java.util.List;
import java.util.Objects;

public class UserHistory {

    private String nazwisko_imie;
    private String hacofostnumber;
    private String id_number;
    private String stanowisko;
    private String firma;
    private String Creation_date;
    private List<GateBounce> bounceList;


    public String getNazwisko_imie() {
        return nazwisko_imie;
    }

    public String getHacofostnumber() {
        return hacofostnumber;
    }

    public String getId_number() {
        return id_number;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public String getFirma() {
        return firma;
    }

    public String getCreation_date() {
        return Creation_date;
    }

    public List<GateBounce> getBounceList() {
        return bounceList;
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "nazwisko_imie='" + nazwisko_imie + '\'' +
                ", hacofostnumber='" + hacofostnumber + '\'' +
                ", id_number='" + id_number + '\'' +
                ", stanowisko='" + stanowisko + '\'' +
                ", firma='" + firma + '\'' +
                ", Creation_date='" + Creation_date + '\'' +
                ", bounceList=" + bounceList +
                '}';
    }

    public static final class Builder {
        private String nazwisko_imie;
        private String hacofostnumber;
        private String id_number;
        private String stanowisko;
        private String firma;
        private String Creation_date;
        private List<GateBounce> bounceList;

        public Builder nazwisko_imie(String name) {
            this.nazwisko_imie = name;
            return  this;
        }

        public Builder hacofostnumber(String haco) {
            this.hacofostnumber = haco;
            return this;
        }

        public Builder id_number(String id) {
            this.id_number = id;
            return this;
        }

        public Builder stanowisko(String stan) {
            this.stanowisko = stan;
            return this;
        }

        public Builder firma(String firma) {
            this.firma = firma;
            return this;
        }

        public Builder Creation_date(String creation) {
            this.Creation_date = creation;
            return this;
        }

        public Builder bounceList(List<GateBounce> list) {
            this.bounceList = list;
            return this;
        }

        public UserHistory build() {
            if(nazwisko_imie.isEmpty()) {
                throw new IllegalStateException("name cannot be empty");
            }
            if(bounceList.isEmpty()) {
                throw new IllegalStateException("list of bounces cannot be empty");
            }

            UserHistory user = new UserHistory();
                user.nazwisko_imie = this.nazwisko_imie;
                user.hacofostnumber = this.hacofostnumber;
                user.id_number = this.id_number;
                user.stanowisko = this.stanowisko;
                user.firma = this.firma;
                user.Creation_date = this.Creation_date;
                user.bounceList  = this.bounceList;


            return user;
        }


    }



}
