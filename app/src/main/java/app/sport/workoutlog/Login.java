package app.sport.workoutlog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {
    private EditText etEmail, etPassword;
    private String email, password;

    RequestTask rt = new RequestTask();
    String logic_path = "http://localhost:8080/api/authorization";

    public Login(View view){
        rt.doInBackground(logic_path);
    }
    //private String URL = "https://10.65.142.113/login/login.php";


  /*  public Login(JDBCTemplateUserDAOImpl jdbcTemplateUserDaoImpl) {
        this.jdbcTemplateUserDaoImpl = jdbcTemplateUserDaoImpl;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);
        email = password = "";
        etEmail = findViewById(R.id.input_login);
        etPassword = findViewById(R.id.input_pas);

    }
    @Autowired
    private final JDBCTemplateUserDAOImpl jdbcTemplateUserDaoImpl;

    //Авторизация
    public String authorization(String Email, String Password) {
        /*try{
        String responce = "";
        User user = jdbcTemplateUserDaoImpl.getUserByEmailPassword(Email, Password);
        if (user.getPassword() != null){
            responce = "success";
            return responce;
        }
        else {
            return "failure";
        }
        /*}
        catch (Exception e){
            throw new UserNoExistException("User not exist(p)");
        }
    }

    //Создание пользователя(регистрация)
    public void registration(String Email, String Password) throws UserAlreadyExistException {
        if (jdbcTemplateUserDaoImpl.getUserByEmailPassword(Email, Password) !=null)
            throw new UserAlreadyExistException("User with this login already exist!");
        else
            jdbcTemplateUserDaoImpl.createUser(user);
    }


    public void login(View view) {
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        String responce = "";
        if(!email.equals("") && !password.equals("")){
            responce = authorization(email, password);
            if (responce.equals("success")) {
                    Intent intent = new Intent(Login.this, ScheduleActivity.class);
                    startActivity(intent);
                    finish();
                } else if (responce.equals("failure")) {
                    Toast.makeText(Login.this, "Invalid Login Id/Password", Toast.LENGTH_SHORT).show();
                }
            }
        else{
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
        }
    }
*/
    public void register(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
        finish();
    }

    public void urireg(View view)
    {
        Intent activityReg = new Intent(Login.this, Register.class);
        startActivity(activityReg);
    }
}