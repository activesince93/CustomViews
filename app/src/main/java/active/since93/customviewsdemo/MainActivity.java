package active.since93.customviewsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTextViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTextViews = (Button) findViewById(R.id.btn_text_views);
        btnTextViews.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_text_views:
                Intent intent = new Intent(MainActivity.this, TextViewsActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
