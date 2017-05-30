package com.example.week3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private final double[] prices = new double[]{100.0, 150.0, 200.0, 250.0};
    //private final String[] terms  = new String[]{"Spring", "Summer", "Fall", "Winter"};
    private String termSelected;
    //private double cost;
    private double termCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtNumOfCredits = (EditText) findViewById(R.id.txtNumOfCredits);
        final TextView txtCostPerCredit = (TextView)findViewById(R.id.txtCostPerCredit);
        final TextView txtResult = (TextView)findViewById(R.id.txtResult);

        final Spinner termList = (Spinner) findViewById(R.id.spinner);
        termList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                termCost = prices[position];
                //termSelected = terms[position];
                termSelected = termList.getSelectedItem().toString();
                Log.d("termCost[1]: " ,String.format("%f",termCost));
                txtCostPerCredit.setText(String.format("$%.2f", prices[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                txtCostPerCredit.setText("");
            }
        });

        final Button btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    int credits = Integer.parseInt(txtNumOfCredits.getText().toString());

                    if(credits > 0) {
                        Log.d("termCost[3]: " ,String.format("%f",termCost));
                        Log.d("credits: " ,String.format("%d",credits));
                        String result = String.format("Total: $%.2f", termCost * credits);
                        txtResult.setText(result);

                        Intent newIntent = new Intent(MainActivity.this, result.class);
                        newIntent.putExtra("termCost", String.format("$%.2f", termCost));
                        newIntent.putExtra("credits", String.format("%d",credits));
                        newIntent.putExtra("result", String.format("$%.2f", (termCost * credits)));
                        newIntent.putExtra("term", termSelected);
                        startActivity(newIntent);

                    }
                    else{

                        txtResult.setText("ERROR: invalid credits number");
                    }
                }
                catch(Exception ex){

                    String exception = ex.getMessage();
                    txtResult.setText("ERROR: invalid credits number\n" + exception);
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        termCost = prices[position];
        Log.d("termCost[2]: " , String.format("%f",termCost));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
