package NTJ.Tech.mvc.model;

import jakarta.persistence.*;
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
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_CLIENTE")
@EntityListeners(AuditingEntityListener.class)
public class Cliente {

    @Id
    @GeneratedValue
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Size(max = 200, min = 10)
    @NotBlank(message = "Nome é obrigatório")
    @Column(name = "NM_CLIENTE", length = 100, nullable = false)
    private String nome;

    @Size(max = 200, min = 10)
    @NotBlank(message = "E-mail é obrigatório")
    @Column(name = "DS_EMAIL", length = 100, nullable = false)
    private String email;

    @Size(max = 30, min = 11)
    @NotBlank(message = "Telefone é obrigatório")
    @Column(name = "NR_CPF", length = 30, unique = true, nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;
}
