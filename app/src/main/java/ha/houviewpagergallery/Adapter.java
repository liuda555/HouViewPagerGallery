package ha.houviewpagergallery;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by yuexi on 2016/11/10.
 */

public class Adapter extends FragmentStatePagerAdapter {

    private List<List<String>> groupList;
    private Context context;
    private List<String> titleList;

    public Adapter(FragmentManager fm, List<List<String>> groupList, Context context, List<String> titleList) {
        super(fm);
        this.groupList = groupList;
        this.context = context;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {

        position = position % titleList.size();

        TmpFragment fragment=new TmpFragment();

        Bundle bundle=new Bundle();
        bundle.putString("title",titleList.get(position));
        for (int i = 0; i < groupList.get(position).size(); i++) {
            bundle.putString("pic"+i,groupList.get(position).get(i));
        }
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

}
