package app.sport.workoutlog.localDB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

import app.sport.workoutlog.MainActivity;


@Entity(tableName = "Users")
public class UserLocal {
    public static volatile String ID_USER;
    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "password")
    private String password;
    @ColumnInfo(name = "date_of_reg")
    private String date_of_reg;
    @ColumnInfo(name = "id_group")
    private String id_group;

    public UserLocal(){this.id = UUID.randomUUID().toString();}

    public UserLocal(String userName, String email, String password, String date_of_reg, String id_group) {
        this.id = UUID.randomUUID().toString();
        this.name = userName;
        this.email = email;
        this.password =password;
        this.date_of_reg = date_of_reg;
        this.id_group = id_group;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(String id){this.id = id;}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDate_of_reg() {
        return date_of_reg;
    }

    public String getId_group() {
        return id_group;
    }

    public String getSportkind() {
        return "волейбол";
    }

    public String  getNextLesson() {
        return "12/11/2002";
    }

    public String getNextPayData() {
        return  "19/06/2022";
    }

    public String getTaxPrice() {
        return "200$";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate_of_reg(String date_of_reg) {
        this.date_of_reg = date_of_reg;
    }

    public void setId_group(String id_group) {
        this.id_group = id_group;
    }
}
