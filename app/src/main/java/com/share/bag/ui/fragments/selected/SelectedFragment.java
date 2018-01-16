package com.share.bag.ui.fragments.selected;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.share.bag.R;
import com.share.bag.SBUrls;
import com.share.bag.adapter.PopularAdapter;
import com.share.bag.base.BaseFragment;
import com.share.bag.entity.selected.SelectedBean;
import com.share.bag.utils.okhttp.OkHttpUtils;
import com.share.bag.utils.okhttp.callback.ByteCallBack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.share.bag.R.id.Chongzhi;
import static com.share.bag.R.id.DanJianTherr;
import static com.share.bag.R.id.DanJianTwo;


/**
 * Created by Administrator on 2017/11/14.
 */
//选包
public class SelectedFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.search_et_input)
    EditText searchEtInput;
    @BindView(R.id.selected_recyclerview)
    RecyclerView selectedRecyclerview;
    @BindView(R.id.Selected_smartrefreshlayout)
    SmartRefreshLayout SelectedSmartrefreshlayout;
    Unbinder unbinder;
    @BindView(R.id.search_popular)
    LinearLayout searchPopular;
    @BindView(R.id.search_price)
    LinearLayout searchPrice;
    @BindView(R.id.search_filter)
    LinearLayout searchFilter;
    private int width;
    private int height;
    private PopularAdapter adapter;
    private Button Digeo, GaoDi, ZuGaoDi, ZuDigao;
    private Button DanJianOne, DanJiantwo, DanJiantherr, DanJinFuor;
    private Button DaL, ZhongM, XiaoS;
    private Button Coach, Hermes;
    private Button XuiXian, YanHui;
    private Button Wubai, Yiqian, Reqian, Reqingyishang;
    private Button ChongZhi,QueDing;
    private List<SelectedBean> mList=new ArrayList();
    private List<SelectedBean> mLists=new ArrayList();
    private PopupWindow window1;

    @Override
    public int initLayout() {
        return R.layout.live_fragment;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    protected void initData() {
//     设置  Manager
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        selectedRecyclerview.setLayoutManager(manager);
//        初始化 界面
        adapter = new PopularAdapter(getContext(), mList);
//        RecyclerAdapterWithHF recyclerAdapterWithHF = new RecyclerAdapterWithHF(adapter);
        selectedRecyclerview.setAdapter(adapter);

        adapter.setOnClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if(SharePreUtils.getString(Constant.COOKIE , "").isEmpty()){
//
//                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(getActivity(), "收藏成功", Toast.LENGTH_SHORT).show();
//                }
            }
        });



        getpopular();





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate aj fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);

        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.search_et_input)
    public void onViewClicked() {
        //监听


    }

    public void getpopular() {
        Map<String,String >stringMap= new HashMap<>();
        OkHttpUtils.getInstance().postByte(SBUrls.POPULAR, stringMap, new ByteCallBack() {
            @Override
            public void onSuccess(String json) {
                Gson gson = new Gson();

                List<SelectedBean> selectedBeens = gson.fromJson(json, new TypeToken<List<SelectedBean>>() {
                }.getType());
//                Log.e("TAG",selectedBeens.toString());
                mList.addAll(selectedBeens);
                mLists.addAll(selectedBeens);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });



    }

    @OnClick({R.id.search_popular, R.id.search_price, R.id.search_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search_popular:
                mList.clear();
                mList.addAll(mLists);
                adapter.notifyDataSetChanged();
//               Toast.makeText(getContext(), "点击了热门", Toast.LENGTH_SHORT).show();
                // getPopupWindow();
                break;
            case R.id.search_price:
//                Toast.makeText(getContext(), "点击了价格", Toast.LENGTH_SHORT).show();
                getPopupWindow();

                break;
            case R.id.search_filter:
//                Toast.makeText(getContext(), "点击了筛选", Toast.LENGTH_SHORT).show();

                getPopupWindowTwo();

                break;
        }
    }

    //价格
    public void getPopupWindow() {

        View inflate = View.inflate(getContext(), R.layout.popupwindow1, null);
        //控件
        Kongjian(inflate);//inflate
        window1 = new PopupWindow(inflate, width, height);
        window1.setFocusable(true);
        window1.setBackgroundDrawable(new ColorDrawable(1));
        window1.setOutsideTouchable(true);
        window1.showAsDropDown(searchPopular);

    }

    //获取价格控件
    private void Kongjian(View inflate) {
        Digeo = inflate.findViewById(R.id.DiGao);
        Digeo.setOnClickListener(this);
        GaoDi = inflate.findViewById(R.id.GaoDi);
        GaoDi.setOnClickListener(this);
        ZuDigao = inflate.findViewById(R.id.ZuDiGao);
        ZuDigao.setOnClickListener(this);
        ZuGaoDi = inflate.findViewById(R.id.ZuGaoDi);
        ZuGaoDi.setOnClickListener(this);
    }

    //筛选
    public void getPopupWindowTwo() {
        View inflate = View.inflate(getContext(), R.layout.popupwindowtwo, null);
        ShaixuanKongjain(inflate);//控件
        PopupWindow window = new PopupWindow(inflate, width, height);
        window.setFocusable(true);
        window.setBackgroundDrawable(new ColorDrawable(1));
        window.setOutsideTouchable(true);
        window.showAsDropDown(searchPopular);
    }

    //获取筛选控件
    private void ShaixuanKongjain(View inflate) {
        DanJianOne = inflate.findViewById(R.id.DanJianOne);
        DanJianOne.setOnClickListener(this);
        DanJiantwo = inflate.findViewById(DanJianTwo);
        DanJiantwo.setOnClickListener(this);
        DanJiantherr = inflate.findViewById(DanJianTherr);
        DanJiantherr.setOnClickListener(this);
        DanJinFuor = inflate.findViewById(R.id.DanJianFour);
        DanJinFuor.setOnClickListener(this);
        DaL = inflate.findViewById(R.id.DaL);
        DaL.setOnClickListener(this);
        ZhongM = inflate.findViewById(R.id.ZhongM);
        ZhongM.setOnClickListener(this);
        XiaoS = inflate.findViewById(R.id.XiaoS);
        XiaoS.setOnClickListener(this);
        Coach = inflate.findViewById(R.id.Coach);
        Coach.setOnClickListener(this);
        Hermes = inflate.findViewById(R.id.Hermes);
        Hermes.setOnClickListener(this);
        XuiXian = inflate.findViewById(R.id.XuiXian);
        XuiXian.setOnClickListener(this);
        YanHui = inflate.findViewById(R.id.YanHui);
        YanHui.setOnClickListener(this);
        Wubai = inflate.findViewById(R.id.Wubai);
        Wubai.setOnClickListener(this);
        Yiqian = inflate.findViewById(R.id.Yiqian);
        Yiqian.setOnClickListener(this);
        Reqian = inflate.findViewById(R.id.Reqian);
        Reqian.setOnClickListener(this);
        Reqingyishang = inflate.findViewById(R.id.Reqianyishang);
        Reqingyishang.setOnClickListener(this);
        ChongZhi=inflate.findViewById(Chongzhi);
        ChongZhi.setOnClickListener(this);
        QueDing=inflate.findViewById(R.id.QueDing);
        QueDing.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //价格从高到低
            case R.id.DiGao:

//                if (Digeo.isSelected()) {
//                    Digeo.setSelected(false);
//                    Digeo.setBackground(getResources().getDrawable(R.drawable.textview));
//                } else {
//                    ZuDigao.setSelected(false);
//                    ZuDigao.setBackground(getResources().getDrawable(R.drawable.textview));
//                    Digeo.setSelected(true);
//                    Digeo.setBackground(getResources().getDrawable(R.drawable.red));
//                    ZuGaoDi.setSelected(false);
//                    ZuGaoDi.setBackground(getResources().getDrawable(R.drawable.textview));
//                    GaoDi.setSelected(false);
//                    GaoDi.setBackground(getResources().getDrawable(R.drawable.textview));
//                }
                mList.clear();
                Map<String, String> map4 = new HashMap<>();
                map4.put("type",2+"");
                map4.put("priceType",4+"");
                OkHttpUtils.getInstance().postByte(SBUrls.JIAZHEN, map4, new ByteCallBack() {
                    @Override
                    public void onSuccess(String json) {
                        Gson gson = new Gson();
                        List<SelectedBean> selectBeen = gson.fromJson(json, new TypeToken<List<SelectedBean>>() {}.getType());
                        mList.addAll(selectBeen);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });
                window1.dismiss();
                break;
            //价格从低到高
            case R.id.GaoDi:
//                if (GaoDi.isSelected()) {
//                    GaoDi.setSelected(false);
//                    GaoDi.setBackground(getResources().getDrawable(R.drawable.textview));
//                } else {
//                    ZuDigao.setSelected(false);
//                    ZuDigao.setBackground(getResources().getDrawable(R.drawable.textview));
//                    GaoDi.setSelected(true);
//                    GaoDi.setBackground(getResources().getDrawable(R.drawable.red));
//                    Digeo.setSelected(false);
//                    Digeo.setBackground(getResources().getDrawable(R.drawable.textview));
//                    ZuGaoDi.setSelected(false);
//                    ZuGaoDi.setBackground(getResources().getDrawable(R.drawable.textview));
//                }
                mList.clear();
                Map<String, String> map3 = new HashMap<>();
                map3.put("type ",2+"");
                map3.put("priceType",3+"");
                OkHttpUtils.getInstance().postByte(SBUrls.JIAZHEN, map3, new ByteCallBack() {
                    @Override
                    public void onSuccess(String json) {
                        Gson gson = new Gson();
                        List<SelectedBean> selectBeen = gson.fromJson(json, new TypeToken<List<SelectedBean>>() {}.getType());
                        mList.addAll(selectBeen);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });
                window1.dismiss();
                break;
            //租金从低到高
            case R.id.ZuDiGao:
//                if (ZuDigao.isSelected()) {
//                    ZuDigao.setSelected(false);
//                    ZuDigao.setBackground(getResources().getDrawable(R.drawable.textview));
//                } else {
//                    ZuDigao.setSelected(true);
//                    ZuDigao.setBackground(getResources().getDrawable(R.drawable.red));
//                    Digeo.setSelected(false);
//                    Digeo.setBackground(getResources().getDrawable(R.drawable.textview));
//                    ZuGaoDi.setSelected(false);
//                    ZuGaoDi.setBackground(getResources().getDrawable(R.drawable.textview));
//                    GaoDi.setSelected(false);
//                    GaoDi.setBackground(getResources().getDrawable(R.drawable.textview));
//                }
                mList.clear();
                Map<String, String> map2 = new HashMap<>();
                map2.put("type ",2+"");
                map2.put("priceType",2+" ");
                OkHttpUtils.getInstance().postByte(SBUrls.JIAZHEN, map2, new ByteCallBack() {
                    @Override
                    public void onSuccess(String json) {
                        Gson gson = new Gson();
                        List<SelectedBean> selectBeen = gson.fromJson(json, new TypeToken<List<SelectedBean>>() {
                        }.getType());
                        mList.addAll(selectBeen);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });
                window1.dismiss();
                break;
            //租金从高到低
            case R.id.ZuGaoDi:
//                if (ZuGaoDi.isSelected()) {
//                    ZuGaoDi.setSelected(false);
//                    ZuGaoDi.setBackground(getResources().getDrawable(R.drawable.textview));
//                } else {
//                    ZuDigao.setSelected(false);
//                    ZuDigao.setBackground(getResources().getDrawable(R.drawable.textview));
//                    ZuGaoDi.setSelected(true);
//                    ZuGaoDi.setBackground(getResources().getDrawable(R.drawable.red));
//                    Digeo.setSelected(false);
//                    Digeo.setBackground(getResources().getDrawable(R.drawable.textview));
//                    GaoDi.setSelected(false);
//                    GaoDi.setBackground(getResources().getDrawable(R.drawable.textview));
//                }
                mList.clear();
                Map<String, String> map1 = new HashMap<>();
                map1.put("type ",2+"");
                map1.put("priceType",1+"");
                OkHttpUtils.getInstance().postByte(SBUrls.JIAZHEN, map1, new ByteCallBack() {
                    @Override
                    public void onSuccess(String json) {
                        Gson gson = new Gson();
                        List<SelectedBean> selectBeen = gson.fromJson(json, new TypeToken<List<SelectedBean>>() {
                        }.getType());
                        mList.addAll(selectBeen);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });
                window1.dismiss();
                break;
            //单肩One
            case R.id.DanJianOne:
                if (DanJianOne.isSelected()) {
                    DanJianOne.setSelected(false);
                    DanJianOne.setBackground(getResources().getDrawable(R.drawable.textview));
                } else {
                    DanJianOne.setSelected(true);
                    DanJianOne.setBackground(getResources().getDrawable(R.drawable.red));
                    DanJinFuor.setSelected(false);
                    DanJinFuor.setBackground(getResources().getDrawable(R.drawable.textview));
                    DanJiantherr.setSelected(false);
                    DanJiantherr.setBackground(getResources().getDrawable(R.drawable.textview));
                    DanJiantwo.setSelected(false);
                    DanJiantwo.setBackground(getResources().getDrawable(R.drawable.textview));
                }
                break;
            //单肩Two
            case DanJianTwo:
                if (DanJiantwo.isSelected()) {
                    DanJiantwo.setSelected(false);
                    DanJiantwo.setBackground(getResources().getDrawable(R.drawable.textview));
                } else {
                    DanJiantwo.setSelected(true);
                    DanJiantwo.setBackground(getResources().getDrawable(R.drawable.red));
                    DanJianOne.setSelected(false);
                    DanJianOne.setBackground(getResources().getDrawable(R.drawable.textview));
                    DanJinFuor.setSelected(false);
                    DanJinFuor.setBackground(getResources().getDrawable(R.drawable.textview));
                    DanJiantherr.setSelected(false);
                    DanJiantherr.setBackground(getResources().getDrawable(R.drawable.textview));
                }
                break;
            //单肩Therr
            case DanJianTherr:
                if (DanJiantherr.isSelected()) {
                    DanJiantherr.setSelected(false);
                    DanJiantherr.setBackground(getResources().getDrawable(R.drawable.textview));
                } else {
                    DanJiantherr.setSelected(true);
                    DanJiantherr.setBackground(getResources().getDrawable(R.drawable.red));
                    DanJianOne.setSelected(false);
                    DanJinFuor.setSelected(false);
                    DanJinFuor.setBackground(getResources().getDrawable(R.drawable.textview));
                    DanJiantwo.setSelected(false);
                    DanJiantwo.setBackground(getResources().getDrawable(R.drawable.textview));
                }
                break;
            //单肩Four
            case R.id.DanJianFour:
                if (DanJinFuor.isSelected()) {
                    DanJinFuor.setSelected(false);
                    DanJinFuor.setBackground(getResources().getDrawable(R.drawable.textview));
                } else {
                    DanJinFuor.setSelected(true);
                    DanJinFuor.setBackground(getResources().getDrawable(R.drawable.red));
                    DanJianOne.setSelected(false);
                    DanJianOne.setBackground(getResources().getDrawable(R.drawable.textview));
                    DanJiantherr.setSelected(false);
                    DanJiantherr.setBackground(getResources().getDrawable(R.drawable.textview));
                    DanJiantwo.setSelected(false);
                    DanJiantwo.setBackground(getResources().getDrawable(R.drawable.textview));

                }
                break;
            //大L
            case R.id.DaL:
                if (DaL.isSelected()) {
                    DaL.setSelected(false);
                    DaL.setBackground(getResources().getDrawable(R.drawable.textview));
                } else {
                    DaL.setSelected(true);
                    DaL.setBackground(getResources().getDrawable(R.drawable.red));
                    ZhongM.setSelected(false);
                    ZhongM.setBackground(getResources().getDrawable(R.drawable.textview));
                    XiaoS.setSelected(false);
                    XiaoS.setBackground(getResources().getDrawable(R.drawable.textview));
                }
                break;
            //中M
            case R.id.ZhongM:
                if (DaL.isSelected()) {
                    ZhongM.setSelected(false);
                    ZhongM.setBackground(getResources().getDrawable(R.drawable.textview));
                } else {
                    ZhongM.setSelected(true);
                    ZhongM.setBackground(getResources().getDrawable(R.drawable.red));
                    DaL.setSelected(false);
                    DaL.setBackground(getResources().getDrawable(R.drawable.textview));
                    XiaoS.setSelected(false);
                    XiaoS.setBackground(getResources().getDrawable(R.drawable.textview));
                }

                break;
            //小S
            case R.id.XiaoS:
                if (XiaoS.isSelected()) {
                    XiaoS.setSelected(false);
                    XiaoS.setBackground(getResources().getDrawable(R.drawable.textview));
                } else {
                    XiaoS.setSelected(true);
                    XiaoS.setBackground(getResources().getDrawable(R.drawable.red));
                    DaL.setSelected(false);
                    DaL.setBackground(getResources().getDrawable(R.drawable.textview));
                    ZhongM.setSelected(false);
                    ZhongM.setBackground(getResources().getDrawable(R.drawable.textview));

                }
                break;
            //Coach
            case R.id.Coach:
                if (Coach.isSelected()) {
                    Coach.setSelected(false);
                    Coach.setBackground(getResources().getDrawable(R.drawable.textview));
                } else {
                    Coach.setSelected(true);
                    Coach.setBackground(getResources().getDrawable(R.drawable.red));
                    Hermes.setSelected(false);
                    Hermes.setBackground(getResources().getDrawable(R.drawable.textview));
                }
                break;
            //Hermes
            case R.id.Hermes:
                if (Hermes.isSelected()) {
                    Hermes.setSelected(false);
                    Hermes.setBackground(getResources().getDrawable(R.drawable.textview));
                } else {
                    Hermes.setSelected(true);
                    Hermes.setBackground(getResources().getDrawable(R.drawable.red));
                    Coach.setSelected(false);
                    Coach.setBackground(getResources().getDrawable(R.drawable.textview));

                }
                break;
            //休闲度假
            case R.id.XuiXian:
                if (XuiXian.isSelected()) {
                    XuiXian.setSelected(false);
                    XuiXian.setBackground(getResources().getDrawable(R.drawable.textview));
                } else {
                    XuiXian.setSelected(true);
                    XuiXian.setBackground(getResources().getDrawable(R.drawable.red));
                    YanHui.setSelected(false);
                    YanHui.setBackground(getResources().getDrawable(R.drawable.textview));
                }
                break;
            //宴会轻奢
            case R.id.YanHui:
                if (YanHui.isSelected()) {
                    YanHui.setSelected(false);
                    YanHui.setBackground(getResources().getDrawable(R.drawable.textview));
                } else {
                    YanHui.setSelected(true);
                    YanHui.setBackground(getResources().getDrawable(R.drawable.red));
                    XuiXian.setSelected(false);
                    XuiXian.setBackground(getResources().getDrawable(R.drawable.textview));

                }
                break;
            //500以下
            case R.id.Wubai:
                if (Wubai.isSelected()) {
                    Wubai.setSelected(false);
                    Wubai.setBackground(getResources().getDrawable(R.drawable.textview));
                } else {
                    Wubai.setSelected(true);
                    Wubai.setBackground(getResources().getDrawable(R.drawable.red));
                    Reqingyishang.setSelected(false);
                    Reqingyishang.setBackground(getResources().getDrawable(R.drawable.textview));
                    Reqian.setSelected(false);
                    Reqian.setBackground(getResources().getDrawable(R.drawable.textview));
                    Yiqian.setSelected(false);
                    Yiqian.setBackground(getResources().getDrawable(R.drawable.textview));
                   }
                break;
            //500-1000
            case R.id.Yiqian:
                if (Yiqian.isSelected()) {
                    Yiqian.setSelected(false);
                    Yiqian.setBackground(getResources().getDrawable(R.drawable.textview));

                } else {
                    Yiqian.setSelected(true);
                    Yiqian.setBackground(getResources().getDrawable(R.drawable.red));
                    Reqingyishang.setSelected(false);
                    Reqingyishang.setBackground(getResources().getDrawable(R.drawable.textview));
                    Reqian.setSelected(false);
                    Reqian.setBackground(getResources().getDrawable(R.drawable.textview));
                    Wubai.setSelected(false);
                    Wubai.setBackground(getResources().getDrawable(R.drawable.textview));
                }
                break;
            //1000-2000
            case R.id.Reqian:
                if (Reqian.isSelected()) {
                    Reqian.setSelected(false);
                    Reqian.setBackground(getResources().getDrawable(R.drawable.textview));
                } else {
                    Reqian.setSelected(true);
                    Reqian.setBackground(getResources().getDrawable(R.drawable.red));
                    Wubai.setSelected(false);
                    Wubai.setBackground(getResources().getDrawable(R.drawable.textview));
                    Reqingyishang.setSelected(false);
                    Reqingyishang.setBackground(getResources().getDrawable(R.drawable.textview));
                    Yiqian.setSelected(false);
                    Yiqian.setBackground(getResources().getDrawable(R.drawable.textview));
                }
                break;
            //2000以上
            case R.id.Reqianyishang:
                if (Reqingyishang.isSelected()) {
                    Reqingyishang.setSelected(false);
                    Reqingyishang.setBackground(getResources().getDrawable(R.drawable.textview));
                } else {
                    Reqingyishang.setSelected(true);
                    Reqingyishang.setBackground(getResources().getDrawable(R.drawable.red));
                    Wubai.setSelected(false);
                    Wubai.setBackground(getResources().getDrawable(R.drawable.textview));
                    Reqian.setSelected(false);
                    Reqian.setBackground(getResources().getDrawable(R.drawable.textview));
                    Yiqian.setSelected(false);
                    Yiqian.setBackground(getResources().getDrawable(R.drawable.textview));
                }
                break;
            //重置
            case Chongzhi:
//                    ChongZhi.setSelected(true);
//                    ChongZhi.setBackground(getResources().getDrawable(R.drawable.red));
                    Reqingyishang.setSelected(true);
                    Reqingyishang.setBackground(getResources().getDrawable(R.drawable.red));
                    Wubai.setSelected(false);
                    Wubai.setBackground(getResources().getDrawable(R.drawable.textview));
                    Reqian.setSelected(false);
                    Reqian.setBackground(getResources().getDrawable(R.drawable.textview));
                    Yiqian.setSelected(false);
                    Yiqian.setBackground(getResources().getDrawable(R.drawable.textview));
                    Reqingyishang.setSelected(false);
                    Reqingyishang.setBackground(getResources().getDrawable(R.drawable.textview));
                XuiXian.setSelected(false);
                XuiXian.setBackground(getResources().getDrawable(R.drawable.textview));
                YanHui.setSelected(false);
                YanHui.setBackground(getResources().getDrawable(R.drawable.textview));
                DaL.setSelected(false);
                DaL.setBackground(getResources().getDrawable(R.drawable.textview));
                ZhongM.setSelected(false);
                ZhongM.setBackground(getResources().getDrawable(R.drawable.textview));
                XiaoS.setSelected(false);
                XiaoS.setBackground(getResources().getDrawable(R.drawable.textview));
                Coach.setSelected(false);
                Coach.setBackground(getResources().getDrawable(R.drawable.textview));
                Hermes.setSelected(false);
                Hermes.setBackground(getResources().getDrawable(R.drawable.textview));
                DanJianOne.setSelected(false);
                DanJianOne.setBackground(getResources().getDrawable(R.drawable.textview));
                DanJiantherr.setSelected(false);
                DanJiantherr.setBackground(getResources().getDrawable(R.drawable.textview));
                DanJiantwo.setSelected(false);
                DanJiantwo.setBackground(getResources().getDrawable(R.drawable.textview));
                DanJinFuor.setSelected(false);
                DanJinFuor.setBackground(getResources().getDrawable(R.drawable.textview));
                 break;
        }
    }
}
