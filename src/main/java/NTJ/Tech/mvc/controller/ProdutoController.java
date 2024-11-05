package NTJ.Tech.mvc.controller;

import NTJ.Tech.mvc.model.Cliente;
import NTJ.Tech.mvc.model.produto.Produto;
import NTJ.Tech.mvc.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Produto produto){

        return "produto/cadastro";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid Produto produto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) return "editora/form";
        produtoRepository.save(produto);
        redirectAttributes.addFlashAttribute("msg", "Produto cadastrado!!!");
        return "redirect:/produto/cadastro";
    }
}
