package eu.carryT.rider.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.splunk.mint.Mint;
import eu.carryT.rider.R;




public class BeginScreen extends AppCompatActivity {

    TextView login,register;
    LinearLayout social_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mint.setApplicationEnvironment(Mint.appEnvironmentStaging);
        Mint.initAndStartSession(this.getApplication(), "3c1d6462");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_begin);

        login = (TextView)findViewById(R.id.login_new);
        register = (TextView)findViewById(R.id.register_new);
//        social_layout = (LinearLayout) findViewById(R.id.social_layout);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(BeginScreen.this, ActivityEmail.class);
             //   mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainIntent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

                login.setTextColor(getResources().getColor(R.color.text_color_white));
                login.setBackground(getResources().getDrawable(R.drawable.black_back));
                register.setTextColor(getResources().getColor(R.color.black_text_color));
                register.setBackground(getResources().getDrawable(R.drawable.border_stroke_black));
               // BeginScreen.this.finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setTextColor(getResources().getColor(R.color.black_text_color));
                login.setBackground(getResources().getDrawable(R.drawable.border_stroke_black));
                register.setTextColor(getResources().getColor(R.color.text_color_white));
                register.setBackground(getResources().getDrawable(R.drawable.black_back));
                Intent mainIntent = new Intent(BeginScreen.this, RegisterActivity.class);
                mainIntent.putExtra("isFromMailActivity", "begin");
                startActivity(mainIntent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }

        });


//        social_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent mainIntent = new Intent(BeginScreen.this, ActivitySocialLogin.class);
//                //   mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(mainIntent);
//                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
//            }
//        });



    }


}
