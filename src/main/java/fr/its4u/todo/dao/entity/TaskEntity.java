package fr.its4u.todo.dao.entity;

import jakarta.persistence.*;

import java.util.Date;

//@Getter
//@Setter
@Entity
@Table(name = "TASK")
public class TaskEntity {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * Title.
     */
    @Column(name = "TITLE")
    private String title;

    /**
     * Description.
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * End date.
     */
    @Column(name = "END_DATE")
    private Date endDate;

    /**
     * Is Complete or not.
     */
    @Column(name = "COMPLETE")
    private Boolean complete;

    /**
     * Todo page.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private PageEntity page;

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
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public PageEntity getPage() {
        return page;
    }

    public void setPage(PageEntity todoPage) {
        this.page = todoPage;
    }
}
