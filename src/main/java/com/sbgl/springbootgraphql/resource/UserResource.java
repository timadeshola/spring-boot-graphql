package com.sbgl.springbootgraphql.resource;

import com.sbgl.springbootgraphql.model.request.UserRequest;
import com.sbgl.springbootgraphql.model.response.UserResponse;
import com.sbgl.springbootgraphql.service.UserService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * Project title: spring-boot-graphql
 *
 * @author johnadeshola
 * Date: 6/19/22
 * Time: 3:46 PM
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class UserResource {

    private final UserService userService;

    @QueryMapping
    public Flux<UserResponse> findAllUsers() {
        return Flux.fromIterable(userService.findAllUsers());
    }

    @MutationMapping
    public Mono<UserResponse> createUser(@Argument("req") @Valid UserRequest request) {
        log.info("Request: {}", request.toString());
        return Mono.just(userService.createUser(request));
    }

    @QueryMapping
    public Mono<UserResponse> findUserById(@Argument Long id) {
        return Mono.just(userService.findUserById(id));
    }
}
