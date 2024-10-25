package com.senac.novo_horizonte.data;

import com.senac.novo_horizonte.entity.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface turmaRepository extends JpaRepository<TurmaEntity, Long> {
}
