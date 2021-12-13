package ca.qc.johnabbott.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.airbnb.lottie.LottieAnimationView;

import ca.qc.johnabbott.finalproject.UI.HomeFragment;
import ca.qc.johnabbott.finalproject.UI.MainActivity;
import ca.qc.johnabbott.finalproject.UI.MenuCategoryFragment;

public class SplashScreenActivity extends AppCompatActivity {

    private LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();
        lottieAnimationView = findViewById(R.id.anim);

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