package br.com.vitorbarberino.desafiotodolist.controller;

import br.com.vitorbarberino.desafiotodolist.request.TodoRequest;
import br.com.vitorbarberino.desafiotodolist.response.TodoResponse;
import br.com.vitorbarberino.desafiotodolist.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todos")
@Tag(name="Todo 📝")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @PostMapping
    @Operation(
        summary = "Registro de tarefa.",
        description = "Registro de tarefa no banco de dados."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "201", description = "A tarefa foi cadastrada com sucesso."),
        @ApiResponse(responseCode = "400", description = "Os dados enviados são inválidos..")
    }
    )
    ResponseEntity<List<TodoResponse>> create(@RequestBody @Valid TodoRequest todoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todoRequest));
    }

    @GetMapping
    @Operation(
        summary = "Listagem de tarefas.",
        description = "Listagem geral de todas as tarefas cadastradas."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "200", description = "Os dados das tarefas foram retornados.")
    }
    )
    ResponseEntity<List<TodoResponse>> list() {
        return ResponseEntity.ok(todoService.list());
    }

    @PutMapping
    @Operation(
        summary = "Atualização de tarefa.",
        description = "Atualização de tarefa no banco de dados."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "200", description = "A tarefa foi atualizada com sucesso."),
        @ApiResponse(responseCode = "400", description = "Os dados enviados são inválidos..")
    }
    )
    ResponseEntity<List<TodoResponse>> update(@RequestBody @Valid TodoRequest todoRequest) {
        return ResponseEntity.ok(todoService.update(todoRequest));
    }

    @DeleteMapping("{id}")
    @Operation(
        summary = "Deleção de tarefa.",
        description = "Deleção de tarefa do banco de dados."
    )
    @ApiResponses( {
        @ApiResponse(responseCode = "200", description = "A tarefa foi deletada com sucesso."),
        @ApiResponse(responseCode = "400", description = "Id da tarefa inválido.")
    }
    )
    ResponseEntity<List<TodoResponse>> delete(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(todoService.delete(id));
    }

}
