package com.pringles.web.schedule;

import com.pringles.web.counselor.Counselor;
import com.pringles.web.person.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
@Table(name = "schedule", uniqueConstraints = {@UniqueConstraint(columnNames = {"schedule_key"})})
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "schedule_temp_id")
    private Long id;

    @Column(name = "schedule_key", nullable = false)
    private String scheduleKey;

    @Column(name = "counsel_date", nullable = false)
    private String counselDate;

    @Column(name = "counsel_category", nullable = false)
    private String counselCategory;

    @Column(name = "counsel_content", nullable = false)
    private String counselContent;

    @Column(name = "counselled", nullable = false)
    private Integer counselled;

    @ManyToOne
    @JoinColumn(name = "person_temp_id") private Person person;

    @ManyToOne
    @JoinColumn(name = "counselor_temp_id") private Counselor counselor;
}
