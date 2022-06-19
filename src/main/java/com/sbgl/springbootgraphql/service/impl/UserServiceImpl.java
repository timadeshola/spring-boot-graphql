package com.sbgl.springbootgraphql.service.impl;

import com.sbgl.springbootgraphql.model.request.UserRequest;
import com.sbgl.springbootgraphql.model.response.UserResponse;
import com.sbgl.springbootgraphql.service.UserService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Project title: spring-boot-graphql
 *
 * @author johnadeshola
 * Date: 6/19/22
 * Time: 3:42 PM
 */
@Service
public class UserServiceImpl implements UserService {

    private final Map<Long, UserResponse> db = new HashMap<>();
    private final AtomicLong id = new AtomicLong();

    @Override
    public List<UserResponse> findAllUsers() {
        return new ArrayList<>(db.values());
    }

    @Override
    public UserResponse createUser(@Valid UserRequest request) {
        UserResponse response = UserResponse.builder()
                .id(id.incrementAndGet())
                .username(request.getUsername())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail()).build();
        db.put(response.getId(), response);
        return response;
    }

    @Override
    public UserResponse findUserById(Long id) {
        return db.values()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("User with ID: " + id + " cannot be found"));
    }
}
