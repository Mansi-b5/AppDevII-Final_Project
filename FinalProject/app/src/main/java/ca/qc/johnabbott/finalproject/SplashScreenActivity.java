package ca.qc.johnabbott.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

import ca.qc.johnabbott.finalproject.UI.HomeFragment;
import ca.qc.johnabbott.finalproject.UI.MainActivity;
import ca.qc.johnabbott.finalproject.UI.MenuCategoryFragment;

//Animation https://lottiefiles.com/64809-pizza-loading
//LOGO made in https://www.namecheap.com/logo-maker/app/editor
public class SplashScreenActivity extends AppCompatActivity {

    private LottieAnimationView lottieAnimationView;
    private ImageView logo;
    private ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();
        lottieAnimationView = findViewById(R.id.anim);
        logo = findViewById(R.id.logo_imageview);
        layout = findViewById(R.id.splashscreen_constraintlayout);

        layout.animate().translationY(1800).setDuration(1000).setStartDelay(6000);

        logo.animate().translationY(1800).setDuration(1000).setStartDelay(6000);

        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(5000);

        new CountDownTimer(7000,1000)
        {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);

            }
        }.start();

    }
}