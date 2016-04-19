package com.dev.bins.mvpexample.presenter;

import com.dev.bins.mvpexample.model.ImplMainModel;
import com.dev.bins.mvpexample.view.IMainView;

import java.util.List;

/**
 * Created by bin on 4/19/16.
 */
public class ImplMainPresenter implements  IMainPresenter{

    IMainView mainView;
    ImplMainModel mainModel;

    public ImplMainPresenter(IMainView mainView) {
        this.mainView = mainView;
        this.mainModel = new ImplMainModel();
        mainView.setRefresh(true);
        List<String> data = mainModel.getData();
        mainView.setData(data);
        mainView.setRefresh(false);
    }

    public void appendData(){
        mainView.append(mainModel.append());
        mainView.setRefresh(false);
    }

    @Override
    public void onItemClick(int position) {
        mainView.showToast("position:"+position);
    }
}
