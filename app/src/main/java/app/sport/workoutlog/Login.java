package app.sport.workoutlog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.logging.Level;
import java.util.logging.Logger;

import app.sport.workoutlog.model.Trainer;
import app.sport.workoutlog.model.User;
import app.sport.workoutlog.retrofit.RetrofitService;
import app.sport.workoutlog.retrofit.TrainerAPI;
import app.sport.workoutlog.retrofit.UserAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends AppCompatActivity {

    private Boolean isChecked= false;
    private SharedPreferences sharedPreferences;
    private RetrofitService retrofitService = new RetrofitService();
    private UserAPI userAPI = retrofitService.getRetrofit().create(UserAPI.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);
        MaterialButton regBtn = findViewById(R.id.login);
        initializeComponents();

    }

    public void onPutSettings(String email) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putString("credSetKey", email);
        e.apply();
    }
//
    private void initializeComponents() {
        EditText inputEditTextEmail = findViewById(R.id.input_login);
        EditText inputEditTextPassword = findViewById(R.id.input_pas);

        MaterialButton buttonReg = findViewById(R.id.login);
        RetrofitService retrofitService = new RetrofitService();


        buttonReg.setOnClickListener(view -> {
            String email = String.valueOf(inputEditTextEmail);
            String password = String.valueOf(inputEditTextPassword);

            buttonReg.setOnClickListener(v -> {

                    User user = new User();
                    user.setEmail(email);
                    user.setPassword(password);
                    userAPI.signIn(user).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {

                            Toast.makeText(Login.this, "Авторизация успешна!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Login.this, PersonalAccount.class);
                            startActivity(i);
                        }

                        @Override
                        public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                            Toast.makeText(Login.this, "Возникла ошибка при авторизации!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, "Ошибка обнаружена", t);
                        }
                    });

            });
        });
    }







    public void Register(View view) {
        Intent i = new Intent(Login.this, Register.class);
        startActivity(i);
    }
}
