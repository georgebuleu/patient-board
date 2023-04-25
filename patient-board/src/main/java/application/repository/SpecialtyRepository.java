package application.repository;


import application.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SpecialtyRepository extends JpaRepository<Speciality, Long> {

    List<Speciality> findByHospitalId(Long hospitalId);

}
