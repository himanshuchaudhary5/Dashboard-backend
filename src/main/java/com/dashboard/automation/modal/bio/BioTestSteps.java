package com.dashboard.automation.modal.bio;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "steps")
public class BioTestSteps {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    int id;
    @Column(name = "test_id")
    int testId;
    @Column(name = "step_sequence")
    int stepid;
    @Column(name = "description")
    String description;
    @Column(name = "status")
    String status;
}
