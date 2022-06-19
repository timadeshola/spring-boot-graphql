package com.sbgl.springbootgraphql.model.request;

import lombok.*;

import javax.validation.constraints.Email;
import java.io.Serializable;

/**
 * Project title: spring-boot-graphql
 *
 * @author johnadeshola
 * Date: 6/19/22
 * Time: 3:39 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserRequest implements Serializable {

    private String username;
    private String firstName;
    private String lastName;
    @Email(message = "Please enter a valid email address { johndoe@example.com }")
    private String email;

}
