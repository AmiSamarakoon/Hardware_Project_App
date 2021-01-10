package amila.com.sendsms_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private Button loginButton;
    private TextView textLogin;
    private EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textLogin =(TextView) findViewById(R.id.tv_login) ;
        loginButton =(Button) findViewById(R.id.login);
        username =(EditText) findViewById(R.id.username);
        password =(EditText) findViewById(R.id.password);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                allowuUserToLog();
            }
        });

    }

    void allowuUserToLog(){

        String uname = username.getText().toString();
        String upwd = password.getText().toString();

        if(uname.equals("admin") && upwd.equals("admin123")) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show();
        }
    }
}
