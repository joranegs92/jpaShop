package domain;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue//sequence
    @Column
    private Long id;

    private String name;

    @Embedded
    private Address address;

    private List<Order> orders = new ArrayList<>();


}