package ourbusinessproject.ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "enterprises")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @OneToMany(mappedBy = "enterprise")
    private Collection<Project> projects;

    public Enterprise(){
        name = "";
        description = "";
        contactName = "";
        contactEmail = "";
    }

    public Long getId(){
        return id;
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

    public Collection<Project> getProjects(){
        return projects;
    }

    public void addProject(Project project){
        if (projects == null){
            projects = new HashSet<>();
        }
        projects.add(project);
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
