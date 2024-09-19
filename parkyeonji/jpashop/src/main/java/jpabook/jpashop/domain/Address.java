package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {} // jpa 스펙상 엔티티나 임베디드 타입은 자바 기본 생성자를 public 또는 protected로 설정해야 한다.

    // setter를 제거하고 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스를 만드는 것이 좋다.
    // Setter가 모두 열려있으면 변경 포인트가 너무 많아서 유지보수가 어려움
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
