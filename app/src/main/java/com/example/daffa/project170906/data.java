package com.example.daffa.project170906;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class data extends AppCompatActivity {

    TextView namadx, usernamedx, emaildx, phonedx, alamatdx, tgllahirdx, jurusandx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        namadx = (TextView)findViewById(R.id.namad);
        usernamedx = (TextView)findViewById(R.id.usrnamed);
        emaildx = (TextView)findViewById(R.id.emaild);
        phonedx = (TextView)findViewById(R.id.phoned);
        alamatdx = (TextView)findViewById(R.id.alamatd);
        tgllahirdx = (TextView)findViewById(R.id.tgllahird);
        jurusandx = (TextView)findViewById(R.id.jurusand);

        if (getIntent().getExtras() != null) {

            Bundle getdata = getIntent().getExtras();
            namadx.setText(getdata.getString("namalengkapx"));
            usernamedx.setText(getdata.getString("usernamex"));
            emaildx.setText(getdata.getString("emailx"));
            phonedx.setText(getdata.getString("telephone"));
            alamatdx.setText(getdata.getString("alamatx"));
            tgllahirdx.setText(getdata.getString("tgllahirx"));
            jurusandx.setText(getdata.getString("jurusanx"));
        }
        else if (getIntent().getExtras() == null){

            Toast.makeText(data.this, "TIDAK ADA DATA YANG DIKIRIM", Toast.LENGTH_LONG).show();

        }
    }
}
