package com.jiezeng1993.seed.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author zengjie
 * @date 2018/9/3 16:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of={"id"})
@Entity
@Table(name = "role_permission")
public class RolePermission {
    @Id
    @GeneratedValue
    private long id = -1;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="rid",nullable = false)
    private Role role;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="pid",nullable = false)
    private Permission permission;
}
