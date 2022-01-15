package com.app.user.service;

import com.app.user.VO.Department;
import com.app.user.VO.ResponseVO;
import com.app.user.entity.User;
import com.app.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Save User : " + user.getUserId());
        return userRepository.save(user);
    }

    public ResponseVO getUserByDepartmentId(Long userId) {
        ResponseVO responseVO=new ResponseVO();
        User user=userRepository.findByUserId(userId);
        Department department=
        restTemplate.
                getForObject("http://DEPARTMENT-SERVICE/services/department/getDepartment/" + user.getDepartmentId(),Department.class);
        responseVO.setUser(user);
        responseVO.setDepartment(department);
        return responseVO;
    }
}
