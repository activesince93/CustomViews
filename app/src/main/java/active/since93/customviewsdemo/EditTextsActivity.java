package active.since93.customviewsdemo;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * Created by darshan.parikh on 07-Oct-15.
 */
public class EditTextsActivity extends AppCompatActivity {

    TextInputLayout textInputLayout;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittexts);

        textInputLayout = (TextInputLayout) findViewById(R.id.layoutEdtTxt);
        editText = (EditText) findViewById(R.id.extTxtEnter);

        textInputLayout.setErrorEnabled(true);
        textInputLayout.setError("Min 2 chars required");
        editText.setError("Required");
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