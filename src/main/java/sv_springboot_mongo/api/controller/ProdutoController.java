package sv_springboot_mongo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sv_springboot_mongo.api.model.CATEGORIA;
import sv_springboot_mongo.api.model.Produto;
import sv_springboot_mongo.api.repository.ProdutoRepository;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;


    @GetMapping
    public Page<Produto> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable String id, @RequestBody Produto produto) {
        produto.setId(id);
        return repository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        repository.deleteById(id);
    }

    // queries
    @GetMapping("/query")
    public List<Produto> buscarPorNome(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Double precoMinimo,
            @RequestParam(required = false) Double precoMaximo,
            @RequestParam(required = false) String categoria
    ) {



        if (precoMinimo != null && precoMaximo != null) {
            return repository.findByPrecoBetween(precoMinimo, precoMaximo);
        }
        if (categoria != null) {
            try {
                CATEGORIA catEnum = CATEGORIA.valueOf(categoria.toUpperCase());
                return repository.findByCategoria(catEnum);
            } catch (IllegalArgumentException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria inválida");
            }
        }
        if(nome == null || nome.isEmpty()) {
            return repository.findAll();
        }
        return repository.findByNomeContainingIgnoreCase(nome);

    }


}