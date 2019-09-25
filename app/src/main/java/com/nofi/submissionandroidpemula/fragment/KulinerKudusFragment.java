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
import com.nofi.submissionandroidpemula.activity.detail.DetailKulinerActivity;
import com.nofi.submissionandroidpemula.adapter.KulinerKudusAdapter;
import com.nofi.submissionandroidpemula.model.KulinerKudus;
import com.nofi.submissionandroidpemula.presenter.InterfaceKulinerKudus;

import java.util.ArrayList;

public class KulinerKudusFragment extends Fragment implements InterfaceKulinerKudus {
    private TypedArray dataGambarKuliner;
    private TypedArray dataBackdropKuliner;
    private String[] dataNamaKuliner;
    private String[] dataDeskripsiKuliner;
    private String[] dataJenisKuliner;
    private ArrayList<KulinerKudus> nkulinerkudus;
    private KulinerKudusAdapter adapter;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.kuliner_kudus_fragment, container, false);
        prepare();
        addItem();
        mRecyclerView = rootView.findViewById(R.id.recyclerViewKuliner);
        adapter = new KulinerKudusAdapter(nkulinerkudus, getActivity(), this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setHasFixedSize(true);

        return rootView;
    }

    private void addItem() {
        nkulinerkudus = new ArrayList<>();

        for (int i = 0; i < dataNamaKuliner.length; i++) {
            KulinerKudus kulinerKudus = new KulinerKudus();
            kulinerKudus.setIv_imgKulinerKudus(dataGambarKuliner.getResourceId(i, -1));
            kulinerKudus.setIv_backdropKulinerKudus(dataBackdropKuliner.getResourceId(i, -1));
            kulinerKudus.setTv_namaKulinerKudus(dataNamaKuliner[i]);
            kulinerKudus.setTv_JenisKulinerKudus(dataJenisKuliner[i]);
            kulinerKudus.setTv_deskripsiKulinerKudus(dataDeskripsiKuliner[i]);
            nkulinerkudus.add(kulinerKudus);
        }
    }


    private void prepare() {
        dataGambarKuliner = getResources().obtainTypedArray(R.array.asset_gambarKuliner);
        dataBackdropKuliner = getResources().obtainTypedArray(R.array.asset_backdropkuliner);
        dataNamaKuliner = getResources().getStringArray(R.array.asset_namaKuliner);
        dataJenisKuliner = getResources().getStringArray(R.array.asset_jeniskuliner);
        dataDeskripsiKuliner = getResources().getStringArray(R.array.asset_deskripsikuliner);
    }

    @Override
    public void intentDetailKuliner(KulinerKudus kulinerKudus) {
        Intent intent = new Intent(getActivity(), DetailKulinerActivity.class);
        intent.putExtra("model", kulinerKudus);
        startActivity(intent);
    }

}