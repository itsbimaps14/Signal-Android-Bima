package org.thoughtcrime.securesms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import org.thoughtcrime.securesms.util.DynamicTheme;

public class Splashscreen extends Activity {
    private static int splashInterval = 5000;
    private final DynamicTheme dynamicTheme = new DynamicTheme();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        String tema = DynamicTheme.ambilThemeBima(this);
        if(tema.equals("dark")){
            setContentView(R.layout.splash_dark);
        }
        else{
            setContentView(R.layout.splash_light);
        }

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, splashInterval);
    }
}
