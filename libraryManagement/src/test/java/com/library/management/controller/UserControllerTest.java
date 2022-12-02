package com.library.management.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.management.payloads.UserDto;
import com.library.management.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @Autowired
    MockMvc mockMvc;
    ObjectMapper objectMapper = null;

    UserDto userDto=null;
    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        objectMapper = new ObjectMapper();
        userDto=new UserDto();
        userDto.setId(1);
        userDto.setEmail("abc@gmail.com");
        userDto.setName("abc");
        userDto.setAbout("abc about");
        userDto.setPassword("abcPwd");

    }

    @Test
    void createUser() throws Exception {
        when(userService.createUser(userDto)).thenReturn(userDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/create")
                .content(objectMapper.writeValueAsString(userDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void updateUser() {
//        Integer userId=1;
//        when(userService.updateUser(userDto,userId)).thenReturn(userDto);
//        mockMvc.perform("/api/users/update/" + userId))


    }

    @Test
    void deleteUser() {
    }
}