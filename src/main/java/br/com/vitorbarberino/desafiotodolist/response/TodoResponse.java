package br.com.vitorbarberino.desafiotodolist.response;
import java.util.UUID;
import br.com.vitorbarberino.desafiotodolist.entity.Todo;

public record TodoResponse(
    UUID id,
    String nome,
    String descricao,
    Boolean realizado,
    Integer prioridade
) {
    public TodoResponse(Todo todo) {
        this(todo.getId(), todo.getNome(), todo.getDescricao(), todo.getRealizado(), todo.getPrioridade());
    }
}
