package br.com.arq.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arq.model.Funcionario;
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
