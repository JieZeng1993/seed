package com.jiezeng1993.seed.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author zengjie
 * @date 2018/9/3 11:30
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of={"id"})
public class Role {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    /**不生成中间表对象，无法设置中间表中的对象*/
    @JsonBackReference
    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "rid", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "uid", referencedColumnName = "id", nullable = false))
    private List<User> userList;


    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY, mappedBy="id")
    private List<Permission> permissionList;
}
