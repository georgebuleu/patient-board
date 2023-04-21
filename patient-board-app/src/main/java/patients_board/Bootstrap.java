package patients_board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.PatientRepository;
import model.Patient;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "repository")
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackages = "repository")
public class Bootstrap implements CommandLineRunner {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Patient> patients = patientRepository.findPatientsByHospitalId((long) 1);
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}
