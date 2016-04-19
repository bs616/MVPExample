package com.dev.bins.mvpexample.view;

import java.util.List;

/**
 * Created by bin on 4/19/16.
 */
public interface IMainView {

    void setRefresh(boolean refresh);
    void showToast(String s);
    void setData(List<String> data);
    void append(String append);
}
