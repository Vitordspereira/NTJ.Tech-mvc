package NTJ.Tech.mvc.repository;

import NTJ.Tech.mvc.model.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
