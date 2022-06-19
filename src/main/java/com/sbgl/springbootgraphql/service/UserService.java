package com.sbgl.springbootgraphql.service;

import com.sbgl.springbootgraphql.model.request.UserRequest;
import com.sbgl.springbootgraphql.model.response.UserResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Project title: spring-boot-graphql
 *
 * @author johnadeshola
 * Date: 6/19/22
 * Time: 3:41 PM
 */
public interface UserService {

    public Flux<UserResponse> findAllUsers();

    public Mono<UserResponse> createUser(UserRequest request);

    public Mono<UserResponse> findUserById(Long id);
}
