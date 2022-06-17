package app.sport.workoutlog.model;

public class Trainer {
    private int id;
    private String name;
    private String email;
    private String password;
    private SportKind id_sport_kind;

    public Trainer(){}

    public Trainer(String name, String email, String password, SportKind sportKind){
        this.name = name;
        this.email = email;
        this.password = password;
        this.id_sport_kind = sportKind;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SportKind getSportKind() {
        return id_sport_kind;
    }

    public void setSportKind(SportKind sportKind) {
        this.id_sport_kind = sportKind;
    }

    @Override
    public String toString(){
        return "User:" + "\n" + "ID:" + id + "\n" + "Email:" + email + "\n" + "Password" + password
                + "\n" + "Sport kind" + id_sport_kind;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (!this.getClass().equals(object.getClass())) return false;

        Trainer object2 = (Trainer) object;
        if ((this.id == object2.getId()) && (this.email == object2.getEmail()) &&
                (this.password == object2.getPassword()) && (this.id_sport_kind == object2.getSportKind())
        ) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = email == null ? 0 : email.hashCode();
        result = (29 * result + id);
        result = (29 * result + password).hashCode();
        return result;
    }
}