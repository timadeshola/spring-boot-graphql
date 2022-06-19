package com.sbgl.springbootgraphql.service;

import com.sbgl.springbootgraphql.model.request.UserRequest;
import com.sbgl.springbootgraphql.model.response.UserResponse;

import java.util.List;

/**
 * Project title: spring-boot-graphql
 *
 * @author johnadeshola
 * Date: 6/19/22
 * Time: 3:41 PM
 */
public interface UserService {

    public List<UserResponse> findAllUsers();

    public UserResponse createUser(UserRequest request);

    public UserResponse findUserById(Long id);
}
