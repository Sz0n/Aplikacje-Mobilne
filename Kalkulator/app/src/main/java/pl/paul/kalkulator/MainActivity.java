package pl.paul.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAdd(View view){
        TextView text = (TextView) findViewById(R.id.text);
        Spinner spinnerNum1 = (Spinner) findViewById(R.id.spinnerNum1);
        Spinner spinnerNum2 = (Spinner) findViewById(R.id.spinnerNum2);
        Integer num1 = Integer.parseInt(spinnerNum1.getSelectedItem().toString());
        Integer num2 = Integer.parseInt(spinnerNum2.getSelectedItem().toString());
        text.setText(String.valueOf(num1 + num2));
    }

    public void onClickSub(View view){
        TextView text = (TextView) findViewById(R.id.text);
        Spinner spinnerNum1 = (Spinner) findViewById(R.id.spinnerNum1);
        Spinner spinnerNum2 = (Spinner) findViewById(R.id.spinnerNum2);
        Integer num1 = Integer.parseInt(spinnerNum1.getSelectedItem().toString());
        Integer num2 = Integer.parseInt(spinnerNum2.getSelectedItem().toString());
        text.setText(String.valueOf(num1-num2));
    }

    public void onClickDiv(View view){
        TextView text = (TextView) findViewById(R.id.text);
        Spinner spinnerNum1 = (Spinner) findViewById(R.id.spinnerNum1);
        Spinner spinnerNum2 = (Spinner) findViewById(R.id.spinnerNum2);
        Double num1 = Double.parseDouble(spinnerNum1.getSelectedItem().toString());
        Double num2 = Double.parseDouble(spinnerNum2.getSelectedItem().toString());
        if (num2 != 0) {
            text.setText(String.valueOf(num1 / num2));
        } else {
            text.setText("nie można dzielić przez 0");
        }
    }

    public void onClickMul(View view){
        TextView text = (TextView) findViewById(R.id.text);
        Spinner spinnerNum1 = (Spinner) findViewById(R.id.spinnerNum1);
        Spinner spinnerNum2 = (Spinner) findViewById(R.id.spinnerNum2);
        Double num1 = Double.parseDouble(spinnerNum1.getSelectedItem().toString());
        Double num2 = Double.parseDouble(spinnerNum2.getSelectedItem().toString());
        text.setText(String.valueOf(num1*num2));
    }
}
