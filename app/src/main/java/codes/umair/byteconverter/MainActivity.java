package codes.umair.byteconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerFrom, spinnerTo;
    TextView tv_result;
    EditText editText_input;
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String input = editText_input.getText().toString();
            if (input.isEmpty()) {
                tv_result.setText("0.00");
            } else {
                task();
            }


        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    ImageView img_Icon;
    ImageView img_btnSwitch;

    // 1KB == 1024 B
    // 1MB == 1024 KB
    // 1GB == 1024 MB
    String[] Units = {"Bytes", "Kilobytes", "Megabytes", "Gigabytes", "Terabytes"};

    /*

    To convert KB to MB Divide digital value by 1024
    for example 10000KB / 1024 = 9.77 MB

     To convert MB to KB Multiply digital value by 1024
     for example 10KB * 1024 = 1024000 KB

     To convert MB to GB Divide digital value by 1024
     for example 1000MB / 1024 = 0.98 GB

      To convert GB to MB Multiply digital value by 1024
      for example 1GB * 1024 = 1024 MB

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result = findViewById(R.id.tv_result);
        spinnerFrom = findViewById(R.id.spinner_from);
        spinnerTo = findViewById(R.id.spinner_to);
        editText_input = findViewById(R.id.edt_input);
        img_btnSwitch = findViewById(R.id.imgSwitch);
        img_Icon = findViewById(R.id.imgVicon);
        img_Icon.startAnimation(inFromLeft());


        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerTo.setAdapter(adapter);
        spinnerFrom.setAdapter(adapter);

        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                task();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                task();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        img_btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long from = spinnerFrom.getSelectedItemId();
                long to = spinnerTo.getSelectedItemId();
                spinnerFrom.setSelection((int) to);
                spinnerTo.setSelection((int) from);

            }
        });
        editText_input.addTextChangedListener(textWatcher);


    }

    public void task() {
        if (!editText_input.getText().toString().isEmpty()) {
            String input = editText_input.getText().toString();
            String from = spinnerFrom.getSelectedItem().toString();
            String to = spinnerTo.getSelectedItem().toString();

            Convert(from, to, Double.parseDouble(input));
        }
    }

    public void Convert(String from, String to, double input) {


        //if input is in bytes
        if (from.equals("Bytes")) {

            if (to.equals("Bytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f B", ((double) input));
                tv_result.setText(msg);
            }
            //if outSpin is in Kilobytes
            if (to.equals("Kilobytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f KB", (input / 1024));
                tv_result.setText(msg);
            }
            //if outSpin is in Megabytes
            if (to.equals("Megabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f MB", (input / 1024 / 1024));
                tv_result.setText(msg);

            }
            //if outSpin is in Gigabytes
            if (to.equals("Gigabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f GB", (input / 1024 / 1024 / 1024));
                tv_result.setText(msg);

            }
            //if outSpin is in Terabytes
            if (to.equals("Terabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f TB", (input / 1024 / 1024 / 1024 / 1024));
                tv_result.setText(msg);

            }
        }


        //if input is in kilpbytes
        if (from.equals("Kilobytes")) {

            if (to.equals("KiloBytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f KB", ((double) input));
                tv_result.setText(msg);
            }
            //if outSpin is in Kilobytes
            if (to.equals("Bytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f B", (input * 1024));
                tv_result.setText(msg);
            }
            //if outSpin is in Megabytes
            if (to.equals("Megabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f MB", (input / 1024));
                tv_result.setText(msg);

            }
            //if outSpin is in Gigabytes
            if (to.equals("Gigabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f GB", (input / 1024 / 1024));
                tv_result.setText(msg);


            }
            //if outSpin is in Terabytes
            if (to.equals("Terabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f TB", (input / 1024 / 1024 / 1024));
                tv_result.setText(msg);

            }
        }
//13198336
        //if input is in Megabytes
        if (from.equals("Megabytes")) {

            if (to.equals("Megabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f MB", ((double) input));
                tv_result.setText(msg);
            }

            //if outSpin is in Megabytes
            if (to.equals("Bytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f B", (input * 1024 * 1024));
                tv_result.setText(msg);
            }

            //if outSpin is in Kilobytes
            if (to.equals("Kilobytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f KB", (input * 1024));
                tv_result.setText(msg);
            }

            //if outSpin is in Gigabytes
            if (to.equals("Gigabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f GB", (input / 1024));
                tv_result.setText(msg);

            }
            //if outSpin is in Terabytes
            if (to.equals("Terabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f TB", (input / 1024 / 1024));
                tv_result.setText(msg);

            }
        }

        //if input is in GigaBytes
        if (from.equals("Gigabytes")) {

            if (to.equals("Gigabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f GB", ((double) input));
                tv_result.setText(msg);
            }
            //if GB -> bytes
            if (to.equals("Bytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f B", (input * 1024 * 1024 * 1024));
                tv_result.setText(msg);
            }

            //if GB -> Kilobytes
            if (to.equals("Kilobytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f KB", (input * 1024 * 1024));
                tv_result.setText(msg);
            }
            //if GB -> Megabytes
            if (to.equals("Megabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f MB", (input * 1024));
                tv_result.setText(msg);
            }

            //if GB -> Terabytes
            if (to.equals("Terabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f TB", (input / 1024));
                tv_result.setText(msg);
            }
        }

        //if input is in Terabytes
        if (from.equals("Terabytes")) {

            if (to.equals("Terabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f TB", ((double) input));
                tv_result.setText(msg);
            }
            //if outSpin is in Bytes
            if (to.equals("Bytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f B", (input * 1024 * 1024 * 1024 * 1024));
                tv_result.setText(msg);
            }

            //if outSpin is in Kilobytes
            if (to.equals("Kilobytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f KB", (input * 1024 * 1024 * 1024));
                tv_result.setText(msg);
            }
            //if outSpin is in Megabytes
            if (to.equals("Megabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f MB", (input * 1024 * 1024));
                tv_result.setText(msg);

            }
            //if outSpin is in Gigabytes
            if (to.equals("Gigabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f GB", (input * 1024));
                tv_result.setText(msg);
            }
        }
    }

    private Animation inFromLeft() {
        Animation animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f);
        animation.setDuration(300);
        animation.setInterpolator(new AccelerateInterpolator());
        return animation;
    }
}
