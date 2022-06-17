package app.sport.workoutlog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.logging.Level;
import java.util.logging.Logger;

import app.sport.workoutlog.model.User;
import app.sport.workoutlog.retrofit.RetrofitService;
import app.sport.workoutlog.retrofit.UserAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);
        MaterialButton regBtn = findViewById(R.id.signin);
        //initializeComponents();

    }

    private void initializeComponents() {
        EditText inputEditTextEmail = findViewById(R.id.input_login);
        EditText inputEditTextPassword = findViewById(R.id.input_pas);

        MaterialButton buttonReg = findViewById(R.id.sign_in);

        RetrofitService retrofitService = new RetrofitService();
        UserAPI userAPI = retrofitService.getRetrofit().create(UserAPI.class);

        buttonReg.setOnClickListener(view -> {
            String email = String.valueOf(inputEditTextEmail);
            String password = String.valueOf(inputEditTextPassword);

            User user = new User();
            user.setEmail(email);
            user.setPassword(password);

            userAPI.check(user).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Toast.makeText(Login.this, "Авторизация успешна!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, PersonalAccount.class);
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(Login.this, "Неверные данные!", Toast.LENGTH_SHORT).show();
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