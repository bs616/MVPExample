package com.dev.bins.mvpexample;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dev.bins.mvpexample.presenter.ImplMainPresenter;
import com.dev.bins.mvpexample.view.IMainView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements IMainView, Adapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    ImplMainPresenter mainPresenter;

    @Bind(R.id.rv)
    RecyclerView rv;
    @Bind(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new Adapter();
        adapter.setClickListener(this);
        mainPresenter = new ImplMainPresenter(this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        swipeRefresh.setOnRefreshListener(this);
    }

    @Override
    public void setRefresh(boolean refresh) {
        swipeRefresh.setRefreshing(refresh);
    }


    @Override
    public void showToast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(List<String> data) {
        adapter.setData(data);

    }

    @Override
    public void append(String append) {
        adapter.append(append);
    }

    @Override
    public void click(int position) {
        mainPresenter.onItemClick(position);
    }

    @Override
    public void onRefresh() {
        mainPresenter.appendData();
    }
}
