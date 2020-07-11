package in.rohitha.anivaletask.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import in.rohitha.anivaletask.common.EndlessScrollListener;
import in.rohitha.anivaletask.R;
import in.rohitha.anivaletask.adapter.ImagesRecylerviewAdapter;
import in.rohitha.anivaletask.databinding.HomepageLayoutBinding;
import in.rohitha.anivaletask.viewmodels.HomePageModel;
import in.rohitha.anivaletask.network.APIResponseCallback;
import in.rohitha.anivaletask.network.NetworkConstants;
import in.rohitha.anivaletask.network.UserApiCallModel;
import in.rohitha.anivaletask.pojo.Hit;
import in.rohitha.anivaletask.pojo.ImagePojo;

public class HomePage extends AppCompatActivity implements APIResponseCallback {

    HomepageLayoutBinding homepageLayoutBinding;
    ArrayList<Hit> hits = new ArrayList<>();
    ImagesRecylerviewAdapter recylerviewAdapter;
    int currentpage = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homepageLayoutBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        HomePageModel homePageModel = new HomePageModel();
        homePageModel.setTitle("Aniale Games");
        homepageLayoutBinding.setHomePageData(homePageModel);
        recylerviewAdapter = new ImagesRecylerviewAdapter(this,hits);
        getImages();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        homepageLayoutBinding.imagesRyle.setLayoutManager(gridLayoutManager);
        homepageLayoutBinding.imagesRyle.setAdapter(recylerviewAdapter);
        homepageLayoutBinding.imagesRyle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        homepageLayoutBinding.imagesRyle.addOnScrollListener(new EndlessScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                if(hits.size()>0)
                {
                    currentpage = page+1;
                    getImages();
                }

            }

            @Override
            public void onRefresh() {
                currentpage = 1;
                getImages();
            }
        });

//        homepageLayoutBinding.imagesRyle.setOnScrollChangeListener(new );

    }

    private void getImages() {

        Map<String, String> requestBody = new HashMap<>();
        UserApiCallModel userApiCallModel = new UserApiCallModel(this,
                this);
        requestBody.put("page", Integer.toString(currentpage));
        requestBody.put("key","17360141-15b5e1182844e836e7c73ffce");
        userApiCallModel.notifications(NetworkConstants.RequestCode.NOTIFICATIONS,requestBody,"17360141-15b5e1182844e836e7c73ffce",currentpage);
    }

    @Override
    public void onSuccessResponse(int requestId, @NonNull String responseString, @Nullable Object object) {

        ImagePojo imagePojo = new Gson().fromJson(responseString, ImagePojo.class);
        if(imagePojo.getHits().size()>0)
        {
            if(currentpage==1)
            {
                hits.clear();
                hits.addAll(imagePojo.getHits());
            }
            else
            {
                hits.addAll(imagePojo.getHits());
            }

            recylerviewAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFailureResponse(int requestId, @NonNull String errorString) {

    }
}