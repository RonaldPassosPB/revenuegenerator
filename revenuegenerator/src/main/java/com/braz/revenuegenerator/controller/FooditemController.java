package com.braz.revenuegenerator.controller;

import com.braz.revenuegenerator.Model.Fooditem;
import com.braz.revenuegenerator.Service.FooditemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FooditemController {

    private FooditemService service;

    public FooditemController(FooditemService service) {
        this.service = service;
    }

    //POST
    @PostMapping
    public ResponseEntity<Fooditem> criar(@RequestBody Fooditem fooditem){
            Fooditem salvo = service.salvar(fooditem);
            return  ResponseEntity.ok(salvo);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<Fooditem>> listar(){
        List<Fooditem> lista = service.listar();
        return ResponseEntity.ok(lista);
    }
    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Fooditem> atualizar(@RequestBody Fooditem fooditem, @PathVariable Long id   ){

        return service.buscarPorId(id)
                .map(itemExistente -> {
                    fooditem.setId(itemExistente.getId());
                    Fooditem atualizado = service.atualizar(fooditem);
                    return  ResponseEntity.ok(atualizado);
                        })
                .orElse(ResponseEntity.notFound().build());

    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
