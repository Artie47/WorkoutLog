package app.sport.workoutlog;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import app.sport.workoutlog.model.User;
import app.sport.workoutlog.retrofit.RetrofitService;
import app.sport.workoutlog.retrofit.UserAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);
        MaterialButton regBtn = findViewById(R.id.signin);
        //initializeComponents();



    }

    private void initializeComponents() {
        @SuppressLint("WrongViewCast")
        TextInputEditText inputEditTextName = findViewById(R.id.input_name);
        @SuppressLint("WrongViewCast")
        TextInputEditText inputEditTextDate = findViewById(R.id.input_date);
        @SuppressLint("WrongViewCast")
        TextInputEditText inputEditTextEmail = findViewById(R.id.input_login);
        @SuppressLint("WrongViewCast")
        TextInputEditText inputEditTextPassword = findViewById(R.id.input_pas);
        @SuppressLint("WrongViewCast")
        TextInputEditText inputEditTextGroup = findViewById(R.id.spinner);

        MaterialButton buttonReg = findViewById(R.id.sign_in);

        RetrofitService retrofitService = new RetrofitService();
        UserAPI userAPI = retrofitService.getRetrofit().create(UserAPI.class);

        buttonReg.setOnClickListener(view -> {
            String name = String.valueOf(inputEditTextName);
            String email = String.valueOf(inputEditTextEmail);
            String password = String.valueOf(inputEditTextPassword);
            String date_string = String.valueOf(inputEditTextDate);
            String id_group = String.valueOf(inputEditTextGroup);

            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
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

            userAPI.save(user).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Toast.makeText(Login.this, "Регистрация успешна!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(Login.this, "Возникла ошмбка при регистрации!", Toast.LENGTH_SHORT).show();
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "Ошибка обнаружена", t);
                }
            });
        });
    }


    public void Register(View view) {
        Intent i = new Intent(Login.this, Register.class);
        startActivity(i);
    }
}