package active.since93.customviewsdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AnalyticsTrackers analyticsTrackers;
    Tracker t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btnTextViews, btnButtons, btnSnackBar, btnSnackBarWithButton, btnImageViews, btnEditTexts, btnAlertWithButton, btnAlertWOButton;
        setContentView(R.layout.activity_main);
        analyticsTrackers = new AnalyticsTrackers(this);
        try {
            t = ((AnalyticsTrackers) getApplication()).get(AnalyticsTrackers.Target.APP_TRACKER, this);
            t.send(new HitBuilders.AppViewBuilder().build());
        } catch(Exception e) {
            e.printStackTrace();
        }

        btnTextViews = (Button) findViewById(R.id.btn_text_views);
        btnButtons = (Button) findViewById(R.id.btn_buttons);
        btnSnackBar = (Button) findViewById(R.id.snackbar);
        btnImageViews = (Button) findViewById(R.id.btn_imageviews);
        btnEditTexts = (Button) findViewById(R.id.btn_edit_text);
        btnAlertWithButton = (Button) findViewById(R.id.btnAlertWithButton);
        btnAlertWOButton = (Button) findViewById(R.id.btnAlertWOButton);
        btnSnackBarWithButton = (Button) findViewById(R.id.snackbar_button);
        btnTextViews.setOnClickListener(this);
        btnButtons.setOnClickListener(this);
        btnSnackBar.setOnClickListener(this);
        btnSnackBarWithButton.setOnClickListener(this);
        btnImageViews.setOnClickListener(this);
        btnEditTexts.setOnClickListener(this);
        btnAlertWithButton.setOnClickListener(this);
        btnAlertWOButton.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        GoogleAnalytics.getInstance(this).reportActivityStop(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = null;
        switch (id) {
            case R.id.btn_text_views:
                intent = new Intent(MainActivity.this, TextViewsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case R.id.btn_buttons:
                intent = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case R.id.snackbar:
                Snackbar.make(v, "SnackBar without button.", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.snackbar_button:
                Snackbar.make(v, "SnackBar with button.", Snackbar.LENGTH_LONG).setAction("Button", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Button clicked!", Toast.LENGTH_LONG).show();
                    }
                }).show();
                break;
            case R.id.btn_imageviews:
                intent = new Intent(MainActivity.this, ImageViewsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case R.id.btn_edit_text:
                intent = new Intent(MainActivity.this, EditTextsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case R.id.btnAlertWithButton:
                showAlertWithButton(v);
                break;
            case R.id.btnAlertWOButton:
                showAlertWOButton();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = null;
        switch(id) {
            case R.id.action_github:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/activesince93/CustomViews"));
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    void showAlertWOButton() {
        AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
        adb.setTitle(getString(R.string.app_name))
                .setMessage("This is message.")
                .show();
    }

    void showAlertWithButton(final View v) {
        AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
        adb.setTitle(getString(R.string.app_name))
                .setMessage("This is message.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Snackbar.make(v, "OK clicked!", Snackbar.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Snackbar.make(v, "CANCEL clicked!", Snackbar.LENGTH_LONG).show();
                    }
                })
                .show();
    }
}
