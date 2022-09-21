package com.library.crudapi.crudapi.dto.response;
import com.library.crudapi.crudapi.entity.Autor;
import com.library.crudapi.crudapi.entity.Editora;
import com.library.crudapi.crudapi.entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroResponseDTO {
    @NotNull(message = "Campo autor não pode estar vazio.")
    private Autor autor;

    @NotNull(message = "Campo editora não pode estar vazio.")
    private Editora editora;

    @NotBlank(message = "Campo nome não pode estar vazio.")
    private String nome;

    @NotBlank(message = "Campo genero não pode estar vazio.")
    private String genero;


    public LivroResponseDTO(Livro livro){
        this.autor = livro.getAutor();
        this.editora = livro.getEditora();
        this.nome = livro.getNome();
        this.genero=livro.getGenero();

    }


}