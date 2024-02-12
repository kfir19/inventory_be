package com.kfir.inventory_be.servicesImpl;

import com.kfir.inventory_be.data.AggregatedHistory;
import com.kfir.inventory_be.data.HistoryDate;
import com.kfir.inventory_be.data.HistoryTime;
import com.kfir.inventory_be.models.History;
import com.kfir.inventory_be.models.Person;
import com.kfir.inventory_be.repositories.HistoryRepository;
import com.kfir.inventory_be.repositories.PeopleRepository;
import com.kfir.inventory_be.services.HistoryService;
import com.kfir.inventory_be.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository repo;

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
    public List<History> findByItemIdOrderByTimeAsc(UUID id) {
        return repo.findByItemIdOrderByTimeAsc(id);
    }

    @Override
    public List<History> findByPersonIdOrderByDateAsc(UUID id) {
        return repo.findByPersonIdOrderByDateAsc(id);
    }

    @Override
    public List<History> findByItemIdOrderByDateAsc(UUID id) {
        return repo.findByItemIdOrderByDateAsc(id);
    }

    @Override
    public List<History> findByPersonIdOrderByTimeDesc(UUID id) {
        return repo.findByPersonIdOrderByTimeDesc(id);
    }

    @Override
    public List<History> findByItemIdOrderByTimeDesc(UUID id) {
        return repo.findByItemIdOrderByTimeDesc(id);
    }

    @Override
    public List<History> findByPersonIdOrderByDateDesc(UUID id) {
        return repo.findByPersonIdOrderByDateDesc(id);
    }

    @Override
    public List<History> findByItemIdOrderByDateDesc(UUID id) {
        return repo.findByItemIdOrderByDateDesc(id);
    }

    @Override
    public List<History> findByItemIdOrderByDateDescTimeDesc(UUID id){
        return repo.findByItemIdOrderByDateDescTimeDesc(id);
    }

    @Override
    public List<History> findByPersonIdOrderByDateDescTimeDesc(UUID id){
        return repo.findByPersonIdOrderByDateDescTimeDesc(id);
    }

    @Override
    public AggregatedHistory findAggregatedHistoryByPersonId(UUID id) {

        List<History> personHistory = findByPersonIdOrderByDateDescTimeDesc(id);

        AggregatedHistory aggregatedHistory = buildAggregatedHistory(id.toString(), personHistory);

        return aggregatedHistory;
    }
    @Override
    public AggregatedHistory findAggregatedHistoryByItemId(UUID id) {

        List<History> itemHistory = findByItemIdOrderByDateDescTimeDesc(id);

        AggregatedHistory aggregatedHistory = buildAggregatedHistory(id.toString(), itemHistory);

        return aggregatedHistory;
    }

    @Override
    public List<History> saveAll(List<History> histories) {
        return repo.saveAll(histories);
    }

    private AggregatedHistory buildAggregatedHistory(String id, List<History> historyCollection) {
        AggregatedHistory aggregatedHistory = new AggregatedHistory(id);

        for (History history : historyCollection) {
            HistoryDate historyDate;
            if (aggregatedHistory.getHistoryDate().isEmpty()) {
                historyDate = new HistoryDate(history.getDate(), history.getTime(), history.getMessage());
                aggregatedHistory.getHistoryDate().add(historyDate);
            } else {
                List<HistoryDate> historyDates = aggregatedHistory.getHistoryDate().stream().filter(date -> date.getDateTitle().equals(history.getDate())).collect(Collectors.toList());
                if (historyDates.isEmpty()) {
                    historyDate = new HistoryDate(history.getDate(), history.getTime(), history.getMessage());
                    aggregatedHistory.getHistoryDate().add(historyDate);
                } else {
                    HistoryTime hTime = new HistoryTime(history.getTime(), history.getMessage());
                    historyDate = historyDates.get(0);
                    historyDate.getHistoryTime().add(hTime);
                }
            }
        }

        return aggregatedHistory;
    }


}
