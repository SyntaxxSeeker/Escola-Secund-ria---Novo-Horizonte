package com.senac.novo_horizonte.data;

import com.senac.novo_horizonte.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
}
