package active.since93.customviewsdemo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import active.since93.librery.button.ButtonRectangle;
import active.since93.librery.button.CustomButton;

/**
 * Created by darshan.parikh on 28-Sep-15.
 */
public class ButtonActivity extends AppCompatActivity implements View.OnClickListener{

    Button simpleButton;
    ButtonRectangle customRippleButton;
    CustomButton customButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        simpleButton = (Button) findViewById(R.id.simpleButton);
        customRippleButton = (ButtonRectangle) findViewById(R.id.customRippleButton);
        customButton = (CustomButton) findViewById(R.id.customButton);

        simpleButton.setOnClickListener(this);
        customRippleButton.setOnClickListener(this);
        customButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id) {
            case R.id.simpleButton:
                Snackbar.make(v, "Simple BUTTON clicked!", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.customRippleButton:
                Snackbar.make(v, "Custom ripple BUTTON clicked!", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.customButton:
                Snackbar.make(v, "Custom BUTTON clicked!", Snackbar.LENGTH_LONG).show();
                break;

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
