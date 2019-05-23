package com.example.hp.cobamvp.utama;

import com.example.hp.cobamvp.base.BaseView;
import com.example.hp.cobamvp.model.ResultModel;

public interface MainView extends BaseView {


    void Success(ResultModel data);

    void Error();
}