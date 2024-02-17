package br.com.acme.biblioteca.controller;

import br.com.acme.biblioteca.model.Cliente;
import br.com.acme.biblioteca.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    Logger logger = LoggerFactory.getLogger(ClienteController.class);
    @GetMapping("/view-all")
    public ModelAndView getAll(ModelAndView model){
        //ClienteService clienteService = new ClienteService();
        List<Cliente> all = clienteService.getAll();
        logger.info("ALL: " + all.size());
        model.addObject("clientes",all);
        model.setViewName("clientes/view-all");
        //WEB-INF/jsp/clientes/view-all.jsp
        return model;
    }
    @GetMapping("/deletar/{id}")
    public RedirectView deletar(@PathVariable int id, RedirectAttributes redirectAttributes){
        //ClienteService clienteService = new ClienteService();
        Cliente byId = clienteService.getById(id);
        logger.info("Cliente a ser removido: " + byId.toString());
        clienteService.deleteById(id);
        redirectAttributes.addFlashAttribute("cliente", byId);
        redirectAttributes.addFlashAttribute("removidoComSucesso", true);
        final RedirectView redirectView = new RedirectView("/clientes/view-all", true);
        return redirectView;
    }

}
