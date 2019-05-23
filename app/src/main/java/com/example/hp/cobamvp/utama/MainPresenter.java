package com.example.hp.cobamvp.utama;

import com.example.hp.cobamvp.base.BasePresenter;
import com.example.hp.cobamvp.model.ResultModel;

public class MainPresenter implements BasePresenter<MainView> {
    MainView    mainView;


    @Override
    public void onAttach(MainView view) {
        mainView = view;

    }
    public void calculate(String inputanSatu, String inputandua){
        if (inputanSatu.isEmpty()|| inputandua.isEmpty()){
            mainView.Error();
        }
        else {
            double valueSatu = Double.parseDouble(inputanSatu);
            double valueDua = Double.parseDouble(inputandua);
            double total = valueSatu*valueDua;
            ResultModel data = new ResultModel(String.valueOf(total));
            mainView.Success(data);
        }
    }

    @Override
    public void onDettach() {
        mainView = null;

    }


}
