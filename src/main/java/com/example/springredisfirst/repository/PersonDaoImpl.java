package com.example.springredisfirst.repository;

import com.example.springredisfirst.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PersonDaoImpl implements PersonDao{

    private final RedisTemplate redisTemplate;

    public static final String KEY = "USER";

    @Override
    public boolean savePerson(Person person) {
        try{
            redisTemplate.opsForHash().put(KEY, person.getId(), person);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Person> fetchAllUser() {
        return (List<Person>) redisTemplate.opsForHash().values(KEY);
    }

    @Override
    public Person fetchPersonById(Long id) {
        return (Person) redisTemplate.opsForHash().get(KEY, id.toString());
    }

    @Override
    public boolean deletePerson(Long id) {
        try{
            redisTemplate.opsForHash().delete(KEY, id.toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
