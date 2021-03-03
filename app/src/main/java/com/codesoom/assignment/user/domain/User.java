package com.codesoom.assignment.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String name;

    private String password;

    @Builder.Default
    private boolean deleted = false;

    public void changeWith(User source) {
        name = source.name;
        password = source.password;
    }

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }

    public void destroy() {
        deleted = true;
    }

    public boolean authenticate(String password) {
        return !deleted && password.equals(this.password);
    }
}
