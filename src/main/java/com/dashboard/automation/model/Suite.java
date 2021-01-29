package com.dashboard.automation.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity@Table(name = "suite")
public class Suite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Integer id;
    @Column(name = "runid")
    Integer runId;
    @Column(name = "suite_name")
    String suiteName;
    @Column(name = "url")
    String url;
    @Column(name = "browser")
    String browser;
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
