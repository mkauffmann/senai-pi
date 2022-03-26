package br.com.senai.pi.CicloBasico.repository;

import br.com.senai.pi.CicloBasico.model.entity.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {

    @Query(value = "select tc.nome  \n" +
            "from tb_aula ta inner join tb_curso_aula tca on ta.id_aula = tca.id_aula \n" +
            "inner join tb_curso tc  on tc.id_curso = tca.id_curso\n" +
            "where ta.id_aula = :id", nativeQuery = true)
    public String buscarNomeDoCursoPorIdAula(@Param("id") Long idAula);
}
