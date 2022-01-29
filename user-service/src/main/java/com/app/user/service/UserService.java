package com.app.user.service;

import com.app.user.VO.Department;
import com.app.user.VO.ResponseVO;
import com.app.user.config.DepartmentServiceClient;
import com.app.user.entity.User;
import com.app.user.repository.UserRepository;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
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

    @Autowired
    private DepartmentServiceClient departmentServiceClient;

    public User saveUser(User user) {
        log.info("Save User : " + user.getUserId());
        return userRepository.save(user);
    }

    public ResponseVO getUserByDepartmentId(Long userId) {
        ResponseVO responseVO=new ResponseVO();
        User user=userRepository.findByUserId(userId);
//        Department department=
//        restTemplate.
//                getForObject("http://DEPARTMENT-SERVICE/services/department/getDepartment/" + user.getDepartmentId(),Department.class);
        Department departmentDetail = null;
        try {
            departmentDetail=departmentServiceClient.getDepartmentID(user.getDepartmentId());
        } catch (FeignException e) {
            log.info(e.getLocalizedMessage());
        }
        responseVO.setUser(user);
        responseVO.setDepartment(departmentDetail);
        return responseVO;
    }
}
