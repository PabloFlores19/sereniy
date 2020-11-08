package com.serenity.project.model;

import com.serenity.project.model.users.Person;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository {

    @Select("select * from persona order by id desc limit 1")
    List<Person>selectPerson();

    @Select("select * from persona order by id limit 1")
    List<Person>selectFirstPerson();

    @Select("select count(*) from persona")
    int countRows();

}
