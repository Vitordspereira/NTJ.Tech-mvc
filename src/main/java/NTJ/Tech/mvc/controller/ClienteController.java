package NTJ.Tech.mvc.controller;

import NTJ.Tech.mvc.model.Cliente;
import NTJ.Tech.mvc.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Cliente cliente){

        return "cliente/cadastro";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("status", clienteRepository.findAll());
        return "cliente/listar";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        model.addAttribute("cliente", clienteRepository.findById(id));
        return "cliente/editar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid Cliente cliente, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            Model model){
        if (bindingResult.hasErrors()){
            return "cliente/editar";
        }
        clienteRepository.save(cliente);
        redirectAttributes.addFlashAttribute("msg", "Cliente cadastrado!!!");
        return "redirect:/cliente/cadastro";
    }

    @PostMapping("editar")
    @Transactional
    public String editar(@Valid Cliente cliente, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        if (bindingResult.hasErrors()){
            return "cliente/editar";
        }
        clienteRepository.save(cliente);
        redirectAttributes.addFlashAttribute("msg", "Atualizado com sucesso!!!");
        return "redirect:/cliente/listar";
    }

    @PostMapping("excluir")
    @Transactional
    public String remover(Long idStatus, RedirectAttributes redirectAttributes){
        clienteRepository.deleteById(idStatus);
        redirectAttributes.addFlashAttribute("msg", "Cliente removido!!!");
        return "redirect:/cliente/listar";
    }
}
