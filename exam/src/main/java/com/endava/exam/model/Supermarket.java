package com.endava.exam.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Supermarket {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Address cannot be empty")
    private String address;

    private String phoneNumber;

    private String workHours;

    @OneToMany(mappedBy = "superMarket", cascade = CascadeType.ALL)
    private List<Item> items;
}
