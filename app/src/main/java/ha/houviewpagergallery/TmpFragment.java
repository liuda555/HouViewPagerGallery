package ha.houviewpagergallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuexi on 2016/11/10.
 */

public class TmpFragment extends Fragment{

    private List<String> urlList=new ArrayList<>();
    private TextView title;
    private List<ImageView> imageList=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tmp,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.setScaleY(0.7f);
        view.setScaleX(0.7f);
        Bundle bundle = getArguments();
        String title = bundle.getString("title");
        for (int i = 0; i < 4; i++) {
            urlList.add(bundle.getString("pic"+i));
        }

        this.title = (TextView) view.findViewById(R.id.fra_title);
        imageList.add(((ImageView) view.findViewById(R.id.pic1)));
        imageList.add(((ImageView) view.findViewById(R.id.pic2)));
        imageList.add(((ImageView) view.findViewById(R.id.pic3)));
        imageList.add(((ImageView) view.findViewById(R.id.pic4)));

        this.title.setText(title);
        for (int i = 0; i < imageList.size(); i++) {
            Picasso.with(getContext()).load(urlList.get(i))
                    .placeholder(R.mipmap.loading)
                    .error(R.mipmap.error)
                    .into(imageList.get(i));
        }

    }
}
