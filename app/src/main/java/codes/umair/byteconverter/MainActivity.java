package codes.umair.byteconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.Formatter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerFrom, spinnerTo;
    TextView tv_result;
    EditText editText_input;
    String[] units = {"Bytes", "Kilobytes", "Megabytes", "Gigabytes", "Terabytes"};



    // 1KB == 1024 B
    // 1MB == 1024 KB
    // 1GB == 1024 MB


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
        tv_result = (TextView) findViewById(R.id.tv_result);
        spinnerFrom = (Spinner) findViewById(R.id.spinner_from);
        spinnerTo = (Spinner) findViewById(R.id.spinner_to);
        editText_input = (EditText) findViewById(R.id.edt_input);


        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerTo.setAdapter(adapter);
        spinnerFrom.setAdapter(adapter);

        editText_input.addTextChangedListener(textWatcher);

    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String input = editText_input.getText().toString();
            String from = spinnerFrom.getSelectedItem().toString();
            String to = spinnerTo.getSelectedItem().toString();

            Convert(from, to, Long.parseLong(input));
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    public void Convert(String from, String to, long input) {

        //if input is in bytes
        if (from.equals("Bytes")) {

            //if outSpin is in Kilobytes
            if (to.equals("Kilobytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f KB", ((double) input / 1024));
               tv_result.setText(msg);
            }
            //if outSpin is in Megabytes
            if (to.equals("Megabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f MB", ((double) input / 1024 / 1024));
               tv_result.setText(msg);

            }
            //if outSpin is in Gigabytes
            if (to.equals("Gigabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f GB", ((double) input / 1024 / 1024 / 1024));
               tv_result.setText(msg);

            }
            //if outSpin is in Terabytes
            if (to.equals("Terabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f TB", ((double) input / 1024 / 1024 / 1024 / 1024));
               tv_result.setText(msg);

            }
        }


        //if input is in kilpbytes
        if (from.equals("Kilobytes")) {

            //if outSpin is in Kilobytes
            if (to.equals("Bytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f B", ((double) input * 1024));
               tv_result.setText(msg);
            }
            //if outSpin is in Megabytes
            if (to.equals("Megabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f MB", ((double) input / 1024));
               tv_result.setText(msg);

            }
            //if outSpin is in Gigabytes
            if (to.equals("Gigabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f GB", ((double) input / 1024 / 1024));
               tv_result.setText(msg);


            }
            //if outSpin is in Terabytes
            if (to.equals("Terabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f TB", ((double) input / 1024 / 1024 / 1024));
               tv_result.setText(msg);

            }
        }
//13198336
        //if input is in Megabytes
        if (from.equals("Megabytes")) {

            //if outSpin is in Megabytes
            if (to.equals("Bytes")) {

                String msg = String.format(Locale.getDefault(), "%.2f B", ((double) input * 1024 * 1024));
                tv_result.setText(msg);

            }

            //if outSpin is in Kilobytes
            if (to.equals("Kilobytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f KB", ((double) input * 1024));
               tv_result.setText(msg);
            }

            //if outSpin is in Gigabytes
            if (to.equals("Gigabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f GB", ((double) input / 1024));
               tv_result.setText(msg);

            }
            //if outSpin is in Terabytes
            if (to.equals("Terabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f TB", ((double) input / 1024 / 1024));
               tv_result.setText(msg);

            }
        }

        //if input is in GigaBytes
        if (from.equals("Gigabytes")) {

            //if GB -> bytes
            if (to.equals("Bytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f B", ((double) input * 1024 * 1024 * 1024));
               tv_result.setText(msg);
            }

            //if GB -> Kilobytes
            if (to.equals("Kilobytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f KB", ((double) input * 1024 * 1024));
               tv_result.setText(msg);
            }
            //if GB -> Megabytes
            if (to.equals("Megabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f MB", ((double) input * 1024));
               tv_result.setText(msg);
            }

            //if GB -> Terabytes
            if (to.equals("Terabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f TB", ((double) input / 1024));
               tv_result.setText(msg);
            }
        }

        //if input is in Terabytes
        if (from.equals("Terabytes")) {

            //if outSpin is in Bytes
            if (to.equals("Bytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f B", ((double) input * 1024 * 1024 * 1024 * 1024));
               tv_result.setText(msg);
            }

            //if outSpin is in Kilobytes
            if (to.equals("Kilobytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f KB", ((double) input * 1024 * 1024 * 1024));
               tv_result.setText(msg);
            }
            //if outSpin is in Megabytes
            if (to.equals("Megabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f MB", ((double) input * 1024 * 1024));
               tv_result.setText(msg);

            }
            //if outSpin is in Gigabytes
            if (to.equals("Gigabytes")) {
                String msg = String.format(Locale.getDefault(), "%.2f GB", ((double) input * 1024));
               tv_result.setText(msg);
            }
        }
    }
}
