package ourbusinessproject.ourbusinessproject;

import jakarta.validation.constraints.*;

public class Project {
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
