package com.m2u.interview.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.m2u.interview.db.entity.Record;
import com.m2u.interview.db.repository.RecordRepository;
import com.m2u.interview.domain.dto.RecordDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    private RecordRepository _recordRepository;

    public List<RecordDTO> find(Optional<Integer> customerId, Optional<String> accountNumber, PageRequest pageRequest) {
        Specification<Record> spec = Specification.where(null);
        if (customerId.isPresent()) {
            spec = spec.and(equalField("customerId", customerId.get()));
        }
        if (accountNumber.isPresent()) {
            spec = spec.and(equalField("accountNumber", accountNumber.get()));
        }
        Page<Record> result = _recordRepository.findAll(spec, pageRequest);
        return result.stream().map(c -> {
            return RecordDTO.builder()
                .accountNumber(c.getAccountNumber())
                .customerId(c.getCustomerId())
                .id(c.getId())
                .trxAmount(c.getTrxAmount())
                .trxDateTime(c.getTrxDateTime().toLocalDateTime())
                .trxDescr(c.getTrxDescr())
                .build();
        }).collect(Collectors.toList());
    }

	protected static Specification<Record> equalField(String fieldName, Object fieldValue) {
		return (root, query, cb) -> {
			return cb.equal(root.get(fieldName), fieldValue);
		};
	}
}
