package ourbusinessproject.ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

//@Entity
//@Table(name = "partnerships")
public class Partnership {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

//    @NotNull
//    @Column(name = "creation_date")
    private Date creationDate;

//    @NotNull
//    @Column(name = "enterprise")
    private Enterprise enterprise;

//    @NotNull
//    @Column(name = "project")
    private Project project;

//    public Long getId(){
//        return id;
//    }


    public void setCreationDate(Date newDate){
        creationDate = newDate;
    }

    public void setEnterprise(Enterprise e){
        enterprise = e;
    }

    public void setProject(Project p){
        project = p;
    }
}
