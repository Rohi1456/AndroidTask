package in.rohitha.anivaletask.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class HomePageModel extends BaseObservable {
    private String title;

    @Bindable
    public String getTitle() {
        return title;
    }

    @Bindable
    public void setTitle(String title) {
        this.title = title;
    }
}
