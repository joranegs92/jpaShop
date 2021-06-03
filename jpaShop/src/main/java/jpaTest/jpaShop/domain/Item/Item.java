package jpaTest.jpaShop.domain.Item;

import jpaTest.jpaShop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //앨범 무비 북이 여기테이블에속하게 만들거다 , 싱글테이블
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item{
    @Id
    @GeneratedValue
    @Column(name ="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy ="items")
    private List<Category> categories = new ArrayList<>();



}