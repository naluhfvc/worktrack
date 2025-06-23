package com.wtproject.worktrack.config;

import com.wtproject.worktrack.model.*;
import com.wtproject.worktrack.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class DataSeeder {

    private final SetorRepository setorRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final TarefaRepository tarefaRepository;

    @Bean
    @Transactional
    public CommandLineRunner seedDatabase() {
        return args -> {
            if (setorRepository.count() > 0 || funcionarioRepository.count() > 0 || tarefaRepository.count() > 0) {
                System.out.println("Dados já existem. Seed ignorado.");
                return;
            }

            Setor setorTI = new Setor("Tecnologia da Informação");
            Setor setorRH = new Setor("Recursos Humanos");
            setorRepository.saveAll(Arrays.asList(setorTI, setorRH));

            Funcionario joao = new Funcionario("João Silva", "Dev Backend", "joao@empresa.com", setorTI);
            Funcionario maria = new Funcionario("Maria Souza", "Analista RH", "maria@empresa.com", setorRH);
            funcionarioRepository.saveAll(Arrays.asList(joao, maria));

            Tarefa t1 = new Tarefa("Criar endpoints", "Implementar API REST", joao);
            Tarefa t2 = new Tarefa("Revisar currículos", "Selecionar candidatos", maria);
            Tarefa t3 = new Tarefa("Documentar código", "Gerar documentação Swagger", joao);
            tarefaRepository.saveAll(Arrays.asList(t1, t2, t3));

            System.out.println("Seed inserido com sucesso!");
        };
    }
}
