package com.serenity.project.model;

import com.serenity.project.model.users.Person;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository {

    @Select("SELECT * FROM persona")
    List<Person>selectPerson();

}
