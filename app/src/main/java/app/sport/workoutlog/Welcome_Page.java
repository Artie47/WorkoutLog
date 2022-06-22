package app.sport.workoutlog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        initializeComponents();
    }

    private void initializeComponents() {
        Button btnUser = findViewById(R.id.i_am_a_user);
        Button btnTrainer = findViewById(R.id.is_a_trainer);

        btnUser.setOnClickListener(view ->{
            Intent i = new Intent(Welcome_Page.this, Register.class);
            startActivity(i);
        });
        btnTrainer.setOnClickListener(view ->{
            Intent i = new Intent(Welcome_Page.this, RegisterTrainer.class);
            startActivity(i);
        });
    }
}