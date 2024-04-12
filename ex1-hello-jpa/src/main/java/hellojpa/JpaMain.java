package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        //고객 요청 올 때마다 쓰는 것 (하나만 생성해서 애플리케이션 전체에서 공유)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //DB 작업
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /*
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA"); //수정

            List<Member> result = em.createQuery("select m from Member  as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.getName() = " + member.getName());
            }
             */

            //영속성 관리 - 내부 동작 방식
            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            //영속
//            em.persist(member); //DB에 보내는 것 아님, 1차캐시에 저장
//            Member findMember1 = em.find(Member.class, 101L); //1차캐시 조회
//            Member findMember2 = em.find(Member.class, 101L);
//
//            System.out.println("result = " + (findMember1 == findMember2)); //영속 엔티티의 동일성 보장 = true

            //엔티티 등록 - 트랜잭션을 지원하는 쓰기 지연
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("============="); //이 이후에 쿼리가 나감

            //엔티티 수정 - 변경 감지
//            Member member = em.find(Member.class, 150L); //이미 위에서 저장함(member1)
//            member.setName("ZZZZZ");
            //em.persist(member) 할 필요 x, 자바 컬렉션 같은 느낌, update 쿼리 실행됨

            //엔티티 삭제 - em.remove(member) 사용
            //em.flush() //commit 되기 전 DB에 미리 반영됨(동기화), 영속성 컨텍스트를 비우지 않음

            //준영속 상태
//            Member member = em.find(Member.class, 150L); //이미 위에서 저장함
//            member.setName("AAAAA");
//
////            em.detach(member); //JPA 더이상 관리 x, update 쿼리 안나감
//            em.clear(); //통째로 지움
//            Member member2 = em.find(Member.class, 150L); //다시 영속성 컨텍스트 올림 select


            //기본 키 매핑
            Member member = new Member();
            member.setUsername("C");

            em.persist(member);

            tx.commit(); //이때 DB에 저장
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}