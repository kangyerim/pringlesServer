package com.pringles.web.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pringles.web.schedule.Schedule;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "person", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id"})})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "person_temp_id")
    private Long id;

    @Column(name = "user_key", nullable = false)
    private String userKey;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column( name = "birth_date", nullable = false)
    private String birthDate;

    @Column(name = "contact_phone", nullable = false)
    private String contactPhone;

    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    @CreationTimestamp
    @Column(name = "register_date")
    private LocalDateTime registerDate;

    @Column(name = "position", nullable = false)
    private String position;

    @JsonIgnore
    @OneToMany (mappedBy = "person", cascade = CascadeType.ALL)
    private List<Schedule> schedules;

}