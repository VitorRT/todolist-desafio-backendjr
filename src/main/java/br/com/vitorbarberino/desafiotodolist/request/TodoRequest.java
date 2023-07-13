package br.com.vitorbarberino.desafiotodolist.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TodoRequest(
    @NotBlank(message="o nome não pode ser nulo ou vazio.")
    String nome,
    @NotBlank(message="a descricao não pode ser nula ou vazia.")
    String descricao,
    @NotNull(message="a prioridade não pode ser nula.")
    Integer prioridade
) {  }
