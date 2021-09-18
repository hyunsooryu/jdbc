package me.jdbc.dbaccess.repository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jdbc.dbaccess.dto.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class PersonRepository {

    private final JdbcTemplate jdbcTemplate;

    //CREATE
    public Person createPerson(Person person){
        //1.query
        //prepareStatement -> cacheable
        String query = "INSERT INTO GS27(NAME, WORK_AT, SPECIALITY, AGE, PHONE_NUMBER) VALUES(?,?,?,?,?)";

        //2.jdbcTemplate으로 쿼리를 실행해주면 끝.
        int rowCnt = jdbcTemplate.update(query, person.getName(), person.getWorkAt(), person.getSpeciality(), person.getAge(), person.getPhoneNumber());
        log.info(query + "{" + person + "} updated row cnt : " + rowCnt);

        //강제로 트랜잭션이 되는지 확인하려고 에러를 만들었습니다.
        int[] arrays = new int[]{1,2,3};

        int tmp = arrays[101];

        return person;
    }



}
