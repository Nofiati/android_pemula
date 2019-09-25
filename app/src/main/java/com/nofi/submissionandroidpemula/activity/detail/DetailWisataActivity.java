package com.nofi.submissionandroidpemula.activity.detail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.nofi.submissionandroidpemula.R;
import com.nofi.submissionandroidpemula.activity.MainActivity;
import com.nofi.submissionandroidpemula.model.WisataKudus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailWisataActivity extends AppCompatActivity {

    WisataKudus wisataKudus;
    @BindView(R.id.tv_namaDetailWisata)
    TextView tvNamaDetailWisata;
    @BindView(R.id.iv_backdropWisata)
    ImageView ivBackdropWisata;
    @BindView(R.id.iv_imageDetailWisata)
    ImageView ivImageWisata;
    @BindView(R.id.tv_alamatDetailWisata)
    TextView tvAlamatWisata;
    @BindView(R.id.tv_jenisDetailWisata)
    TextView tvJenisDetailWisata;
    @BindView(R.id.tv_deskripsiDetailWisata)
    TextView tvDeskripsiDetailWisata;
    @BindView(R.id.back)
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);
        ButterKnife.bind(this);
        initView();
        wisataKudus = getIntent().getParcelableExtra("model");
        assert wisataKudus != null;
        tvNamaDetailWisata.setText(wisataKudus.getTv_namaWisataKudus());
        tvJenisDetailWisata.setText(wisataKudus.getTv_JenisWisataKudus());
        tvAlamatWisata.setText(wisataKudus.getTv_AlamatWisataKudus());
        tvDeskripsiDetailWisata.setText(wisataKudus.getTv_deskripsiWisataKudus());
        Glide.with(this)
                .load(wisataKudus.getIv_imgWisataKudus())
                .into(ivImageWisata);
        Glide.with(this)
                .load(wisataKudus.getIv_backdropWisataKudus())
                .into(ivBackdropWisata);
        back.setOnClickListener(v -> {
            Intent back = new Intent(DetailWisataActivity.this, MainActivity.class);
            startActivity(back);
        });

    }

    private void initView() {

    }
}