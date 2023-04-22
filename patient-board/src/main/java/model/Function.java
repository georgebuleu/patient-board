package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "function")
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long functionId;
    @NotNull
    @Column(name = "name")
        private String name;

    public Function() {
    }

    public Function(Long functionId, String name) {
        this.functionId = functionId;
        this.name = name;
    }

    public Long getFunctionId() {
            return functionId;
        }

        public void setFunctionId(Long functionId) {
            this.functionId = functionId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
