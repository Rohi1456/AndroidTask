package in.rohitha.anivaletask.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import in.rohitha.anivaletask.R;
import in.rohitha.anivaletask.databinding.EnlargedPageLayoutBinding;
import in.rohitha.anivaletask.viewmodels.EnlargedViewModel;

public class EnlargedImagePage extends AppCompatActivity {

    EnlargedPageLayoutBinding enlargedPageLayoutBinding;
    EnlargedViewModel enlargedViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enlargedPageLayoutBinding = DataBindingUtil.setContentView(this, R.layout.activity_enlarged_image_page);
        Bundle bundle  = getIntent().getExtras();
        String url="";
        if(bundle.containsKey("url"))
        {
            url = bundle.getString("url");
        }
        enlargedViewModel = new EnlargedViewModel(url,this);
        enlargedPageLayoutBinding.setEnlargedViewModel(enlargedViewModel);
        enlargedPageLayoutBinding.leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}