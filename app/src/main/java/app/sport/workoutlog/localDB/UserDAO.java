package app.sport.workoutlog.localDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


@Dao
public interface UserDAO {

    @Query("SELECT * FROM Users WHERE id = :id")
    UserLocal getUser(String id);

    @Insert
    void insert(UserLocal user);

    @Query("DELETE FROM Users")
    void deleteAllUsers();
}
