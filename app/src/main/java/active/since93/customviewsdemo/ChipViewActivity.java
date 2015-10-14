package active.since93.customviewsdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Random;

import active.since93.librery.chipview.ChipView;

/**
 * Created by darshan.parikh on 08-Oct-15.
 */
public class ChipViewActivity extends AppCompatActivity {

    private CheckBox checkBoxCancelable;
    private Button btnAdd;
    private EditText edtTxtText;
    LinearLayout mainChipLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chipview);

        edtTxtText = (EditText) findViewById(R.id.edtTxtText);
        checkBoxCancelable = (CheckBox) findViewById(R.id.checkBoxCancelable);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        mainChipLayout = (LinearLayout) findViewById(R.id.main_chip_layout);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Adding chipview programatically
                 */
                int colors[] = {Color.rgb(255,51,51), Color.rgb(204,204,0), Color.rgb(102,204,0), Color.rgb(0,128,255), Color.rgb(204,0,102)};
                ChipView chipView = new ChipView(ChipViewActivity.this, edtTxtText.getText().toString(), colors[new Random().nextInt(colors.length)], checkBoxCancelable.isChecked());
                // Set margin to chipview
                chipView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) chipView.getLayoutParams();
                int padding = getResources().getDimensionPixelOffset(active.since93.librery.R.dimen.chip_view_padding);
                params.leftMargin = padding;
                params.rightMargin = padding;
                params.topMargin = padding;
                params.bottomMargin = padding;
                mainChipLayout.addView(chipView);
            }
        });
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