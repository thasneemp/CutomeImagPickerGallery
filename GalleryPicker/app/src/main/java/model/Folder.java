package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muhammed
 */
public class Folder {

    private String folderName;
    private List<Image> images;

    public Folder(String bucket) {
        folderName = bucket;
        images = new ArrayList<>();
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
