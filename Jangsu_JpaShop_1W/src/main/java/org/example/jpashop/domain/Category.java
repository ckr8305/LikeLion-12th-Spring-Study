package org.example.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.jpashop.domain.item.Item;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item", joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
}
