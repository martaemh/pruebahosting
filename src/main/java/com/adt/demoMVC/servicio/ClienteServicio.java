package com.adt.demoMVC.servicio;

import java.util.List;

import com.adt.demoMVC.modelo.Cliente;

public interface ClienteServicio {

	public void guardarCliente(Cliente cliente);
	public void eliminarCliente(Cliente cliente);
	public void eliminarClientePorId(int idCliente);
	public List<Cliente> listarClientes();
	public Cliente buscarClientePorId(int idCliente);
	public List<Cliente> buscarPorCif(String cif);
}

