package mx.gob.eventosComunitarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mx.gob.eventosComunitarios.dao.EventoInterface;
import mx.gob.eventosComunitarios.entity.Evento;


@Controller
public class ViewController {
	
	@Autowired
	private EventoInterface eventoInterface;
	
	@GetMapping("/")
	public String index(@ModelAttribute("evento") Evento evento, BindingResult result,  Model modelo) {
		List<Evento> listaEvent= eventoInterface.findAll();
		modelo.addAttribute("listaTL", listaEvent);
		return "index";
	}
	
	@PostMapping("/evento-create")
	public String categoryCreate(Evento evento) {
		if(evento.getIdEvento() == 0) {
			eventoInterface.save(evento);
		}else {
			eventoInterface.update(evento);
		}

		return "redirect:/";
	}
	
	@GetMapping("/evento-delete/{id}")
	public String categoryDelete(@PathVariable("id") Integer id) {
		eventoInterface.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/evento-update/{id}")
	public String categoryUpdate(@PathVariable("id") Integer id, @ModelAttribute("evento") Evento evento, BindingResult result,  Model modelo) {
		evento = eventoInterface.findOne(id);
		List<Evento> listaLang= eventoInterface.findAll();
		modelo.addAttribute("listaTL", listaLang);
		modelo.addAttribute("evento", evento);
		return "index";
	}
}
