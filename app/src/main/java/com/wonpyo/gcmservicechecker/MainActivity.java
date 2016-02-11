package com.wonpyo.gcmservicechecker;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    GcmServiceMonitor gcmServiceMonitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gcmServiceMonitor = new GcmServiceMonitor(MainActivity.this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void checkGcmServiceIsRunning(View view) {
        GcmServiceChecker gcmServiceChecker = new GcmServiceChecker(MainActivity.this);
        if (gcmServiceChecker.isRunningGcmService()) {
            Snackbar.make(view, "GcmService is running:\n" + gcmServiceChecker.getClassNameOfGcmService(), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        } else {
            Snackbar.make(view, "GcmService is not running", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    public void startGcmServiceIfNotRunningNow(View view) {
        GcmServiceChecker gcmServiceChecker = new GcmServiceChecker(MainActivity.this);
        if (gcmServiceChecker.isRunningGcmService()) {
            Snackbar.make(view, "GcmService is already running, so nothing happened", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        } else {
            GcmServiceStarterThread gcmServiceStarterThread = new GcmServiceStarterThread(MainActivity.this);
            gcmServiceStarterThread.start();

            Snackbar.make(view, "GcmService is not running, so GcmService has started:\n" + gcmServiceChecker.getClassNameOfGcmService(), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    public void startMonitoring(View view) {
        gcmServiceMonitor.startMonitoring();
    }

    public void stopMonitoring(View view) {
        gcmServiceMonitor.stopMonitoring();
    }
}
