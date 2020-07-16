package com.pringles.web.counselor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pringles.web.schedule.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "counselor", uniqueConstraints = {@UniqueConstraint(columnNames = {"counselor_key"})})
public class Counselor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "counselor_temp_id")
    private Long id;

    @Column(name = "counselor_id", nullable = false)
    private String counselorId;

    @Column(name = "counselor_password", nullable = false)
    private String counselorPassword;

    @Column(name = "counselor_name", nullable = false)
    private String counselorName;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "counselor_key", nullable = false)
    private String counselorKey;

    @JsonIgnore
    @OneToMany(mappedBy = "counselor", cascade = CascadeType.ALL)
    private List<Schedule> schedule;
}
