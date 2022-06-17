package app.sport.workoutlog.model;

import java.util.Date;

public class Schedule {

    private int id;
    private Date date;
    private Date start_time;
    private Date finish_time;
    private Group id_group;
    private SportKind id_sportkind;
    private Trainer id_trainer;

    public Schedule(){}

    public Schedule(Date date, Date start_time, Date finish_time, Group group, SportKind sportKind, Trainer trainer){
        this.date = date;
        this.start_time =start_time;
        this.finish_time = finish_time;
        this.id_sportkind = sportKind;
        this.id_group = group;
        this.id_trainer = trainer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getStartTime() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getFinishTime() {
        return finish_time;
    }

    public void setFinish_time(Date finish_time) {
        this.finish_time = finish_time;
    }

    public Group getId_group() {
        return id_group;
    }

    public void setId_group(Group group) {
        this.id_group= group;
    }

    public SportKind getId_sportkind(){ return id_sportkind; }

    public void setId_sportkind(SportKind sportKind){ this.id_sportkind = sportKind; }

    public Trainer getId_trainer(){ return id_trainer; }

    public void setId_trainer(Trainer trainer){ this.id_trainer = trainer; }

    /*@Override
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
    }*/

}