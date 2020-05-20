package com.kackan.emailsenderspringbootaop.model;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Movie extends RepresentationModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @NotBlank
    private String title;

    @Column
    @NotNull
    private int yearProduction;

    @NotBlank(message = "email cannot be blank")
    @Email
    private String email;

    public Movie() {
    }

    public Movie(Long id, @NotBlank String title, @NotNull int yearProduction, @NotBlank(message = "email cannot be blank") @Email String email) {
        this.id = id;
        this.title = title;
        this.yearProduction = yearProduction;
        this.email = email;
    }

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

    public int getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(int yearProduction) {
        this.yearProduction = yearProduction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearProduction=" + yearProduction +
                '}';
    }
}
