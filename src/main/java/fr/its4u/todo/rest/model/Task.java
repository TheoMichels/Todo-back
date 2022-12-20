package fr.its4u.todo.rest.model;

import java.util.Date;

//@Getter
//@Setter
public class Task {

    /**
     * Id.
     */
    private Long id;

    /**
     * Title.
     */
    private String title;

    /**
     * Description.
     */
    private String description;

    /**
     * End date.
     */
    private Date endDate;

    /**
     * Is Complete or not.
     */
    private Boolean isComplete;

    /**
     * Page ID.
     */
    private Long pageId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }
}
