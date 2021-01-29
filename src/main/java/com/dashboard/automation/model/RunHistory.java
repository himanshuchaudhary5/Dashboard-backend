package com.dashboard.automation.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "run_history")
public class RunHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Integer id;
    @Column(name = "environment")
    String environment;
    @Column(name = "url")
    String url;
    @Column(name = "passed")
    Integer passed;
    @Column(name = "failed")
    Integer failed;
    @Column(name = "skipped")
    Integer skipped;
    @Column(name = "duration")
    String duration;
    @Column(name = "status")
    String status;

}
