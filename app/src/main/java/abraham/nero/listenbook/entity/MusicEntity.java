package abraham.nero.listenbook.entity;

/**
 * Created by WatchVoice04 on 2017/12/26.
 */

public class MusicEntity {
    public enum MusicType {FOLDER, FILE}

    private Integer id;
    private String title;
    private String url;
    private MusicType type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MusicType getType() {
        return type;
    }

    public void setType(MusicType type) {
        this.type = type;
    }
}
