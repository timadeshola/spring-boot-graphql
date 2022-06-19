package com.sbgl.springbootgraphql.service.impl;

import com.sbgl.springbootgraphql.model.request.UserRequest;
import com.sbgl.springbootgraphql.model.response.UserResponse;
import com.sbgl.springbootgraphql.persistence.entity.User;
import com.sbgl.springbootgraphql.persistence.repository.UserRepository;
import com.sbgl.springbootgraphql.service.UserService;
import com.sbgl.springbootgraphql.utils.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * Project title: spring-boot-graphql
 *
 * @author johnadeshola
 * Date: 6/19/22
 * Time: 3:42 PM
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Flux<UserResponse> findAllUsers() {
        return ModelMapperUtils.mapAll(userRepository.findAll(), UserResponse.class);
    }

    @Override
    public Mono<UserResponse> createUser(@Valid UserRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail()).build();
        Mono<User> userMono = userRepository.save(user);
        return ModelMapperUtils.map(userMono, UserResponse.class);
    }

    @Override
    public Mono<UserResponse> findUserById(Long id) {
        return ModelMapperUtils.map(userRepository.findById(id), UserResponse.class);
    }
}
