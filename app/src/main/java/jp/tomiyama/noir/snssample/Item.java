package jp.tomiyama.noir.snssample;

public class Item {
    private String key;
    private String title;
    private String content;
    private int likeCount;

    public Item(String key, String title, String content, int likeCount) {
        this.key = key;
        this.title = title;
        this.content = content;
        this.likeCount = likeCount;
    }

    public Item() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
