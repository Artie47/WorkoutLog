package app.sport.workoutlog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);
        MaterialButton regBtn = findViewById(R.id.signin);
        initializeComponents();

    }
//
    private void initializeComponents() {
        EditText inputEditTextEmail = findViewById(R.id.input_login);
        EditText inputEditTextPassword = findViewById(R.id.input_pas);
        CheckBox is_a_Trainer = findViewById(R.id.is_a_trainer);

        MaterialButton buttonReg = findViewById(R.id.login);
        RetrofitService retrofitService = new RetrofitService();

        is_a_Trainer.setOnClickListener(v ->{
            isChecked = true;
        });

        buttonReg.setOnClickListener(view -> {
            String email = String.valueOf(inputEditTextEmail);
            String password = String.valueOf(inputEditTextPassword);

            if (isChecked) {
                Trainer trainer = new Trainer();
                trainer.setEmail(email);
                trainer.setPassword(password);

                TrainerAPI trainerAPI = retrofitService.getRetrofit().create(TrainerAPI.class);

                trainerAPI.trainerSignIn(trainer).enqueue(new Callback<Trainer>() {
                    @Override
                    public void onResponse(Call<Trainer> call, Response<Trainer> response) {
                        Toast.makeText(Login.this, "Авторизация успешна", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Login.this, Trener.class);
                    }

                    @Override
                    public void onFailure(Call<Trainer> call, Throwable t) {
                        Toast.makeText(Login.this, "Неверные данные!", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "Ошибка обнаружена", t);
                    }
                });
            }
            else {

                UserAPI userAPI = retrofitService.getRetrofit().create(UserAPI.class);
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);

                userAPI.signIn(user).enqueue(new Callback<User>() {
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
            }
        });
    }

    public void Register(View view) {
        Intent i = new Intent(Login.this, Register.class);
        startActivity(i);
    }
}
