package com.adt.demoMVC.servicio;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adt.demoMVC.modelo.Cliente;
import com.adt.demoMVC.repositorio.ClienteRepositorio;


@Service
public class ClienteServicioImpl implements ClienteServicio {

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Override
	public void guardarCliente(Cliente cliente) {
		clienteRepositorio.save(cliente);
	}
	
	@Override
	public void eliminarCliente(Cliente cliente) {
		clienteRepositorio.delete(cliente);
	}
	
	@Override
	public void eliminarClientePorId(int idCliente) {
		clienteRepositorio.deleteById(idCliente);
	}

	@Override
	public List<Cliente> listarClientes() {
		return (List<Cliente>) clienteRepositorio.findAll();
	}

	@Override
	public Cliente buscarClientePorId(int idCliente) {
		return(clienteRepositorio
				.findById(idCliente)
				.orElseThrow(()-> new NoSuchElementException("El cliente no existe")));
	}

	@Override
	public List<Cliente> buscarPorCif(String cif) {
		return clienteRepositorio.findByCif(cif);
	}





}
