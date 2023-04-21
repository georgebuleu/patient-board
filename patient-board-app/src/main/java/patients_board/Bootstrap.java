package patients_board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repo.PatientRepo;
import model.Patient;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "repo")
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackages = "repo")
public class Bootstrap implements CommandLineRunner {

    @Autowired
    PatientRepo patientRepo;

    @Override
    public void run(String... args) throws Exception {
        List<Patient> patients = patientRepo.findPatientsByHospitalId((long) 1);
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}
