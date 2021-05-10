package jpaTest.jpaShop;
import domain.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaShopApplicationTests {


	@Autowired
	MemberRepository memberRepository;
	@Test
	void contextLoads() {
	}

}
