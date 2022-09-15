package com.example.app.controller;

import com.example.app.controller.msg.Message;
import com.example.app.model.Position;
import com.example.app.service.PositionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/all")
    @ApiOperation("Все позиции")
    public ResponseEntity<List<Position>> getAllPosition() {
        return new ResponseEntity(positionService.getAllPosition(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ApiOperation("Добавление позиции")
    public ResponseEntity<Position> createPosition(@RequestBody Position position) {
        return new ResponseEntity(positionService.createPosition(position), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ApiOperation("Обновление данных о позиции")
    public ResponseEntity<Position> updatePosition(@RequestBody Position position) {
        return new ResponseEntity(positionService.updatePosition(position), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Удаление позиции")
    public ResponseEntity<Message> deletePosition(@PathVariable(name = "id") Long id) {
        positionService.deletePosition(id);
        return new ResponseEntity(new Message("Позиция удалена"), HttpStatus.OK);
    }
}
