package app.sport.workoutlog.localDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import app.sport.workoutlog.dao.UserDAO;
import app.sport.workoutlog.model.User;

@Database(entities = {User.class /*, AnotherEntityType.class, AThirdEntityType.class */}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO getUserDAO();
}
