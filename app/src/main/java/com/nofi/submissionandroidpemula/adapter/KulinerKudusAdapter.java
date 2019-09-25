package com.nofi.submissionandroidpemula.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nofi.submissionandroidpemula.R;
import com.nofi.submissionandroidpemula.activity.ProfilNofiActivity;
import com.nofi.submissionandroidpemula.fragment.KulinerKudusFragment;
import com.nofi.submissionandroidpemula.model.KulinerKudus;
import com.nofi.submissionandroidpemula.presenter.InterfaceKulinerKudus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class KulinerKudusAdapter extends RecyclerView.Adapter<KulinerKudusAdapter.ViewHolder> {
    private ArrayList<KulinerKudus> list;
    private Context context;
    private InterfaceKulinerKudus interfaceKulinerKudus;


    public KulinerKudusAdapter(ArrayList<KulinerKudus> list, Context context, KulinerKudusFragment interfaceKulinerKudus) {
        this.list = list;
        this.context = context;
        this.interfaceKulinerKudus = interfaceKulinerKudus;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_kuliner, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.tvJudul.setText(list.get(i).getTv_namaKulinerKudus());
        holder.tvDeskripsiKuliner.setText((list.get(i).getTv_deskripsiKulinerKudus()));
        holder.tvJenisKuliner.setText(list.get(i).getTv_JenisKulinerKudus());
        Glide.with(context).load(list.get(i).getIv_imgKulinerKudus()).into(holder.ivGambar);

        holder.btnProfil.setOnClickListener(v -> {
            Intent profil = new Intent(context, ProfilNofiActivity.class);
            context.startActivity(profil);
        });

        holder.btnShare.setOnClickListener(v -> {
            Toast.makeText(context, "Tunggu Sebentar...Anda masuk ke media sosial WA", Toast.LENGTH_LONG).show();
            Intent sharingIntent = new Intent(Intent.ACTION_VIEW);
            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            sharingIntent.setData(Uri.parse("https://web.whatsapp.com/"));
            context.startActivity(sharingIntent);
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final Unbinder unbinder;
        @BindView(R.id.tv_jenisKuliner)
        TextView tvJenisKuliner;
        @BindView(R.id.iv_imgWisataKuliner)
        ImageView ivGambar;
        @BindView(R.id.tv_namaWisataKuliner)
        TextView tvJudul;
        @BindView(R.id.tv_deskripsiKuliner)
        TextView tvDeskripsiKuliner;
        @BindView(R.id.btn_profil)
        Button btnProfil;
        @BindView(R.id.btn_ShareKuliner)
        Button btnShare;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(view -> interfaceKulinerKudus.intentDetailKuliner(list.get(getAdapterPosition())));
        }
    }
}