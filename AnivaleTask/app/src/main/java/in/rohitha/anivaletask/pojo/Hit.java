
package in.rohitha.anivaletask.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Hit {

    @Expose
    private Double comments;
    @Expose
    private Double downloads;
    @Expose
    private Double favorites;
    @Expose
    private Double id;
    @Expose
    private Double imageHeight;
    @Expose
    private Double imageSize;
    @Expose
    private Double imageWidth;
    @Expose
    private String largeImageURL;
    @Expose
    private Double likes;
    @Expose
    private String pageURL;
    @Expose
    private Double previewHeight;
    @Expose
    private String previewURL;
    @Expose
    private Double previewWidth;
    @Expose
    private String tags;
    @Expose
    private String type;
    @Expose
    private String user;
    @SerializedName("user_id")
    private Double userId;
    @Expose
    private String userImageURL;
    @Expose
    private Double views;
    @Expose
    private Double webformatHeight;
    @Expose
    private String webformatURL;
    @Expose
    private Double webformatWidth;

    public Double getComments() {
        return comments;
    }

    public void setComments(Double comments) {
        this.comments = comments;
    }

    public Double getDownloads() {
        return downloads;
    }

    public void setDownloads(Double downloads) {
        this.downloads = downloads;
    }

    public Double getFavorites() {
        return favorites;
    }

    public void setFavorites(Double favorites) {
        this.favorites = favorites;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public Double getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Double imageHeight) {
        this.imageHeight = imageHeight;
    }

    public Double getImageSize() {
        return imageSize;
    }

    public void setImageSize(Double imageSize) {
        this.imageSize = imageSize;
    }

    public Double getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Double imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public Double getLikes() {
        return likes;
    }

    public void setLikes(Double likes) {
        this.likes = likes;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public Double getPreviewHeight() {
        return previewHeight;
    }

    public void setPreviewHeight(Double previewHeight) {
        this.previewHeight = previewHeight;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public Double getPreviewWidth() {
        return previewWidth;
    }

    public void setPreviewWidth(Double previewWidth) {
        this.previewWidth = previewWidth;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Double getUserId() {
        return userId;
    }

    public void setUserId(Double userId) {
        this.userId = userId;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }

    public Double getViews() {
        return views;
    }

    public void setViews(Double views) {
        this.views = views;
    }

    public Double getWebformatHeight() {
        return webformatHeight;
    }

    public void setWebformatHeight(Double webformatHeight) {
        this.webformatHeight = webformatHeight;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public Double getWebformatWidth() {
        return webformatWidth;
    }

    public void setWebformatWidth(Double webformatWidth) {
        this.webformatWidth = webformatWidth;
    }

}
