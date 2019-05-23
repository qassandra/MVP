package com.example.hp.cobamvp.base;

public interface BasePresenter <T extends BaseView> {
    void  onAttach (T View);
    void onDettach ();

}
