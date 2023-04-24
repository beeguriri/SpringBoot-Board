package com.example.boardproject.persistence;

import com.example.boardproject.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByMemberId(String memberId);

}
