package com.nofi.submissionandroidpemula.activity.detail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.nofi.submissionandroidpemula.R;
import com.nofi.submissionandroidpemula.activity.MainActivity;
import com.nofi.submissionandroidpemula.model.KulinerKudus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailKulinerActivity extends AppCompatActivity {

    KulinerKudus kulinerKudus;
    @BindView(R.id.tv_namaDetailKuliner)
    TextView tvNamaDetailKuliner;
    @BindView(R.id.iv_backdropKuliner)
    ImageView ivBackdropKuliner;
    @BindView(R.id.iv_imageDetailKuliner)
    ImageView ivImageDetailKuliner;
    @BindView(R.id.tv_alamatDetailKuliner)
    TextView tvAlamatDetailKuliner;
    @BindView(R.id.tv_jenisDetailKuliner)
    TextView tvJenisDetailKuliner;
    @BindView(R.id.tv_deskripsiDetailKuliner)
    TextView tvDeskripsiDetailKuliner;
    @BindView(R.id.back)
    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kuliner);
        ButterKnife.bind(this);
        initView();
        kulinerKudus = getIntent().getParcelableExtra("model");
        assert kulinerKudus != null;
        tvNamaDetailKuliner.setText(kulinerKudus.getTv_namaKulinerKudus());
        tvJenisDetailKuliner.setText(kulinerKudus.getTv_JenisKulinerKudus());
        tvAlamatDetailKuliner.setText(kulinerKudus.getTv_AlamatKulinerKudus());
        tvDeskripsiDetailKuliner.setText(kulinerKudus.getTv_deskripsiKulinerKudus());
        Glide.with(this)
                .load(kulinerKudus.getIv_imgKulinerKudus())
                .into(ivImageDetailKuliner);
        Glide.with(this)
                .load(kulinerKudus.getIv_backdropKulinerKudus())
                .into(ivBackdropKuliner);
        back.setOnClickListener(v -> {
            Intent back = new Intent(DetailKulinerActivity.this, MainActivity.class);
            startActivity(back);
        });

    }

    private void initView() {

    }
}