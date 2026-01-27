package ourbusinessproject.ourbusinessproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String title;

    private String description;

    public Project(){
        title = "";
        description = null;
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

    /**
     * Sets the project's title.
     * @param newTitle The new title. Cannot be null or empty.
     */
    public void setTitle(@NotBlank String newTitle){
        title = newTitle;
    }

    /**
     *
     * @param newDesc
     */
    public void setDescription(String newDesc){
        description = newDesc;
    }
}
