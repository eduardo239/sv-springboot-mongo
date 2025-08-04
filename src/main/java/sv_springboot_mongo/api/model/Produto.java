package sv_springboot_mongo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "produtos")
public class Produto {
    @Id
    private String id;
    private String nome;
    private double preco;
    private CATEGORIA categoria;

    // Getters e setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public CATEGORIA getCategoria() { return categoria; }
    public void setCategoria(CATEGORIA categoria) { this.categoria = categoria; }


    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", categoria=" + categoria +
                '}';
    }
}