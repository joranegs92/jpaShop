package jpaTest.jpaShop.controller;

import lombok.Getter;
import lombok.Setter;



@Getter @Setter
public class MemberForm {

    @NotEmpty
    private String name;
    private String city;
    private String street;

}
