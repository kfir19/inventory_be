package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.models.History;
import com.kfir.inventory_be.repositories.HistoryRepository;
import com.kfir.inventory_be.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository repo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<History> getAllByItemId(UUID id) {
        return repo.getAllByItemId(id);
    }

    @Override
    public List<History> getAllByPersonId(UUID id) {
        return repo.getAllByPersonId(id);
    }

    @Override
    public List<History> findByPersonIdOrderByTimeAsc(UUID id) {
        return repo.findByPersonIdOrderByTimeAsc(id);
    }
    @Override
    public List<History> saveAll(List<History> histories) {
        return repo.saveAll(histories);
    }


    public List<History> getHistoryByPersonIdOrderByDate(UUID id){

        MatchOperation matchOperation = Aggregation.match(Criteria.where("personId").is(id));
        GroupOperation groupOperation = new GroupOperation(Fields.fields("date","time"));
        SortOperation sortOperation = new SortOperation(Sort.by("date","time"));

        Aggregation aggregation = Aggregation.newAggregation(
                matchOperation,groupOperation,sortOperation
        );

        TypedAggregation<History> historyAggregation = Aggregation.newAggregation(History.class,
                matchOperation,
                Aggregation.group("date").push("$$ROOT").as("peopleHistory")
        );

        return mongoTemplate.aggregate(historyAggregation,"histories",History.class).getMappedResults();
    }

}
