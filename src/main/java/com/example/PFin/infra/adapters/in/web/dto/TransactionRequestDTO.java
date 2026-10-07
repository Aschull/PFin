package com.example.PFin.infra.adapters.in.web.dto;

import com.sun.istack.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionRequestDTO(
    @NotBlank(message = "Description can`t be empty") String description,
    @NotNull @Positive(message = "Amount must be higher than zero") BigDecimal amount,
    @NotBlank(message = "Type can`t be empty") String type,
    @NotNull LocalDate date) {}
