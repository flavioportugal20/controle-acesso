package com.dio.controleponto.services;

import com.dio.controleponto.model.JornadaTrabalho;
import com.dio.controleponto.repositories.JornadaRepository;
import com.dio.controleponto.services.exceptions.DataIntegrityException;
import com.dio.controleponto.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class JornadaService {

    private JornadaRepository jornadaRepository;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    @Transactional(readOnly = true)
    public JornadaTrabalho findById(Long id){
        Optional<JornadaTrabalho> obj = jornadaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Jornada não encontrada!"));
    }

    @Transactional
    public JornadaTrabalho saveJornada(JornadaTrabalho obj){
        obj.setId(null);
        return jornadaRepository.save(obj);
    }

    @Transactional
    public JornadaTrabalho updateJornada(JornadaTrabalho obj){
        //lança uma exceção se não encontrar
        findById(obj.getId());
        return jornadaRepository.save(obj);
    }

    public void delete(Long id){
        findById(id);
        try{
            jornadaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir a jornada de trabalho!");
        }
    }

    @Transactional(readOnly = true)
    public Page<JornadaTrabalho> findPage(Pageable pageable){
        return jornadaRepository.findAll(pageable);
    }


}
