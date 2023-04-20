package patients_board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.Patient;
import repo.PatientRepo;
import java.util.List;

@SpringBootApplication
public class SpringApp implements CommandLineRunner {
    @Autowired
    PatientRepo patientRepo;
    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Patient> patients = patientRepo.findPatientsByHospitalId((long) 2);
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}
