package sv_springboot_mongo.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;
import sv_springboot_mongo.api.model.CATEGORIA;
import sv_springboot_mongo.api.model.Produto;

import java.util.List;

public interface ProdutoRepository extends MongoRepository<Produto, String> {

    List<Produto> findByNomeContainingIgnoreCase(String nome);
    List<Produto> findByPrecoBetween(Double precoMinimo, Double precoMaximo);
    List<Produto> findByCategoria(CATEGORIA categoria);
//    @NonNull
    Page<Produto> findAll(@NonNull Pageable pageable);
}
