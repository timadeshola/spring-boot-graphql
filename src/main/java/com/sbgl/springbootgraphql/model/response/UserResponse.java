package com.sbgl.springbootgraphql.model.response;

import lombok.*;

import javax.validation.constraints.Email;
import java.io.Serializable;

/**
 * Project title: spring-boot-graphql
 *
 * @author johnadeshola
 * Date: 6/19/22
 * Time: 3:41 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserResponse implements Serializable {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
