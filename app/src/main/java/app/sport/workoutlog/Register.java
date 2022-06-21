package app.sport.workoutlog;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import app.sport.workoutlog.localDB.AppDatabase;
import app.sport.workoutlog.localDB.UserLocal;
import app.sport.workoutlog.model.User;
import app.sport.workoutlog.retrofit.RetrofitService;
import app.sport.workoutlog.retrofit.UserAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    private  UserAPI userAPI;
    private AppDatabase db;
    public static UserLocal userData;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        initializeComponents();

    }

    public void onPutSettings(String email){
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putString("credSetKey", email);
        e.apply();
    }

    public String onShowSettings()
    {
        String ret = sharedPreferences.getString("credSetKey", " ");
        return ret;
    }

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context),
                getDefaultSharedPreferencesMode());
    }

    private static String getDefaultSharedPreferencesName(Context context) {
        return context.getPackageName() + "_preferences";
    }

    private static int getDefaultSharedPreferencesMode() {
        return Context.MODE_PRIVATE;
    }



//    public static UserLocal getUser(Context context){
//        AppDatabase db = AppDatabase.getInstance(context);
//        final UserLocal[] userData = new UserLocal[1];
//        db.userDao().getUser(MainActivity.ID_USER)
//                .observeOn(Schedulers.io())
//                .subscribe(user -> userData[0] = user);
//        return userData[0];
//    }

private void initializeComponents() {
    EditText inputEditTextName = findViewById(R.id.input_name);
    EditText inputEditTextDate = findViewById(R.id.input_date);
    EditText inputEditTextEmail = findViewById(R.id.input_login);
    EditText inputEditTextPassword = findViewById(R.id.input_pas);

    MaterialButton buttonReg = findViewById(R.id.sign_in);

    buttonReg.setOnClickListener(view -> {
        String name = String.valueOf(inputEditTextName);
        String email = String.valueOf(inputEditTextEmail);
        String password = String.valueOf(inputEditTextPassword);
        String date_string = String.valueOf(inputEditTextDate);
        int id_group = 1;

        RetrofitService retrofitService = new RetrofitService();
        userAPI = retrofitService.getRetrofit().create(UserAPI.class);

        User user = new User(name, email,password, date_string, id_group);

        userData = new UserLocal(name, email, password, date_string, Integer.toString(id_group));


        userAPI.signUp(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {

                onPutSettings(user.getEmail());
                
                Toast.makeText(Register.this, "Регистрация успешна!", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Register.this, ScheduleActivity.class);
                startActivity(i);
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                Toast.makeText(Register.this, "Возникла ошибка при регистрации!", Toast.LENGTH_SHORT).show();
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, "Ошибка обнаружена", t);
            }
        });
    });
}}