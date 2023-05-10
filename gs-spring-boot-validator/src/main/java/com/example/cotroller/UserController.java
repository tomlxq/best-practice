package com.example.cotroller;

import com.example.entity.UserAddDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * UserController
 *
 * @author TomLuo
 * @date 2023年04月24日 3:37
 */
@RestController
@RequestMapping("/users")
@Validated
@Slf4j
public class UserController {
    @GetMapping("/get")
    public UserAddDTO get(@RequestParam("id") @Min(value = 1L, message = "编号必须大于 0") Integer id) {
        log.info("[get][id: {}]", id);
        UserAddDTO userAddDTO = new UserAddDTO();
        userAddDTO.setUsername("张三");
        userAddDTO.setPassword("123456");
        return userAddDTO;
    }

    @PostMapping("/add")
    public void add(@Valid @RequestBody UserAddDTO addDTO) {
        log.info("[add][addDTO: {}]", addDTO);
    }

}