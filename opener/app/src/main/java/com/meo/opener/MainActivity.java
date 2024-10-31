package com.meo.opener;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ottieni la lista di tutti i pacchetti installati
        List<ApplicationInfo> packages = getInstalledPackages();

        // Stampa i nomi dei pacchetti sulla console di log
        for (ApplicationInfo packageInfo : packages) {
            String packageName = packageInfo.packageName;
            System.out.println("Pacchetto installato: " + packageName);
        }

        // Chiudi immediatamente l'activity corrente
        finish();
    }

    private List<ApplicationInfo> getInstalledPackages() {
        PackageManager packageManager = getPackageManager();
        return packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
    }
}
