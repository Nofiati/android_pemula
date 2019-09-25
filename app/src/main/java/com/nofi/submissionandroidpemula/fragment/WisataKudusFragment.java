package com.nofi.submissionandroidpemula.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nofi.submissionandroidpemula.R;
import com.nofi.submissionandroidpemula.activity.detail.DetailWisataActivity;
import com.nofi.submissionandroidpemula.adapter.WisataKudusAdapter;
import com.nofi.submissionandroidpemula.model.WisataKudus;
import com.nofi.submissionandroidpemula.presenter.InterfaceWisataKudus;

import java.util.ArrayList;

public class WisataKudusFragment extends Fragment implements InterfaceWisataKudus {
    private TypedArray dataGambarWisata;
    private TypedArray dataBackdropWisata;
    private String[] dataNamaWisata;
    private String[] dataDeskripsiWisata;
    private String[] dataJenisWisata;
    private String[] dataAlamatWisata;
    private ArrayList<WisataKudus> mwisatakudus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wisata_kudus_fragment, container, false);
        prepare();
        addItem();
        RecyclerView mRecyclerView = rootView.findViewById(R.id.recyclerView);
        WisataKudusAdapter adapter = new WisataKudusAdapter(mwisatakudus, getActivity(), this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setHasFixedSize(true);

        return rootView;
    }

    private void addItem() {
        mwisatakudus = new ArrayList<>();

        for (int i = 0; i < dataNamaWisata.length; i++) {
            WisataKudus wisataKudus = new WisataKudus();
            wisataKudus.setIv_imgWisataKudus(dataGambarWisata.getResourceId(i, -1));
            wisataKudus.setIv_backdropWisataKudus(dataBackdropWisata.getResourceId(i, -1));
            wisataKudus.setTv_namaWisataKudus(dataNamaWisata[i]);
            wisataKudus.setTv_deskripsiWisataKudus(dataDeskripsiWisata[i]);
            wisataKudus.setTv_JenisWisataKudus(dataJenisWisata[i]);
            wisataKudus.setTv_AlamatWisataKudus(dataAlamatWisata[i]);
            mwisatakudus.add(wisataKudus);
        }
    }


    private void prepare() {
        dataGambarWisata = getResources().obtainTypedArray(R.array.asset_gambarWisata);
        dataBackdropWisata = getResources().obtainTypedArray(R.array.asset_backdropWisata);
        dataNamaWisata = getResources().getStringArray(R.array.asset_namaWisata);
        dataDeskripsiWisata = getResources().getStringArray(R.array.asset_deskripsiwisata);
        dataJenisWisata = getResources().getStringArray(R.array.asset_jeniswisata);
        dataAlamatWisata = getResources().getStringArray(R.array.asset_alamatwisata);
    }

    @Override
    public void intentDetailWisata(WisataKudus wisataKudus) {
        Intent intent = new Intent(getActivity(), DetailWisataActivity.class);
        intent.putExtra("model", wisataKudus);
        startActivity(intent);
    }
}