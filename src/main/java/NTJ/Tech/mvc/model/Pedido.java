package NTJ.Tech.mvc.model;

import NTJ.Tech.mvc.model.produto.Produto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_PEDIDO")
@EntityListeners(AuditingEntityListener.class)
public class Pedido {

    @Id
    @GeneratedValue
    @Column(name = "ID_PEDIDO")
    private Long id;

    @Size(max = 100, min = 5)
    @NotBlank(message = "Informe o produto")
    @Column(name = "TP_PEDIDO", length = 100, nullable = false)
    private String tipo;

    @Min(1)
    @Column(name = "VL_PEDIDO", length = 10, nullable = false)
    private Integer vlPedido;

    @Min(1)
    @Column(name = "VL_DESCONTO", length = 10, nullable = false)
    private Integer desconto;//Porcentagem

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
}
