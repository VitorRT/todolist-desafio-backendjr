package br.com.vitorbarberino.desafiotodolist.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

import br.com.vitorbarberino.desafiotodolist.request.TodoRequest;

@Entity
@Table(name="todos")
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String descricao;
    private Boolean realizado = false;
    private Integer prioridade;

    public Todo() { }

    public Todo(String nome, String descricao, Boolean realizado, Integer prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
    }

    public Todo(TodoRequest todoRequest) {
        this.nome = todoRequest.nome();
        this.descricao = todoRequest.descricao();
        this.prioridade = todoRequest.prioridade();
    }
}
