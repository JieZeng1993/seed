package com.jiezeng1993.seed.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author zengjie
 * @date 2018/8/31 17:18
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of={"id"})
public class User implements Serializable {
    @Id
    @GeneratedValue
    private long id = -1;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
    //是否启用当前用户
    private byte enable =-1 ;

    @JsonManagedReference
    @ManyToMany(targetEntity = Role.class,fetch=FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "uid", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "rid", referencedColumnName = "id", nullable = false))
    private List<Role> roleList;
}
