package jpaTest.jpaShop.repository;

import jpaTest.jpaShop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    //단건조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }
    //리스트조회
    public List<Member> findAll() {
       List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        return result;
    }
    public List<Member> findName(String name) {
        return em.createQuery("select m from Member m where m.name =:name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
