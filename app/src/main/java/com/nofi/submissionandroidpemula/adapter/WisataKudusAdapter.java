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
import com.nofi.submissionandroidpemula.fragment.WisataKudusFragment;
import com.nofi.submissionandroidpemula.model.WisataKudus;
import com.nofi.submissionandroidpemula.presenter.InterfaceWisataKudus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class WisataKudusAdapter extends RecyclerView.Adapter<WisataKudusAdapter.ViewHolder> {

    private ArrayList<WisataKudus> list;
    private Context context;
    private InterfaceWisataKudus interfaceWisataKudus;


    public WisataKudusAdapter(ArrayList<WisataKudus> list, Context context, WisataKudusFragment interfaceWisataKudus) {
        this.list = list;
        this.context = context;
        this.interfaceWisataKudus = interfaceWisataKudus;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_wisata, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.tvJudul.setText(list.get(i).getTv_namaWisataKudus());
        holder.tvDeskripsiWisata.setText(list.get(i).getTv_deskripsiWisataKudus());
        holder.tvJenisWisata.setText(list.get(i).getTv_JenisWisataKudus());
        holder.tvAlamat.setText(list.get(i).getTv_AlamatWisataKudus());
        Glide.with(context).load(list.get(i).getIv_imgWisataKudus()).into(holder.ivGambar);

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
        //Menghitung data / ukuran dari Array
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final Unbinder unbinder;
        @BindView(R.id.iv_imgWisata)
        ImageView ivGambar;
        @BindView(R.id.tv_namaWisata)
        TextView tvJudul;
        @BindView(R.id.btn_profil)
        Button btnProfil;
        @BindView(R.id.tv_deskripsiWisata)
        TextView tvDeskripsiWisata;
        @BindView(R.id.tv_jenisWisata)
        TextView tvJenisWisata;
        @BindView(R.id.tv_alamat)
        TextView tvAlamat;
        @BindView(R.id.btn_ShareWisata)
        Button btnShare;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
            //onclick
            itemView.setOnClickListener(view -> interfaceWisataKudus.intentDetailWisata(list.get(getAdapterPosition())));
        }
    }
}