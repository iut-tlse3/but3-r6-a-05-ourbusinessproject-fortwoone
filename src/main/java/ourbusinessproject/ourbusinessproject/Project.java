package ourbusinessproject.ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "title")
    private String title;

    @Column(name = "desc")
    private String description;

    @ManyToOne
    @NotNull
    private Enterprise enterprise;

    public Project(){
        title = "";
        description = null;
    }

    public Long getId(){
        return id;
    }

    /**
     * Get the project's title.
     * @return A string matching the project's title.
     */
    public String getTitle(){
        return title;
    }

    /**
     * Get the project's description.
     * @return A string matching the project's description.
     */
    public String getDescription(){
        return description;
    }

    public Enterprise getEnterprise(){
        return enterprise;
    }

    /**
     * Sets the project's title.
     * @param newTitle The new title. Cannot be null or empty.
     */
    public void setTitle(@NotBlank String newTitle){
        title = newTitle;
    }

    /**
     * Sets the project's description.
     * @param newDesc
     */
    public void setDescription(String newDesc){
        description = newDesc;
    }

    public void setEnterprise(Enterprise enterprise){
        this.enterprise = enterprise;
    }
}
