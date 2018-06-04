package com.foobar.bara.repo;

import com.foobar.bara.domain.Bara;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaraRepository extends JpaRepository<Bara, Long> {

    Bara findById(Long id);

}
