package pl.kamil.videoapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kamil.videoapp.dao.entity.VideoCassette;

@Repository
public interface VIdeoCassetteRepo extends CrudRepository<VideoCassette,Long> {
}
