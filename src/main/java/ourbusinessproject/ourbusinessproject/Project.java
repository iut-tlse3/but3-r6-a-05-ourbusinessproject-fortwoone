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

    @NotNull
    @Size(min=1)
    private String title;

    private String description;

    public Project(){
        title = "";
        description = null;
    }

    public void setTitle(@NotNull String newTitle){
        title = newTitle;
    }

    public void setDescription(String newDesc){
        description = newDesc;
    }
}
