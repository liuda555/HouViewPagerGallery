package ha.houviewpagergallery;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private List<List<String>> groupList=new ArrayList<>();
    private List<String> titleList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);

        titleList.add("入野自由");titleList.add("杉田智和");titleList.add("铃村健一");titleList.add("冈本信彦");
        List<String> list=new ArrayList<>();
        list.add("http://img2.imgtn.bdimg.com/it/u=1694711101,3544650809&fm=21&gp=0.jpg");
        list.add("http://img5.imgtn.bdimg.com/it/u=3633955208,3563210509&fm=21&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=3100400700,984724419&fm=21&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=1864716862,1526780135&fm=21&gp=0.jpg");
        groupList.add(list);
        List<String> list1=new ArrayList<>();
        list1.add("http://img2.imgtn.bdimg.com/it/u=2942398213,3820799747&fm=21&gp=0.jpg");
        list1.add("http://img5.imgtn.bdimg.com/it/u=2879358774,4252999269&fm=21&gp=0.jpg");
        list1.add("http://img1.imgtn.bdimg.com/it/u=3335362066,3361167295&fm=21&gp=0.jpg");
        list1.add("http://img2.imgtn.bdimg.com/it/u=3873925546,3067464242&fm=21&gp=0.jpg");
        groupList.add(list1);
        List<String> list2=new ArrayList<>();
        list2.add("http://img3.imgtn.bdimg.com/it/u=2237323783,3037578924&fm=21&gp=0.jpg");
        list2.add("http://img1.imgtn.bdimg.com/it/u=448700483,3066472670&fm=21&gp=0.jpg");
        list2.add("http://img0.imgtn.bdimg.com/it/u=2562068263,296594873&fm=21&gp=0.jpg");
        list2.add("http://img4.imgtn.bdimg.com/it/u=2559676820,184327574&fm=21&gp=0.jpg");
        groupList.add(list2);
        List<String> list3=new ArrayList<>();
        list3.add("http://img3.imgtn.bdimg.com/it/u=52636661,3256927462&fm=23&gp=0.jpg");
        list3.add("http://img5.imgtn.bdimg.com/it/u=1112511831,3692583996&fm=21&gp=0.jpg");
        list3.add("http://img1.imgtn.bdimg.com/it/u=3631135793,2937483672&fm=21&gp=0.jpg");
        list3.add("http://img4.imgtn.bdimg.com/it/u=3360379955,479703893&fm=21&gp=0.jpg");
        groupList.add(list3);

        pager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                    page.setScaleY(1f - ((float) (0.3 * Math.abs(position))));
                    page.setScaleX(1f - ((float) (0.3 * Math.abs(position))));
          }
        });
        pager.setAdapter(new Adapter(getSupportFragmentManager(),groupList,this,titleList));
        pager.setCurrentItem(Integer.MAX_VALUE%titleList.size());
    }
}

















