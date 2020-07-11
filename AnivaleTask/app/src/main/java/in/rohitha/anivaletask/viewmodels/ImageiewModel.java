package in.rohitha.anivaletask.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

import in.rohitha.anivaletask.ui.EnlargedImagePage;
import in.rohitha.anivaletask.R;

public class ImageiewModel extends BaseObservable {

    private String url;
    Context context ;
    private String detailiewUrl;

    public ImageiewModel(String url,Context context,String detailiewUrl)
    {
        this.url = url;
        this.context =context;
        this.detailiewUrl = detailiewUrl;
    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, String url) {
        Picasso.with(imageView.getContext())
                .load(url)
                .placeholder(R.drawable.image_place_holder)
                .error(R.drawable.image_place_holder)
                .into(imageView);
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    @Bindable
    public void setUrl(String url) {
        this.url = url;
    }

    public void  onClick(String url)
    {
        Intent intent = new Intent(context, EnlargedImagePage.class);
        Bundle bundle = new Bundle();
        bundle.putString("url",detailiewUrl);
        intent.putExtras(bundle);
        context.startActivity(intent);

    }
}
