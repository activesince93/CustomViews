package active.since93.customviewsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import active.since93.librery.textview.ScrollingTextView;

/**
 * Created by Darshan on 26-Sep-15.
 */
public class TextViewsActivity extends AppCompatActivity {

    ScrollingTextView scrollTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textviews);

        scrollTextView = (ScrollingTextView) findViewById(R.id.scrollTextView2);
        scrollTextView.setText(getString(R.string.text_text));
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }
}