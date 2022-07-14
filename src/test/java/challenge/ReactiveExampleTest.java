package challenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ReactiveExampleTest {

    @InjectMocks
    ReactiveExample reactiveExample;


    @Test
    void sumaDePuntajes(){

        var suma = reactiveExample.sumaDePuntajes();

        StepVerifier.create(suma)
                .expectNext(260)
                .verifyComplete();

    }

    @Test
    void mayorPuntajeDeEstudiante(){

        var valor = reactiveExample.mayorPuntajeDeEstudiante(1);

        StepVerifier.create(valor)
                .expectNextMatches(estudiante -> estudiante.getNombre().equals("pedro"))
                .verifyComplete();

    }

    @Test
    void totalDeAsisntenciasDeEstudiantesComMayorPuntajeDe(){

        var puntaje = reactiveExample.totalDeAsisntenciasDeEstudiantesConMayorPuntajeDe(75);

        StepVerifier.create(puntaje)
                .expectNext(43)
                .verifyComplete();

    }

    @Test
    void elEstudianteTieneAsistenciasCorrectas(){
        var asistencias = reactiveExample.elEstudianteTieneAsistenciasCorrectas(new Estudiante("raul", 30, List.of(5, 2, 1, 4, 5)));

        StepVerifier.create(asistencias)
                .expectNext(Boolean.TRUE)
                .verifyComplete();

    }

    @Test
    void promedioDePuntajesPorEstudiantes(){

        var promedio = reactiveExample.promedioDePuntajesPorEstudiantes();

        StepVerifier.create(promedio)
                .expectNext(52.0)
                .verifyComplete();

    }

    @Test
    void estudiantesAprovados(){
        var estudiantes = reactiveExample.estudiantesAprovados();

        StepVerifier.create(estudiantes)
                .expectNext("juan", "pedro")
                .verifyComplete();
    }
}