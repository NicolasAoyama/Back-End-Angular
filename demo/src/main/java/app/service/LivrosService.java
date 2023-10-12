package app.service;

import java.util.ArrayList;
import java.util.List;

import app.dto.LivrosDTO;
import app.entity.Livros;
import app.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LivrosService {

    @Autowired
    private LivrosRepository livrosRepository;

    public List<LivrosDTO> listAll(){
        List<Livros> lista = livrosRepository.findAll();
        List<LivrosDTO> listaDTO = new ArrayList<>();

        for(int i=0; i<lista.size(); i++)
            listaDTO.add(this.toLivrosDTO(lista.get(i)));

        return listaDTO;
    }

    public LivrosDTO save(LivrosDTO livrosDTO){
        Livros livros = this.toLivros(livrosDTO);

        Livros livrosalvo = livrosRepository.save(livros);

        return this.toLivrosDTO(livrosalvo);
    }

    private LivrosDTO toLivrosDTO(Livros livros) {
        LivrosDTO livrosDTO = new LivrosDTO();
        livrosDTO.setId(livros.getId());
        livrosDTO.setTitulo(livros.getTitulo());
        livrosDTO.setAutor(livros.getAutor());
        return livrosDTO;
    }

    private Livros toLivros(LivrosDTO livrosDTO) {
        Livros livros = new Livros();
        livros.setId(livrosDTO.getId());
        livros.setTitulo(livrosDTO.getTitulo());
        livros.setAutor(livrosDTO.getAutor());
        return livros;
    }

}
