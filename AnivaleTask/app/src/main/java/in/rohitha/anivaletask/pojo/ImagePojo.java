
package in.rohitha.anivaletask.pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class ImagePojo {

    @Expose
    private ArrayList<Hit> hits;
    @Expose
    private Double total;
    @Expose
    private Double totalHits;

    public ArrayList<Hit> getHits() {
        return hits;
    }

    public void setHits(ArrayList<Hit> hits) {
        this.hits = hits;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(Double totalHits) {
        this.totalHits = totalHits;
    }

}
