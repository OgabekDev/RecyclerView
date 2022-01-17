package dev.ogabek.recyclerview7_recyclerviewasgridview.model;

public class GridViewElement {
    private String title;
    private String description;

    public GridViewElement(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}