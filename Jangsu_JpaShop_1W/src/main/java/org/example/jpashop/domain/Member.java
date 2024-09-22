package org.example.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter // 실무에서는 유지보수 난이도 증가로 사용을 자제할 것. 남발하지 말기
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // 종속 관계, 읽기 전용이 된다.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
