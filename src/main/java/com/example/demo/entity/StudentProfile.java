package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column(nullable = false, unique = true)
    private String enrollmentId;

    @Column(nullable = false)
    private String cohort;

    @Column(nullable = false)
    private Integer yearLevel;

    private Boolean active = true;

    private LocalDateTime lastUpdatedAt;

    @PrePersist
    @PreUpdate
    void updateTimestamp() {
        this.lastUpdatedAt = LocalDateTime.now();
    }
}
