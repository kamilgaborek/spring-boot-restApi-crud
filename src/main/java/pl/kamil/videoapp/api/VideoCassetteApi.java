package pl.kamil.videoapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kamil.videoapp.dao.entity.VideoCassette;
import pl.kamil.videoapp.manager.VideoCassetteManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts")
public class VideoCassetteApi  {
    //NAJPIERW TWORZYLISMY NA LISCIE DO CZASU UTWORZENIA BAZY DANYCH
    public List<VideoCassette> videoCassettes;

    public VideoCassetteApi(){
        videoCassettes=new ArrayList<>();
        videoCassettes.add(new VideoCassette(1L,"Titanic", LocalDate.of(1995,1,1)));
        videoCassettes.add(new VideoCassette(2L,"300",LocalDate.of(2012,12,1)));

    }

    /*private VideoCassetteManager videoCassettes;

    @Autowired
    public VideoCassetteApi(VideoCassetteManager videoCassettes) {
        this.videoCassettes = videoCassettes;
    }

    //GetMapping służy do pobierania wartości
    @GetMapping("/all")
    public Iterable<VideoCassette> getAll(){
        return  videoCassettes.findAll();
    }*/

    @GetMapping
    public VideoCassette getById(@RequestParam int index){
        Optional<VideoCassette> first = videoCassettes.stream().
                filter(element -> element.getId() ==index).findFirst();
        return first.get();
    }

    //PostMapping słuzy do dodawania wartości
    @PostMapping
    public boolean addVideo(@RequestBody VideoCassette videoCassette){
        return videoCassettes.add(videoCassette);
    }

    /*//PutMapping nadpisywanie
    @PutMapping
    public VideoCassette updateVideo(){

    }
*/
    @DeleteMapping
    public boolean deleteVideo(@RequestParam int index){
        return videoCassettes.removeIf(element -> element.getId()==index);
    }
}
