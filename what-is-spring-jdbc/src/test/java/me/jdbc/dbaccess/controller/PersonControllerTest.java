package me.jdbc.dbaccess.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.jdbc.dbaccess.dto.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    @DisplayName("Person을 만드는 createPerson Controller 테스트입니다.")
    public void createPersonControllerTest() throws Exception {

        Person person = new Person();

        person.setName("SONG MINKYU");
        person.setAge(29);
        person.setPhoneNumber("010-3564-5567");
        person.setSpeciality("DUCK JOONG SECRETARY");
        person.setWorkAt("GS TOWER");

        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/person")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(json))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        System.out.println("result ------------------------------");
        System.out.println(mvcResult.getResponse().getContentAsString());

        assertThat(json).isEqualTo(mvcResult.getResponse().getContentAsString());



    }

}