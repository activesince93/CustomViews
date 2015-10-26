package active.since93.customviewsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

/**
 * Created by darshan.parikh on 26-Oct-15.
 */
public class AutoCompleteTextViewActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    String countries[] = {"India", "China", "USA", "England", "Dubai", "Pakistan", "Iran", "Indiana"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete_textview);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.txtAutoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        autoCompleteTextView.setAdapter(adapter);
    }
}