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

import com.example.myproject.Adapter.MessageAdapter;
import com.example.myproject.MainActivity;
import com.example.myproject.R;
import com.example.myproject.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessagesFragment extends Fragment {
    private static final String TAG = "MessagesFragment";

    private MainActivity mainActivity;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Message> messageList=new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.message_fragment ,container,false);
        mainActivity = (MainActivity) getActivity();
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.Messages_rv);

        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        initDataList();
        adapter = new MessageAdapter(getActivity(),messageList);
        recyclerView.setAdapter(adapter);

    }

    private void initDataList() {
        messageList=new ArrayList<>();
        for(int i=1;i<=10;i++)
            messageList.add(new Message("Product "+i,
                    "This is the information of the Product "+i,
                    i+"/01/2020"));
    }


}
