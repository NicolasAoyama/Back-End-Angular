package app.service;

import java.util.ArrayList;
import java.util.List;

import app.dto.CarrosDTO;
import app.dto.LivrosDTO;
import app.entity.Carros;
import app.entity.Livros;
import app.repository.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarrosService {

    @Autowired
    private CarrosRepository carrosRepository;

    public List<CarrosDTO> listAll(){
        List<Carros> lista = carrosRepository.findAll();
        List<CarrosDTO> listaDTO = new ArrayList<>();

        for(int i=0; i<lista.size(); i++)
            listaDTO.add(this.toCarrosDTO(lista.get(i)));

        return listaDTO;
    }

    public CarrosDTO save(CarrosDTO carrosDTO){
        Carros carros = this.toCarros(carrosDTO);

        Carros carrosalvo = carrosRepository.save(carros);

        return this.toCarrosDTO(carrosalvo);
    }

    private CarrosDTO toCarrosDTO(Carros carros) {
        CarrosDTO carrosDTO = new CarrosDTO();
        carrosDTO.setId(carros.getId());
        carrosDTO.setNome(carros.getNome());
        carrosDTO.setAno(carros.getAno());
        return carrosDTO;
    }

    private Carros toCarros(CarrosDTO carrosDTO) {
        Carros carros = new Carros();
        carros.setId(carrosDTO.getId());
        carros.setNome(carrosDTO.getNome());
        carros.setAno(carrosDTO.getAno());
        return carros;
    }

}
