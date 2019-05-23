package com.example.hp.cobamvp.utama;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.cobamvp.R;
import com.example.hp.cobamvp.model.ResultModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView{
MainPresenter presenter;
    public static final String STATE = "STATE";
    @BindView(R.id.inputan_a)
    EditText edtA;
    @BindView(R.id.inputan_b)
    EditText edtB;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.btn_calculate)
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        intPresenter();
        onAttachView();

        if (savedInstanceState != null) {
            String state = savedInstanceState.getString(STATE);
            tvResult.setText(state);
        }
    }

    private void intPresenter() {
        presenter = new MainPresenter();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE, tvResult.getText().toString().trim());

    }

    @OnClick (R.id.btn_calculate)
    public void onViewClicked(){
        presenter.calculate(edtA.getText().toString().trim(), edtB.getText().toString().trim());

    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);

    }



    @Override
    public void onDettachView() {
        presenter.onDettach();

    }



    @Override
    public void Success(ResultModel data) {
        tvResult.setText(data.getResult());

    }

    @Override
    public void Error() {
        Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        onAttachView();
        super.onStart();

    }

    @Override
    protected void onDestroy() {
        onDettachView();
        super.onDestroy();
    }
}
