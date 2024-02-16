package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    //다대일 관계 (여러 주문이 하나의 멤버)
    @ManyToOne(fetch = LAZY) //default(XToOne) = EAGER
    @JoinColumn(name = "member_id")
    private Member member; //연관관계 주인

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) //default(XToMany) = LAZY
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne (cascade = CascadeType.ALL, fetch = LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; //주문시간

    @Enumerated(EnumType.STRING)
    private OrderSataus status; //주문상태 [ORDER, CANCLE]

    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

}
