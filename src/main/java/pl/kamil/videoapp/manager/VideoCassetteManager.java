package pl.kamil.videoapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.kamil.videoapp.dao.VIdeoCassetteRepo;
import pl.kamil.videoapp.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {

    public VIdeoCassetteRepo vIdeoCassetteRepo;

    @Autowired
    public VideoCassetteManager(VIdeoCassetteRepo vIdeoCassetteRepo) {
        this.vIdeoCassetteRepo = vIdeoCassetteRepo;
    }

    public Optional<VideoCassette> findById(Long id){
        return  vIdeoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll(){
        return vIdeoCassetteRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette){
        return vIdeoCassetteRepo.save(videoCassette);
    }

    public void delete(Long id){
        vIdeoCassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new VideoCassette(1L,"Titanic", LocalDate.of(1995,1,1)));
        save(new VideoCassette(2L,"300",LocalDate.of(2012,12,1)));

    }
}
