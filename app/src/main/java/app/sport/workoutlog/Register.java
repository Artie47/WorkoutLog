package app.sport.workoutlog;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import app.sport.workoutlog.localDB.AppDatabase;
import app.sport.workoutlog.localDB.UserLocal;
import app.sport.workoutlog.model.Group;
import app.sport.workoutlog.model.User;
import app.sport.workoutlog.retrofit.RetrofitService;
import app.sport.workoutlog.retrofit.UserAPI;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    public static UserLocal userData;
    private SharedPreferences sharedPreferences;
    private RetrofitService retrofitService = new RetrofitService();
    private UserAPI userAPI = retrofitService.getRetrofit().create(UserAPI.class);
    private Boolean isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        initializeComponents();

    }

    public void onPutSettings(String email) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putString("credSetKey", email);
        e.apply();
    }

    public String onShowSettings() {
        return sharedPreferences.getString("credSetKey", " ");
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

    public void getGroupsToSpinner(Context context, List<String> groups, Spinner spinner) {
        ArrayAdapter<String> adapterCategoryFilterSpinner = new
                ArrayAdapter<String>(
                context,
                android.R.layout.simple_spinner_item,
                groups
        );
        adapterCategoryFilterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterCategoryFilterSpinner);
    }

    public void getAllGroups(Context context, Spinner spinner) {
        userAPI.getAllGroups().enqueue(new Callback<List<String>>() {
                                           @Override
                                           public void onResponse(@NonNull Call<List<String>> call, @NonNull Response<List<String>> response) {
                                               getGroupsToSpinner(context, response.body(), spinner);
                                           }

                                           @Override
                                           public void onFailure(@NonNull Call<List<String>> call, @NonNull Throwable t) {
                                               Toast.makeText(Register.this, "Возникла ошибка при связи с сервером!", Toast.LENGTH_SHORT).show();
                                           }
                                       }
        );
    }


    private void initializeComponents() {
        EditText inputEditTextName = findViewById(R.id.input_name);
        EditText inputEditTextDate = findViewById(R.id.input_date);
        EditText inputEditTextEmail = findViewById(R.id.input_login);
        EditText inputEditTextPassword = findViewById(R.id.input_pas);
        Spinner inputSpinnerGroup = findViewById(R.id.input_group);
        getAllGroups(this, inputSpinnerGroup);

        MaterialButton buttonReg = findViewById(R.id.sign_in);

        buttonReg.setOnClickListener(
                v -> {
                    String name = String.valueOf(inputEditTextName.getText());
                    String email = String.valueOf(inputEditTextEmail.getText());
                    String password = String.valueOf(inputEditTextPassword.getText());
                    String date_string = String.valueOf(inputEditTextDate.getText());

                    User user = new User();
                    user.setName(name);
                    user.setEmail(email);
                    user.setPassword(Encoder.md5Custom(password));
                    user.setDate_of_reg(date_string);


                    userAPI.getGroupId((String) inputSpinnerGroup.getSelectedItem())
                            .enqueue(new Callback<Integer>() {
                                @Override
                                public void onResponse(@NonNull Call<Integer> call, @NonNull Response<Integer> response) {
                                    int id_group = 1;
                                    user.setId_group(id_group);
                                }

                                @Override
                                public void onFailure(@NonNull Call<Integer> call, @NonNull Throwable t) {
                                }
                            });

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
                }
        );


    }
}
