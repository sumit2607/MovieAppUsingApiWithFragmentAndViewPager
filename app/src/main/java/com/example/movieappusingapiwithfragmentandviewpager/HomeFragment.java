package com.example.movieappusingapiwithfragmentandviewpager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterR adapter;
    private List<NowShowingDTO> list = new ArrayList<>();

    private FragmentManager fragmentManager;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        buildList();
        setRecyclerView();

      
    }

    private void buildList() {
        ApiService apiCall = Network.getInstance().create(ApiService.class);
       apiCall.getResponse().enqueue(new Callback<ResponseDTO>() {
           @Override
           public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
               list = response.body().getNowShowing();
           }

           @Override
           public void onFailure(Call<ResponseDTO> call, Throwable t) {

           }
       });


        }

    private void setRecyclerView() {
        adapter = new AdapterR(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}