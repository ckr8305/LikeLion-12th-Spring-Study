package org.likelion.spring.repository;

import lombok.Getter;
import lombok.Setter;
import org.likelion.spring.domain.OrderStatus;

@Getter @Setter
public class OrderSearch {
    private String memberName; // 회원 이름
    private OrderStatus orderStatus; // 주문 상태


}
