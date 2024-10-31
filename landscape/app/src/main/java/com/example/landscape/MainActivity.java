package com.example.landscape;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Non è necessario chiamare rotateBraveBrowser() qui, verrà gestito dall'onClick del pulsante
    }

    public void rotateBraveBrowser(View view) {
        Log.d("MainActivity", "rotateBraveBrowser called");

        // Package name of Brave Browser
        String packageName = "com.chrome.browser";

        // Check if Brave Browser is installed
        if (isAppInstalled(packageName)) {
            // Launch Brave Browser
            PackageManager pm = getPackageManager();
            try {
                Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
                if (intent != null) {
                    startActivity(intent);
                } else {
                    Log.e("MainActivity", "Intent is null for package: " + packageName);
                }
            } catch (Exception e) {
                Log.e("MainActivity", "Exception while launching Brave Browser", e);
            }

        }
    }

    private boolean isAppInstalled(String packageName) {
        PackageManager pm = getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage(packageName);
        return intent != null;
    }
}
