package app.sport.workoutlog;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import app.sport.workoutlog.model.Group;
import app.sport.workoutlog.model.User;
import app.sport.workoutlog.retrofit.RetrofitService;
import app.sport.workoutlog.retrofit.UserAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    private  UserAPI userAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);



        initializeComponents();

    }

private void initializeComponents() {
    EditText inputEditTextName = findViewById(R.id.input_name);
    EditText inputEditTextDate = findViewById(R.id.input_date);
    EditText inputEditTextEmail = findViewById(R.id.input_login);
    EditText inputEditTextPassword = findViewById(R.id.input_pas);

    MaterialButton buttonReg = findViewById(R.id.sign_in);

    RetrofitService retrofitService = new RetrofitService();
    userAPI = retrofitService.getRetrofit().create(UserAPI.class);

    buttonReg.setOnClickListener(view -> {
        String name = String.valueOf(inputEditTextName);
        String email = String.valueOf(inputEditTextEmail);
        String password = String.valueOf(inputEditTextPassword);
        String date_string = String.valueOf(inputEditTextDate);

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date_of_reg = null;
        try {
            date_of_reg = (Date) formatter.parse(date_string);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setDate_of_reg(date_of_reg);
        user.setGroup(1);

        userAPI.save(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                Toast.makeText(Register.this, "Регистрация успешна!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                Toast.makeText(Register.this, "Возникла ошибка при регистрации!", Toast.LENGTH_SHORT).show();
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, "Ошибка обнаружена", t);
            }
        });
    });
}}