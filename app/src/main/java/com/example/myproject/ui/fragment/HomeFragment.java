package com.example.myproject.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.Adapter.HomeAdapter;
import com.example.myproject.MainActivity;
import com.example.myproject.R;
import com.example.myproject.model.Home;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    private MainActivity mainActivity;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Home> homeList=new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_fragment,container,false);
        mainActivity = (MainActivity) getActivity();
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.home_rv);

        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        initHomeList();

        adapter = new HomeAdapter(getActivity(),homeList);
        recyclerView.setAdapter(adapter);

    }



    private void initHomeList() {
        homeList=new ArrayList<>();
        homeList.add(new Home("Product 1","Order ID : OP1011","To Be Reviewed"));
        homeList.add(new Home("Product 2","Order ID : OP1012","To Be Reviewed"));
        homeList.add(new Home("Product 3","Order ID : OP1013","To Be Reviewed"));
        homeList.add(new Home("Product 4","Order ID : OP1014","To Be Reviewed"));

    }


}
