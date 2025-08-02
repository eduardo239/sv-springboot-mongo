package sv_springboot_mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sv_springboot_mongo.api.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
}
