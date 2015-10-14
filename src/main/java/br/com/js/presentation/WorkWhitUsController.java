
package br.com.js.presentation;

import br.com.js.domain.service.MailService;
import br.com.js.domain.mail.Mail;
import br.com.js.domain.mail.MailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author fernando
 */

@Controller
@RequestMapping("/trabalheConosco")
public class WorkWhitUsController {
    
    @Autowired private MailService service;
    @Autowired private MailFactory factory;
    
    @RequestMapping(method = RequestMethod.GET)
    public String carregaTemplateTrabalheConosco(){
        return "trabalheConosco/trabalhe-conosco";
    }
    @RequestMapping(value="/enviaCurriculo",method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("name") String name,Model model){
        Mail email = factory.curriculumWorkWhitUs(name, file);
        service.sendMail(email);
        model.addAttribute("ok", " Obrigado pelo envio do seu currículo.");
        
        return "/trabalheConosco/trabalhe-conosco";
    }
    
}
