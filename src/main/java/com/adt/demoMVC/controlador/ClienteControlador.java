package com.adt.demoMVC.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adt.demoMVC.modelo.Cliente;
import com.adt.demoMVC.servicio.ClienteServicioImpl;

@Controller
public class ClienteControlador {
	
	@Autowired
	ClienteServicioImpl clienteServicio;
	
	@GetMapping("/index")
	public String allClients(Model modelo) {
		List<Cliente>clientes=clienteServicio.listarClientes();
		modelo.addAttribute("clientes",clientes);
		return "index"; 
	}
	
	@GetMapping("/insertar")
	public String insertar(Model modelo) {
		modelo.addAttribute("cliente",new Cliente());
		return "insertar";
	}
	
	@PostMapping("/insertarSubmit")
	public String insertarSubmit(@ModelAttribute Cliente cliente, Model modelo){
		clienteServicio.guardarCliente(cliente);
		modelo.addAttribute("clientes", clienteServicio.listarClientes());
		return "index";
	}
	
	@GetMapping("/eliminar")
	public String eliminar (@RequestParam int idCliente, Model modelo) {
		clienteServicio.eliminarClientePorId(idCliente);
		modelo.addAttribute("clientes",clienteServicio.listarClientes());
		return "index";
	}
	
	@GetMapping("/modificar")
	public String modificar (@RequestParam int idCliente, Model modelo) {
		modelo.addAttribute("cliente",clienteServicio.buscarClientePorId(idCliente));
		return "modificar";
	}
	
	@PostMapping("/modificarSubmit")
	public String modificarSubmit(@ModelAttribute Cliente cliente, Model modelo){
		clienteServicio.guardarCliente(cliente);
		modelo.addAttribute("clientes", clienteServicio.listarClientes());
		return "index";
	}
}

