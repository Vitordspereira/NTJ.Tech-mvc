package NTJ.Tech.mvc.model.produto;

import NTJ.Tech.mvc.model.Pedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue
    @Column(name = "ID_PRODUTO")
    private Long codigo;

    @Size(max = 100, min = 10)
    @NotBlank(message = "Informe o produto")
    @Column(name = "NM_PRODUTO", length = 100, nullable = false)
    private String produto;

    @Column(name = "TB_MARCA", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoMarca marca;

    @Column(name = "TB_COR", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCor cor;

    @Column(name = "TB_TECIDO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTecido tecido;

    @Column(name = "TB_TAMANHO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTamanho tamanho;

    @ManyToOne
    @JoinColumn(name = "ID_PEDIDO")
    private Pedido pedido;
}
