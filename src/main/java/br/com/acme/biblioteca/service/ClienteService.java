package br.com.acme.biblioteca.service;

import br.com.acme.biblioteca.model.Cliente;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ClienteService {
    private  List<Cliente> clientes = initClientes();

    private List<Cliente> initClientes() {
        Faker faker = new Faker();
        ArrayList<Cliente> clientes1 = new ArrayList<>();
        for(int i = 1;i<=100;i++){
            Cliente cliente = new Cliente(i, faker.name().firstName(), faker.name().lastName(), faker.idNumber().valid());
            clientes1.add(cliente);
        }
        return clientes1;
    }
    public List<Cliente> getAll(){
        return this.clientes;
    }
    public Cliente getById(int id){
        Cliente found = this.clientes.stream().filter(cliente -> cliente.getId() == id).findFirst().get();
        return found;
    }


    public void deleteById(int id) {
        Cliente byId = getById(id);
        this.clientes.remove(byId);
    }
}
