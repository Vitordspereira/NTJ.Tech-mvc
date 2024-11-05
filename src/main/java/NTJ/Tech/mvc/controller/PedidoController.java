package NTJ.Tech.mvc.controller;

import NTJ.Tech.mvc.model.Pedido;
import NTJ.Tech.mvc.repository.ClienteRepository;
import NTJ.Tech.mvc.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("comprar")
    public String comprar(Pedido pedido){

        return "pedido/compra";
    }

    @PostMapping("comprar")
    @Transactional
    public String comprar(@Valid Pedido pedido,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("clientes", clienteRepository.findAll());
            return "pedido/compra";
        }
        pedidoRepository.save(pedido);
        redirectAttributes.addFlashAttribute("msg", "Compra realizada com sucesso!!!");
        return "redirect:/pedido/comprar";
    }

}
