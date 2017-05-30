package com.example.week3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView txtTermVal = (TextView) findViewById(R.id.txtTermVal);
        TextView txtTermCostVal = (TextView) findViewById(R.id.txtTermCostVal);
        TextView textCreditsVal = (TextView) findViewById(R.id.textCreditsVal);
        TextView txtTotalVal = (TextView) findViewById(R.id.txtTotalVal);

        Bundle myBundl = getIntent().getExtras();

        String TermVal, TermCostVal, CreditsVal, TotalVal;

        TermVal = myBundl.getString("term");
        txtTermVal.setText(TermVal);

        TermCostVal = myBundl.getString("termCost");
        txtTermCostVal.setText(TermCostVal);

        CreditsVal = myBundl.getString("credits");
        textCreditsVal.setText(CreditsVal);

        TotalVal = myBundl.getString("result");
        txtTotalVal.setText(TotalVal);

        final Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }
}
