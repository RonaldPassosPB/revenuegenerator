package com.braz.revenuegenerator.Service;

import com.braz.revenuegenerator.Model.Fooditem;
import com.braz.revenuegenerator.repository.FooditemRepository;
import jakarta.servlet.http.PushBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FooditemService {

    private FooditemRepository repository;

    public FooditemService(FooditemRepository repository) {
        this.repository = repository;
    }

    public Fooditem salvar(Fooditem fooditem) {
        return repository.save(fooditem);
    }

    public List<Fooditem> listar() {
        return repository.findAll();
    }

    public Optional<Fooditem> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Fooditem atualizar(Fooditem fooditem) {
        return repository.save(fooditem);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

}