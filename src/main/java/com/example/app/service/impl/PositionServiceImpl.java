package com.example.app.service.impl;

import com.example.app.model.Position;
import com.example.app.repository.PositionRepo;
import com.example.app.service.PositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepo positionRepo;

    public PositionServiceImpl(PositionRepo positionRepo) {
        this.positionRepo = positionRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Position> getAllPosition() {
        return positionRepo.allPositions();
    }

    @Override
    @Transactional
    public Position updatePosition(Position position) {
        positionRepo.updatePosition(position);
        return position;
    }

    @Override
    @Transactional
    public Position createPosition(Position position) {
        return positionRepo.createPosition(position);
    }

    @Override
    @Transactional
    public void deletePosition(Long id) {
        Position position = positionRepo.getById(id);
        positionRepo.deletePosition(position);
    }
}
