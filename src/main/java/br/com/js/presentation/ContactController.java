package br.com.js.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.js.domain.contact.Contact;

@Controller
@RequestMapping("/contato")
public class ContactController {

	@RequestMapping(method = RequestMethod.GET)
	public String carregaTemplateContato(Model model) {
		Contact contato = new  Contact();
		model.addAttribute("contato", contato);
		return "contato/contato";
	}
	
	@RequestMapping(value="/salvar",method=RequestMethod.POST)
	private String salvar(Contact contato){
		
		return "contato/contato";
	}
}
