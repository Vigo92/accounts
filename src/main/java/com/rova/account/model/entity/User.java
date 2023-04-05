package com.rova.account.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Ugochukwu Vigo Obia
 * @project : accounts
 * @date :  01/04/2023
 * @email : obiaugochukwu@gmail.com, obiaugochukwu@icloud.com
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "user")
public class User extends BaseEntity{

    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "user")
    private List<Account> account = new ArrayList<>();
}
