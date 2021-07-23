package com.dio.controleponto.controller;

import com.dio.controleponto.model.JornadaTrabalho;
import com.dio.controleponto.services.JornadaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "REST API - Controle de Acesso")
@RestController
@RequestMapping("/api/v1/jornadas")
public class JornadaTrabalhoController {

    private JornadaService service;

    @Autowired
    public JornadaTrabalhoController(JornadaService service) {
        this.service = service;
    }

    @ApiOperation(value = "Exibe todas as jornadas de trabalho por paginação")
    @GetMapping
    public ResponseEntity<Page<JornadaTrabalho>> findPage(Pageable pageable){
        Page<JornadaTrabalho> listObj = service.findPage(pageable);
        return ResponseEntity.ok().body(listObj);
    }

    @ApiOperation(value = "Exibe uma jornada de trabalho específica através do ID")
    @GetMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> findById(@PathVariable Long id){
        JornadaTrabalho obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Cria uma jornada de trabalho")
    @PostMapping
    public ResponseEntity<JornadaTrabalho> saveJornada(@RequestBody JornadaTrabalho obj){
        obj = service.saveJornada(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @ApiOperation(value = "Atualiza uma jornada de trabalho")
    @PutMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> updateJornada(@PathVariable Long id, @RequestBody JornadaTrabalho obj){
        obj.setId(id);
        obj = service.updateJornada(obj);
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Remove uma jornada de trabalho através do ID")
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
