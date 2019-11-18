package bd.com.rafi.goole_mattarial_design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
Button button;
TextView text;
EditText email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.login);
        email=(EditText) findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);
        text=(TextView) findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
           dataValidation();
            }
        });
    }

    public void dataValidation() {
        int e=0,p=0;
        if (!email.getText().toString().isEmpty()) {
            Pattern pattern;
            Matcher matcher;
            final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(email.getText().toString());
            if (!matcher.matches()) {
                email.setError("Enter a valid email address");
            } else {
               e=1;
            }
        }
        else{
            email.setError("Enter a  email address");
           // email.requestFocus();
        }
        if (!pass.getText().toString().isEmpty()) {
            if(pass.getText().toString().length()>=8){
                p=1;
            }
           else{
                pass.setError("Enter minimum 8 digit");
                //pass.requestFocus();
            }
        }
        else{
            pass.setError("Enter your password");
        }

     if(e==1&&p==1){
         text.setText("succssesfull");
     }
        }
    }

