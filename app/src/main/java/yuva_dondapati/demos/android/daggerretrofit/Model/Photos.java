package yuva_dondapati.demos.android.daggerretrofit.Model;

import com.google.gson.annotations.Expose;

public class Photos {

    public  int albumId;
    public  String title;
    public  int id;
    public String thumbnailUrl;
    public  String url;

    public Photos(){

    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Photos(int albumId, String title, int id, String thumbnailUrl, String url) {
        this.albumId = albumId;
        this.title = title;
        this.id = id;
        this.thumbnailUrl = thumbnailUrl;
        this.url=url;
    }
}
