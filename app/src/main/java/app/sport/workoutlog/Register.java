package app.sport.workoutlog;

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

public class Register extends AppCompatActivity {

//    private EditText emailTV, passwordTV, nameTV, surnameTV;
//    private Button regBtn;
//
//    private FirebaseAuth mAuth;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_reg);
//
//        mAuth = FirebaseAuth.getInstance();
//
//        initializeUI();
//
//        regBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                registerNewUser();
//            }
//        });
//    }
//
//    private void registerNewUser() {
//
//        String email, password, name, surname;
//        email = emailTV.getText().toString();
//        password = passwordTV.getText().toString();
//        name = nameTV.getText().toString();
//        surname = surnameTV.getText().toString();
//
//        if (TextUtils.isEmpty(email)) {
//            Toast.makeText(getApplicationContext(), "Пожалуйста, введмте email", Toast.LENGTH_LONG).show();
//            return;
//        }
//        if (TextUtils.isEmpty(password)) {
//            Toast.makeText(getApplicationContext(), "Пожалуйста, введите пароль!", Toast.LENGTH_LONG).show();
//            return;
//        }
//        if (TextUtils.isEmpty(name)) {
//            Toast.makeText(getApplicationContext(), "Пожалуйста, введите имя", Toast.LENGTH_LONG).show();
//            return;
//        }
//        if (TextUtils.isEmpty(surname)) {
//            Toast.makeText(getApplicationContext(), "Пожалуйста, введите фамилию", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(getApplicationContext(), "Регистрация успешна!", Toast.LENGTH_LONG).show();
//
//                            Intent intent = new Intent(Register.this, ScheduleActivity.class);
//                            startActivity(intent);
//                        }
//                        else {
//                            Toast.makeText(getApplicationContext(), "Ошибка! Проверьте введенные данные", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//    }
//    private void initializeUI() {
//        emailTV = findViewById(R.id.input_login);
//        passwordTV = findViewById(R.id.input_pas);
//        nameTV = findViewById(R.id.input_name);
//        surnameTV = findViewById(R.id.input_name2);
//        regBtn = findViewById(R.id.sign_in);
//    }
}