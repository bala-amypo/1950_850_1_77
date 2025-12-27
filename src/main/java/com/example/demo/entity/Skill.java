// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class Skill {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     public Skill() {}

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }
// 


package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private boolean active = true;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
