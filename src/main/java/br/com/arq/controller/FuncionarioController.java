package br.com.arq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.arq.model.Funcionario;
import br.com.arq.respository.FuncionarioRepository;

@RequestMapping("/funcionario")
@Controller
public class FuncionarioController {

	 @Autowired
	 private FuncionarioRepository repository;
   
	 @GetMapping("/")
	 public String init(Model model) {
		 model.addAttribute("funcionario", new Funcionario());
		 return "funcionarioform";
	 }
	
	   
	  @GetMapping("/entrar")
	 public String formfuncionariocreate(Model model) {
		 model.addAttribute("funcionario", new Funcionario());
		 return "funcionarioform";
	 }
	  
	
	  @PostMapping("/cadastrar")
	  public String cadastrarFuncionario(@ModelAttribute("funcionario") Funcionario funcionario, BindingResult result, Model model ) {
		  try {
			  
		 funcionario.setStatus("CREATED");
		  Funcionario resposta = repository.save(funcionario);
		  
		  if (resposta ==null) {
			  throw new Exception("email duplicado");
		  }
		  model.addAttribute("message", resposta);
		  model.addAttribute("funcionario", new Funcionario());
		   return "funcionarioform";
		  }catch(Exception ex) {
			  model.addAttribute("message",  ex.getMessage());
			  return "funcionarioform";	  
		  }
		  
		 
	  }
}
