package jpaTest.jpaShop.service;

import jpaTest.jpaShop.domain.Delivery;
import jpaTest.jpaShop.domain.Item.Item;
import jpaTest.jpaShop.domain.Member;
import jpaTest.jpaShop.domain.Order;
import jpaTest.jpaShop.domain.OrderItem;
import jpaTest.jpaShop.repository.ItemRepository;
import jpaTest.jpaShop.repository.MemberRepository;
import jpaTest.jpaShop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    /*주문
    * */
    @Transactional
    public Long order(Long memberId, Long itemId, int count){
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //주문번호 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문생성
        Order order = Order.createOrder(member,delivery,orderItem);
        orderRepository.save(order);
        return order.getId();
    }
    //취소
    @Transactional
    public void calncleOrder(Long orderId){
        Order order = orderRepository.findOne(orderId);
        order.cancle();

    }
    
}
