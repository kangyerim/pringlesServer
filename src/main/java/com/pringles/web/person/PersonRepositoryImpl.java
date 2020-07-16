package com.pringles.web.person;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

interface PersonService {
    public List<Object> findAllOderByRegisterDate(String addr);
}

@Repository
interface PersonRepository extends JpaRepository<Person, Long>, PersonService {
}

public class PersonRepositoryImpl extends QuerydslRepositorySupport implements PersonService {
    public PersonRepositoryImpl() {
        super(Person.class);
    }

    @Autowired JPAQueryFactory factory;
    @Override
    public List<Object> findAllOderByRegisterDate(String addr) {
        QPerson qPerson = QPerson.person;
        List<Object> result = new ArrayList<>();
        factory.from(qPerson)
                .orderBy(qPerson.registerDate.asc())
                .fetch().forEach(arr -> {
                    result.add(arr);
        });
        return result;
    }
}

