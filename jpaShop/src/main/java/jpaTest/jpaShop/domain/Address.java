package jpaTest.jpaShop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {}
    /*기본생성자 만들어줘야한다, jpa에서는 protected까지 허용해준다. public 을 사용하면 상속을
    마구해버리기때문에 이렇게 처리한다.
    */

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
    //public 으로 되어있는 이녀석을 사용해 데이터를 고정적으로 사용하게 만든다.
}
