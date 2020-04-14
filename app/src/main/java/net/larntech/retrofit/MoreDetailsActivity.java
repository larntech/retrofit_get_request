package net.larntech.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import net.larntech.retrofit.model.response.UserResponse;

public class MoreDetailsActivity extends AppCompatActivity {

    TextView email, username, status;

    UserResponse userResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);
        email = findViewById(R.id.email);
        status = findViewById(R.id.status);
        username = findViewById(R.id.username);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            userResponse = (UserResponse) intent.getSerializableExtra("data");

            String status_s;
            if(userResponse.isIs_active()){
                status_s = "Active";
            }else{
                status_s = "Deactivated";
            }

            email.setText(userResponse.getEmail());
            status.setText(status_s);
            username.setText(userResponse.getUsername());
        }

    }
}
