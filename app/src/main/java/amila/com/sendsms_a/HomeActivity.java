package amila.com.sendsms_a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView SendMessage;
    ImageButton ImageButtonCritical;
    ImageButton ImageButtonEmergency;
    ImageButton ImageButtonNormal;
    ImageButton ImageButtonCancel;

    String PHONE_NUMBER = "0768680618";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SendMessage = (TextView) findViewById(R.id.textSend);
        ImageButtonCritical = (ImageButton) findViewById(R.id.image_button_critical);
        ImageButtonEmergency= (ImageButton) findViewById(R.id.image_button_emergency);
        ImageButtonNormal= (ImageButton) findViewById(R.id.image_button_normal);
        ImageButtonCancel= (ImageButton) findViewById(R.id.image_button_cancel);



        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);

        ImageButtonCritical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {

                    String messageToSend="CRITICAL";
                    String number= PHONE_NUMBER +        //0789936664
                            "";
                    SmsManager.getDefault().sendTextMessage(number,null,messageToSend,null,null);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(HomeActivity.this,CriticalActivity.class);
                startActivity(intent);


            }
        });
        ImageButtonEmergency.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                //HIGH LEVEL messgae
            try {
                String messageEmergency="HIGH LEVEL";
                String number = PHONE_NUMBER +  //0789936664
                        "";
                SmsManager.getDefault().sendTextMessage(number,null,messageEmergency,null,null);

            } catch (Exception e){
                e.printStackTrace();

            }
            Intent intent = new Intent(HomeActivity.this,EmergencyActivity.class);
            startActivity(intent);

            }
        });

        ImageButtonNormal.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //LOW LEVEL message
            try{
                String messageNormal ="LOW LEVEL";
                String number = PHONE_NUMBER+        //0789936664
                        "";
                SmsManager.getDefault().sendTextMessage(number,null,messageNormal,null,null);
                int k=0;
            } catch (Exception e){
                e.printStackTrace();
            }
            Intent intent = new Intent(HomeActivity.this,NormalActivity.class);
            startActivity(intent);

        }
        });
        ImageButtonCancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                finish();
                System.exit(0);
        }
        });
    }

}
