package com.hejunlin.superindicator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.hejunlin.superindicatorlibray.CircleIndicator;
import com.hejunlin.superindicatorlibray.LoopViewPager;
/**
 * Created by hejunlin on 2016/9/5.
 */
public class TestScrollViewActivity extends AppCompatActivity {

    private static final String TAG = TestScrollViewActivity.class.getSimpleName();
    private ListView mListView;
    private TextAdapter mDataAdapter;
    private LoopViewPager mLooperViewPager;

    private int[] mDatas = new int[] {
            R.string.a_name,
            R.string.b_name,
            R.string.c_name,
            R.string.d_name,
            R.string.e_name,
            R.string.a_name,
            R.string.b_name,
            R.string.c_name,
            R.string.d_name,
            R.string.e_name,
            R.string.a_name,
            R.string.b_name,
            R.string.c_name,
            R.string.d_name,
            R.string.e_name,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_scroll);
        mLooperViewPager = (LoopViewPager) findViewById(R.id.viewpager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        mLooperViewPager.setAdapter(new PicAdapter(TestScrollViewActivity.this));
        mLooperViewPager.setOnDispatchTouchEventListener(mDispatchOnTouchListener);
        mLooperViewPager.setLooperPic(true);
        mListView = (ListView) findViewById(R.id.lv_data);
        mListView.setFocusable(false);
        if (mDataAdapter == null) {
            mDataAdapter = new TextAdapter();
            mListView.setAdapter(mDataAdapter);
        } else {
            mDataAdapter.notifyDataSetChanged();
        }
        setListViewHeightBasedOnChildren(mListView);
        indicator.setViewPager(mLooperViewPager);
    }

    private LoopViewPager.OnDispatchTouchEventListener mDispatchOnTouchListener = new LoopViewPager.OnDispatchTouchEventListener() {
        @Override
        public void onDispatchKeyEvent(MotionEvent event) {
            Log.d(TAG, "mDispatchOnTouchListener.onDispatchKeyEvent(" + event + ")");
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                mLooperViewPager.setLooperPic(false);
            } else if (event.getAction() == MotionEvent.ACTION_UP
                    || event.getAction() == MotionEvent.ACTION_CANCEL) {
                mLooperViewPager.setLooperPic(true);
            }
        }
    };

    public void setListViewHeightBasedOnChildren(ListView listView) {
        if(listView == null) return;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    class TextAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 15;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.lv_item, null);
            }
            TextView textView = (TextView)convertView.findViewById(R.id.tv_item);
            textView.setText(mDatas[position]);
            if (position == 15) {
                mLooperViewPager.setScrollable(true);
            }
            return convertView;
        }
    }
}
