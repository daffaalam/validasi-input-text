package com.example.daffa.project170906;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class main extends AppCompatActivity {


    //Step 1 - Declare
    EditText bnmlngkp, busrnm, bmail, btlpn, balmt, blhr;
    RadioButton jrpl, jtkj, jtkr, jtabo;
    Button btcek, btsdint, btsdbdl;

    //Step 2 - Declare hasil PilihJurusan
    String pljrsn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 3 - Meng-link / mengubungkan widget dari xml ke java
        bnmlngkp = (EditText) findViewById(R.id.nmlngkp);
        busrnm = (EditText) findViewById(R.id.usrnm);
        bmail = (EditText) findViewById(R.id.mail);
        btlpn = (EditText) findViewById(R.id.tlpn);
        balmt = (EditText) findViewById(R.id.almt);
        blhr = (EditText) findViewById(R.id.lhr);
        jrpl = (RadioButton) findViewById(R.id.rpl);
        jtkj = (RadioButton) findViewById(R.id.tkj);
        jtkr = (RadioButton) findViewById(R.id.tkr);
        jtabo = (RadioButton) findViewById(R.id.tabo);
        btcek = (Button) findViewById(R.id.cek);
        btsdint = (Button) findViewById(R.id.sdint);
        btsdbdl = (Button) findViewById(R.id.sdbdl);

        //Step 4 - Membuat aksi button check
        btcek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biodata();
            }
        });

//        btsdint.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        btsdbdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sndata();
            }
        });

    }

    //Step 5 - Membuat methode aksi pilih jurusan radio button
    public void jurusan() {
        if (jrpl.isChecked()) {
            pljrsn = "Jurusan Rekayasa Perangkat Lunak";
        } else if (jtkj.isChecked()) {
            pljrsn = "Jurusan Tehnik Komputer Jaringan";
        } else if (jtkr.isChecked()) {
            pljrsn = "Jurusan Tehnik Kendaraan Ringan";
        } else if (jtabo.isChecked()) {
            pljrsn = "Jurusan Tata Boga";
        } else {
            //Step 6 - AlertDialog jika user tidak memilih samasekali RadioButton PilihJurusan
            AlertDialog.Builder alrtmsg = new AlertDialog.Builder(this);
            alrtmsg
                    .setTitle("WARNING!")
                    .setMessage("Pilih salah satu jurusan terlebih dahulu")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alrtdlg = alrtmsg.create();
            alrtdlg.show();
        }
    }

    //Step 7 - Validasi Inputan Data
    public void biodata() {

//        String mailvld = bmail.getText().toString();

        // if (bnmlngkp.getText().toString().isEmpty()) - Jika EditText bnmlngkp masih kosong
        // bnmlngkp.setError("Nama harus isi."); - maka akan tampil pesan error pd EditText tersebut
        // bnmlngkp.requestFocus(); - kemudian Kursor akan meminta fokus ke Edittext tersebut
        // !bnmlngkp.getText().toString().isEmpty() - lalu di else if jika bnmlngkp sudah terisi / tidak kosong
        // && - pengganti 'dan' dalam AndroidStudio
        // busrnm.getText().toString().isEmpty() - jadi jika bnmlngkp sudah terisi dan/tapi busrnm masih kosong maka akan menampilkan error pd EditText busrnm

        if (bnmlngkp.getText().toString().isEmpty()) {
            bnmlngkp.setError("Nama harus isi.");
            bnmlngkp.requestFocus();
        } else if (!bnmlngkp.getText().toString().isEmpty() && busrnm.getText().toString().isEmpty()) {
            busrnm.setError("Username harus isi.");
            busrnm.requestFocus();
        } else if (!busrnm.getText().toString().isEmpty() && bmail.getText().toString().isEmpty()) {
            bmail.setError("Email harus isi.");
            bmail.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(bmail.getText().toString()).matches()) {
            bmail.setError("Email tidak valid!");
            bmail.setHint("contoh : example@mail.com");
            bmail.setText("");
            bmail.requestFocus();
        } else if (!bmail.getText().toString().isEmpty() && btlpn.getText().toString().isEmpty()) {
            btlpn.setError("Nomor Telephone harus isi.");
            btlpn.requestFocus();
        } else if (!Patterns.PHONE.matcher(btlpn.getText().toString()).matches()) {
            btlpn.setError("Nomor tidak valid!");
            btlpn.setText("");
            btlpn.requestFocus();
        } else if (!btlpn.getText().toString().isEmpty() && balmt.getText().toString().isEmpty()) {
            balmt.setError("Alamat harus isi.");
            balmt.requestFocus();
        } else if (!balmt.getText().toString().isEmpty() && blhr.getText().toString().isEmpty()) {
            blhr.setError("Tanggal Lahir harus isi.");
            blhr.requestFocus();
        } else {

            //Step 8 - Jika semua data sudah terisi maka menjalankan methode jurusan() yg tadi sudah dibuat dan menampilkan semua data dalam AlertDialog
            jurusan();
            if (pljrsn != null) {
                AlertDialog.Builder alrtdata = new AlertDialog.Builder(this);

                alrtdata
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setTitle("BIODATA ANDA")
                        .setMessage(
                                "Nama : " + bnmlngkp.getText().toString() +
                                        "\nUsername : " + busrnm.getText().toString() +
                                        "\nEmail : " + bmail.getText().toString() +
                                        "\nPhone : " + btlpn.getText().toString() +
                                        "\nAlamat : " + balmt.getText().toString() +
                                        "\nTgl Lahir : " + blhr.getText().toString() +
                                        "\n" + pljrsn)
                        .setPositiveButton("Kirim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sndata();
                            }
                        })

                        // tombol EditText tuk kembali ke Edit data dan fokus ke Nama Lengkap
                        .setNegativeButton("Edit Text", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                bnmlngkp.requestFocus();
                            }
                        })

                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog alrtdial = alrtdata.create();
                alrtdial.show();
            }
        }
    }

    //Step 9 - Membuat methode untuk mengirim data ke activity lain
    public void sndata() {
        final String nama = bnmlngkp.getText().toString();
        final String usrname = busrnm.getText().toString();
        final String emails = bmail.getText().toString();
        final String telpon = btlpn.getText().toString();
        final String almat = balmt.getText().toString();
        final String tgllahir = blhr.getText().toString();

        //Adapter Bundle tuk mengangkut data
        Bundle snddata = new Bundle();

        jurusan();

        snddata.putString("namalengkapx", nama);
        snddata.putString("usernamex", usrname);
        snddata.putString("emailx", emails);
        snddata.putString("telephone", telpon);
        snddata.putString("alamatx", almat);
        snddata.putString("tgllahirx", tgllahir);
        snddata.putString("jurusanx", pljrsn);

        //Adapter Intent tuk pindah activity
        Intent pndah = new Intent(main.this, data.class);
        pndah.putExtras(snddata);
        startActivity(pndah);

    }
}