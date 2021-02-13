package com.dashboard.automation.modal.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity @Table(name ="module")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Integer id;
    @Column(name = "suiteid")
    Integer suiteid;
    @Column(name = "name")
    String name;
    @Column(name = "details")
    String details;
    @Column(name = "duration")
    String duration;
    @Column(name = "passed")
    Integer passed;
    @Column(name = "failed")
    Integer failed;
    @Column(name = "skipped")
    Integer skipped;
    @Column(name = "status")
    String status;


}
