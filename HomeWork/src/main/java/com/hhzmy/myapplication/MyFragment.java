package com.hhzmy.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hhzmy.myapplication.bean.Data;
import com.hhzmy.myapplication.httputil.OkHttp;
import com.hhzmy.myapplication.view.PullBaseView;
import com.hhzmy.myapplication.view.PullRecyclerView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;


public class MyFragment extends Fragment implements PullBaseView.OnFooterRefreshListener,PullBaseView.OnHeaderRefreshListener{
    private String url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=39986&encode=2092d7eb33e8ea0a7a2113f2d9886c90&category_id=17";
    private Data data;
    private MyAdapter adapter;
    private String name;
    private List<Data.DataBean> list;
    private PullRecyclerView mRecyclerView;
    public MyFragment(String name) {
        // TODO Auto-generated constructor stub
        this.name=name;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ImageLoaderConfiguration builder=new ImageLoaderConfiguration.Builder(getContext()).build();
        ImageLoader.getInstance().init(builder);
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_my, container,false);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView tt=(TextView) getView().findViewById(R.id.tt);
        mRecyclerView =(PullRecyclerView)  getView().findViewById(R.id.id_recyclerview);

        mRecyclerView.setOnHeaderRefreshListener(this);//设置下拉监听
        mRecyclerView.setOnFooterRefreshListener(this);//设置上拉监听
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        tt.setText(name);
        OkHttp.getAsync(url, new OkHttp.DataCallBack() {

            @Override
            public void requestFailure(Request request, IOException e) {
            }
            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson=new Gson();
                data = gson.fromJson(result,Data.class);
                list = data.getData();
                adapter = new MyAdapter(getContext(),list);
                mRecyclerView.setAdapter(adapter);

            }
        });
        mRecyclerView.addOnItemTouchListener(new RecyclerViewClickListener(getContext(), new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(),"Click "+list.get(position).getGoods_name(),Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getActivity(), AnimatorActivity.class);
//
//                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(getContext(),"Long Click "+list.get(position).getGoods_name(),Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public void onFooterRefresh(PullBaseView view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // mDatas.add("TEXT更多");
                adapter.notifyDataSetChanged();
                mRecyclerView.onFooterRefreshComplete();
            }
        }, 2000);
    }

    @Override
    public void onHeaderRefresh(PullBaseView view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //  mDatas.add(0, "TEXT新增");
                adapter.notifyDataSetChanged();
                mRecyclerView.onHeaderRefreshComplete();
            }
        }, 3000);
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
            private Context context;
            private ArrayList<Data.DataBean> list;
            public MyAdapter(Context context,List<Data.DataBean> list){
                this.context=context;
                this.list= (ArrayList<Data.DataBean>) list;
            }

            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                        getContext()).inflate(R.layout.item_home, parent,
                        false));
                return holder;
            }
            @Override
            public void onBindViewHolder(MyViewHolder holder, int position) {
                //holder.tv.setText(mDatas.get(position));
                DisplayImageOptions options=new DisplayImageOptions.Builder().build();
                ImageLoader instance = ImageLoader.getInstance();
                holder.tv.setText(list.get(position).getGoods_name());
                instance.displayImage(list.get(position).getGoods_img(),holder.imageview);
            }

            @Override
            public int getItemCount() {
                return list.size();
            }

            class MyViewHolder extends RecyclerView.ViewHolder{
                TextView tv;
                ImageView imageview;
                public MyViewHolder(View view)
                {
                    super(view);
                    tv = (TextView) view.findViewById(R.id.id_num);
                    imageview=(ImageView) view.findViewById(R.id.imageview);
                }
            }
        }


    //点击事件
//    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
//        public interface OnItemClickListener {
//            void onItemClick(View view, int position);
//
//            void onItemLongClick(View view, int position);
//        }
//
//        private OnItemClickListener mListener;
//
//        private GestureDetector mGestureDetector;
//
//        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
//            mListener = listener;
//
//            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
//                @Override
//                public boolean onSingleTapUp(MotionEvent e) {
//                    return true;
//                }
//
//                @Override
//                public void onLongPress(MotionEvent e) {
//                    View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
//
//                    if (childView != null && mListener != null) {
//                        mListener.onItemLongClick(childView, recyclerView.getChildAdapterPosition(childView));
//                    }
//                }
//            });
//        }
//
//        @Override
//        public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
//            View childView = view.findChildViewUnder(e.getX(), e.getY());
//
//            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
//                mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
//            }
//
//            return false;
//        }
//
//        @Override
//        public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
//        }
//
//        @Override
//        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//        }
//    }



}
