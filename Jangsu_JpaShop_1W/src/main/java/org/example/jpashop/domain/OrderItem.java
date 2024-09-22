package org.example.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.jpashop.domain.item.Item;

@Getter
@Setter
@Entity
public class OrderItem {
    @Id
    @Column(name = "order_item_id")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_Id")
    private Order order;

    private int orderPrice;
    private int count;
}
