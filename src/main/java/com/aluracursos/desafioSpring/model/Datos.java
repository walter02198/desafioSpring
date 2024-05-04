package com.aluracursos.desafioSpring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos( @JsonAlias("results") List<DatosLibros>resultados) {


}
