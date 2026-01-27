package ourbusinessproject.ourbusinessproject;

import jakarta.validation.constraints.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "enterprises")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=1)
    @Column(name="name")
    private String name;

    @Size(min=10)
    @Column(name = "desc")
    private String description;

    @NotBlank
    @Column(name="contact_name")
    private String contactName;

    @NotBlank
    @Email
    @Column(name="contact_email")
    private String contactEmail;

    public Enterprise(){
        name = "";
        description = "";
        contactName = "";
        contactEmail = "";
    }

    /**
     * Get the enterprise's name.
     * @return The enterprise's name.
     */
    public String getName(){
        return name;
    }

    /**
     * Get the enterprise's description.
     * @return The enterprise's description.
     */
    public String getDescription(){
        return description;
    }

    /**
     * Get the contact name for this enterprise.
     * @return The contact name for this enterprise.
     */
    public String getContactName(){
        return contactName;
    }

    /**
     * Get the contact email for this enterprise.
     * @return The contact email for this enterprise.
     */
    public String getContactEmail(){
        return contactEmail;
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
