package com.dev.bins.mvpexample.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bin on 4/19/16.
 */
public class ImplMainModel implements IMainModel {
    @Override
    public List<String> getData() {
        return Arrays.asList("item0","item1","item2","item3","item4","item5",
                "itme6","itme7","item8","item9");
    }

    @Override
    public String append() {
        return "item";
    }
}
