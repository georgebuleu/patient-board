package patients_board;

import model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repo.PatientRepo;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "repo")
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackages = "repo")
public class SpringApp implements CommandLineRunner {

    @Autowired
    PatientRepo patientRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Patient> patients = patientRepo.findPatientsByHospitalId((long) 1);
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}
