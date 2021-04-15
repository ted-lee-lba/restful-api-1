package com.m2u.interview.api.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.m2u.interview.api.model.ExceptionResponse;
import com.m2u.interview.domain.dto.RecordDTO;
import com.m2u.interview.domain.service.DataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/data")
public class DataController {
    private final Logger log = LoggerFactory.getLogger(DataController.class);

    @Autowired
    private DataService _dataService;

    @GetMapping(value = "record")
    public ResponseEntity<List<RecordDTO>> query(@RequestParam("customer-id") Optional<Integer> customerId, 
        @RequestParam("account-number") Optional<String> accountNumber, 
        @RequestParam(value = "page", defaultValue = "1") int page, 
        @RequestParam(value = "size", defaultValue = "10") int size) {
        
        PageRequest pageRequest = PageRequest.of(page, size);
        List<RecordDTO> result = _dataService.find(customerId, accountNumber, pageRequest);
        return ResponseEntity.ok(result);
    }

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ExceptionResponse> customHandleException(Exception ex) {
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ExceptionResponse.builder().timestamp(LocalDateTime.now()).error(ex.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build(), HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
