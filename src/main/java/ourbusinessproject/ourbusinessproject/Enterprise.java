package ourbusinessproject.ourbusinessproject;

import jakarta.validation.constraints.*;

public class Enterprise {
    @NotNull
    @Size(min=1)
    private String name;

    @Size(min=10)
    private String description;

    @NotNull
    @Size(min=1)
    private String contactName;

    @NotNull
    @Size(min=1)
    @Email
    private String contactEmail;

    public Enterprise(){
        name = "";
        description = "";
        contactName = "";
        contactEmail = "";
    }

    public void setName(String newName){
        name = newName;
    }

    public void setDescription(String newDesc){
        description = newDesc;
    }

    public void setContactName(String newName){
        contactName = newName;
    }

    public void setContactEmail(String newEmail){
        contactEmail = newEmail;
    }
}
