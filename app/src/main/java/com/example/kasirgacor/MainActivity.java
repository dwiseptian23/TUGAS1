package com.example.kasirgacor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkbox1, checkbox2, checkbox3;
    private EditText jmlhbrg1, jmlhbrg2, jmlhbrg3;
    private RadioButton MemberYes, MemberNo;
    private Button Calculate;
    private TextView tagihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkbox1 = findViewById(R.id.checkbox1);
        checkbox2 = findViewById(R.id.checkbox2);
        checkbox3 = findViewById(R.id.checkbox3);
        jmlhbrg1 = findViewById(R.id.jmlhbrg1);
        jmlhbrg2 = findViewById(R.id.jmlhbrg2);
        jmlhbrg3 = findViewById(R.id.jmlhbrg3);
        MemberYes = findViewById(R.id.MemberYes);
        MemberNo = findViewById(R.id.MemberNo);
        Calculate = findViewById(R.id.Calculate);
        tagihan = findViewById(R.id.tagihan);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder hasil = new StringBuilder();
                int kaos = 75000;
                int jaket = 180000;
                int hoodie = 169000;
                int adm1 = 2000;
                int adm2 = 2500;
                int adm3 = 2900;
                int total1 = 0;
                int total2 = 0;
                int total3 = 0;
                try {
                    if (checkbox1.isChecked()) {
                        int jumlah = Integer.parseInt(jmlhbrg1.getText().toString());
                        int total = (kaos * jumlah) + adm1;
                        total1 = total;
                        hasil.append("\nKaos " + jumlah + " pcs : Rp." + total);
                        hasil.append("\nadmin : Rp." + adm1);
                    }
                    if (checkbox2.isChecked()) {
                        int jumlah = Integer.parseInt(jmlhbrg2.getText().toString());
                        int total = (jaket * jumlah) + adm2;
                        total2 = total;
                        hasil.append("\njaket " + jumlah + " pcs : Rp." + total);
                        hasil.append("\nadmin : Rp." + adm2);
                    }
                    if (checkbox3.isChecked()) {
                        int jumlah = Integer.parseInt(jmlhbrg3.getText().toString());
                        int total = (hoodie * jumlah) + adm3;
                        total3 = total;
                        hasil.append("\nhoodie" + jumlah + " pcs : Rp." + total);
                        hasil.append("\nadmin : Rp." + adm3);
                    }
                    int totalbelanja = total1 + total2 + total3;
                    if (MemberYes.isChecked()){
                        double member = 0.05 * totalbelanja;
                        totalbelanja -= member;
                        hasil.append("\nDiskon : Rp. " + member);
                        hasil.append("\ntotal akhir : Rp. " + totalbelanja);
                    }
                    else {
                        hasil.append("\ntotal akhir : Rp. " + totalbelanja);
                    }
                }
                catch (NumberFormatException e) {
                    hasil.append("ceklis terlebih dahulu" );
                }
                tagihan.setText(hasil.toString());
            }
        });
    }
}