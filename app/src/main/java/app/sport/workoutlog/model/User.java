package app.sport.workoutlog.model;

public class User{
    private int id;
    private String name;
    private String email;
    private String password;
    private String date_of_reg;
    private int id_group;

    public User(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
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
    public String getDate_of_reg() {
        return date_of_reg;
    }
    public void setDate_of_reg(String date_of_reg) {
        this.date_of_reg = date_of_reg;
    }
    public int getGroup(){
        return  id_group;
    }
    public void setId_group(int group){
        this.id_group = group;
    }

}