package com.aluracursos.desafioSpring.principal;

import com.aluracursos.desafioSpring.model.Datos;
import com.aluracursos.desafioSpring.model.DatosLibros;
import com.aluracursos.desafioSpring.service.ConsumoApi;
import com.aluracursos.desafioSpring.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    public void muestraMenu(){
        var json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        //Top 10 libros mas descargados
        System.out.println("Top 10 libros mas descargados");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDeDescargas).reversed())
                .limit(10)
                .map(l->l.titulo().toUpperCase())
                .forEach(System.out::println);

        //Busqueda de libros por nombre
        System.out.println("Ingrese el libro que desea buscar");
        var tituloLibro = teclado.nextLine();
         json = consumoApi.obtenerDatos(URL_BASE+"?search="+tituloLibro.replace(" ","+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l->l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if(libroBuscado.isPresent()){
            System.out.println("Libro encontrado");
            System.out.println(libroBuscado.get());
        }else{
            System.out.println("Libro no encontrado");
        }

        DoubleSummaryStatistics est=datosBusqueda.resultados().stream()
                .filter(d->d.numeroDeDescargas()>0.0)
                .collect(Collectors.summarizingDouble(DatosLibros::numeroDeDescargas));
        System.out.println("Cantidad media de descargas"+est.getAverage());
        System.out.println("Libro con cantidad maxima de descargas: "+est.getMax());
        System.out.println("Libro con cantidad minima de descargas: "+est.getMin());
        System.out.println("Cantidad de registros evaluados para obtener las estadisticas: "+est.getCount());
    }

}
