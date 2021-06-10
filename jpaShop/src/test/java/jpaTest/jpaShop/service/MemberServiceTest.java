package jpaTest.jpaShop.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional

class MemberServiceTest {

    @Autowired MemberServiceTest memberService;

    @Test
    public void 회원가입 () throws Exception {

    }
}