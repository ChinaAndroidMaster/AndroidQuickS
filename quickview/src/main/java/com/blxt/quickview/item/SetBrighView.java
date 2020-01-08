package com.blxt.quickview.item;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.blxt.quicktools.system.Brightness;
import com.blxt.quickview.R;
import com.blxt.quickview.dialog.BaseSeekbarDialog;
import com.blxt.quickview.dialog.BrightnessDialog;


/**
 * 设置亮度
 * @author Zhang
 */
public class SetBrighView extends BaseSetItemView  {


    private ImageView iv_right; // 右边箭头
    Activity activity;

    public SetBrighView(Activity activity, String title) {
        super(activity);
        this.activity = activity;

        instance = this;
        LayoutInflater.from(getContext()).inflate(R.layout.__item_set__simple,this);

        iv_bottom =findViewById(R.id._item_bottom);
        iv_logo =findViewById(R.id._item_title_ic);
        tv_title =findViewById(R.id._item_title);
        tv_hint = findViewById(R.id._item_tip);
        iv_right = findViewById(R.id._item_iright); //

        setTitle(title);
        initview();

        tv_hint.setText("" + Brightness.getBrightness(getContext()));

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean fal = true;
                if(clickListener != null){
                    fal = clickListener.onClickSetItem(instance);
                }
                if (fal){
                    BrightnessDialog brightnessDialog = new BrightnessDialog(getActivity());
                    brightnessDialog.setBackCancelable(new BaseSeekbarDialog.SeekBarCallBack(){

                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i) {
                            tv_hint.setText("" + i);
                            saveValue("" + i);
                        }
                    });
                    brightnessDialog.show();
                }

            }
        });
    }


    public void setEnabled(boolean isbootom){
        this.setEnabled(isbootom);
    }


    public Activity getActivity(){
        return activity;
    }
}