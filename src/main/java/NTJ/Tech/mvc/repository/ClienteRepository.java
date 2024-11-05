package NTJ.Tech.mvc.repository;

import NTJ.Tech.mvc.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
