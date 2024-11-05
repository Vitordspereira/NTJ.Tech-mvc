package NTJ.Tech.mvc.repository;

import NTJ.Tech.mvc.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
