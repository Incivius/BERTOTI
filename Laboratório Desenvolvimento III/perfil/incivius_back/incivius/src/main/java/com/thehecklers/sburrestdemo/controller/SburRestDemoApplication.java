package com.thehecklers.sburrestdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thehecklers.sburrestdemo.model.Experiencia;
import com.thehecklers.sburrestdemo.model.Habilidade;
import com.thehecklers.sburrestdemo.model.Perfil;
import com.thehecklers.sburrestdemo.model.Projeto;

@SpringBootApplication
public class SburRestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SburRestDemoApplication.class, args);
    }

}

@CrossOrigin(origins = { "http://localhost:8070", "http://127.0.0.1:5500" })
@RestController
@RequestMapping("/perfis")
class RestApiDemoController {
    private List<Perfil> perfis = new ArrayList<>();

    public RestApiDemoController() {

        List<String> tagsProjeto = new ArrayList<>();
        tagsProjeto.add("Java");

        // Criando a experiência
        Experiencia experiencia = new Experiencia();
        experiencia.setNome("Desenvolvedor Full stack");
        experiencia.setDataInicio(2023);
        experiencia.setDurationMeses(0);
        experiencia.setDescricao("Trabalho freelancer com desenvolvimento python, java e node.js");

        // Criando a habilidade
        Habilidade habilidade = new Habilidade();
        habilidade.setHabilidade("Comunicação");
        habilidade.setDescricao("Adoro falar, conversar, ensinar e ouvir");

        // Criando o projeto
        Projeto projeto = new Projeto();
        projeto.setNome("Api 3");
        projeto.setLink("https://github.com/projetoKhali/api3");
        projeto.setTagsStack("Java");
        projeto.setDescricao("Aplicação web para gerenciamento da jornada de trabalho");

        // Criando o perfil
        perfis.addAll(List.of(new Perfil("Marcos Malaquias", "23/06/2001",
                "Engraçado, criativo, sagaz e muito proativo", "mviniciusMalaquias@gmail.com",
                projeto, experiencia, habilidade)));

    }

    @GetMapping("/all")
    Iterable<Perfil> getPerfis() {
        return perfis;
    }

    @GetMapping
    List<Perfil> getPerfilByEmail(@RequestParam String email) {
        List<Perfil> perfisEncontrados = new ArrayList<>();

        for (Perfil perfil : perfis) {
            if (perfil.getEmail().equals(email)) {
                perfisEncontrados.add(perfil);
            }
        }

        return perfisEncontrados;
    }

    @PostMapping
    Perfil postPerfil(@RequestBody Perfil perfil) {
        perfis.add(perfil);
        return perfil;
    }

    @PutMapping("/{email}")
    ResponseEntity<Perfil> putPerfil(@PathVariable String email, @RequestBody Perfil perfil) {
        int perfilIndex = -1;

        for (Perfil p : perfis) {
            if (p.getEmail().equals(email)) {
                perfilIndex = perfis.indexOf(p);
                perfis.set(perfilIndex, perfil);
            }
        }

        return (perfilIndex == -1) ? new ResponseEntity<>(postPerfil(perfil), HttpStatus.CREATED)
                : new ResponseEntity<>(perfil, HttpStatus.OK);
    }

    @DeleteMapping
    void deletePerfil(@RequestParam String email) {
        perfis.removeIf(p -> p.getEmail().equals(email));
    }
}
