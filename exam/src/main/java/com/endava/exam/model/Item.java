package com.endava.exam.model;


import com.endava.exam.model.enums.ItemType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@Entity
public class Item {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Price cannot be null")
    private Double price;

    @NotNull(message = "Item type cannot be null")
    @Enumerated(EnumType.STRING)
    ItemType itemType;

    @ManyToOne
    @JsonIgnore
    Supermarket superMarket;

    @ManyToMany(mappedBy = "items")
    @JsonIgnore
    List<Purchase> purchase;


}
