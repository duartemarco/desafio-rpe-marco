package com.rpe.desafioestagiariovehicle.exception;

import com.rpe.desafioestagiariovehicle.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice(basePackages = "com.rpe.desafioestagiariovehicle.controller")
public class VeiculoControllerAdvice {

    @ResponseBody
    @ResponseStatus
    @ExceptionHandler
    public ErrorDTO handleVeiculoNotFound (VeiculoNotFoundException veiculoNotFoundException) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setMessage("Veículo não encontrado");
        errorDTO.setTimestamp(new Date());
        return errorDTO;
    }

    @ResponseBody
    @ResponseStatus
    @ExceptionHandler
    public ErrorDTO handlePlacaExistente (PlacaExistenteException placaExistenteException) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.CONFLICT.value());
        errorDTO.setMessage("Placa já existente");
        errorDTO.setTimestamp(new Date());
        return errorDTO;
    }

}
