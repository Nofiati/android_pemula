package com.nofi.submissionandroidpemula.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nofi.submissionandroidpemula.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfilNofiActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_nofi);
        ButterKnife.bind(this);

        back.setOnClickListener(v -> {
            Toast.makeText(this, "Anda Kembali ke Menu Utama", Toast.LENGTH_LONG).show();
            Intent back = new Intent(ProfilNofiActivity.this,MainActivity.class);
            startActivity(back);
        });
    }
}
