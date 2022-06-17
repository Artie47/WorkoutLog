package app.sport.workoutlog.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import app.sport.workoutlog.model.User;

@Dao
public interface UserDAO {

    @Insert
    public void insert(User... user);

    @Delete
    public  void delete(User user);

    @Query("SELECT * FROM userProfile WHERE id = :id")
    User getDetails(int id);
}
