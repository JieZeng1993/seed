package com.jiezeng1993.seed.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author zengjie
 * @date 2018/9/3 15:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of={"id"})
@Entity
public class Permission {
    @Id
    @GeneratedValue
    private int id;
    private String permission;
    private String note;
    private Date updateTime;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY, mappedBy="id")
    private List<Role> roleList;
}
