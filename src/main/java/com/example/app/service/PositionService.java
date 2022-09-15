package com.example.app.service;

import com.example.app.model.Position;

import java.util.List;

public interface PositionService {

    List<Position> getAllPosition();

    Position updatePosition(Position position);

    Position createPosition(Position position);

    void deletePosition(Long id);

}
