package com.sbgl.springbootgraphql.persistence.repository;

import com.sbgl.springbootgraphql.persistence.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Project title: spring-boot-graphql
 *
 * @author johnadeshola
 * Date: 6/19/22
 * Time: 5:45 PM
 */
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}
