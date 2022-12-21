package fr.its4u.todo.dao.entity;

import jakarta.persistence.*;
import java.util.List;

//@Getter
//@Setter
@Entity
@Table(name = "PAGE")
public class PageEntity {

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
     * Tasks.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PAGE_ID", nullable = false)
//    @OrderColumn(name = "ORDER")
    private List<TaskEntity> tasks;

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

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
