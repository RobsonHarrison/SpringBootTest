package com.sky.springBootTest.controller;
import com.sky.springBootTest.model.Quote;
import com.sky.springBootTest.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Optional;


@RestController
public class QuoteController {

    @GetMapping("/data")
    @ResponseBody
    public String getData() {
        // Retrieve data from the database and return it in JSON format
        return "{\"data\": [{\"name\": \"Robson\", \"age\": 30}, {\"name\": \"Jane\", \"age\": 25}]}";
    }




    @Autowired
    private QuoteRepository quoteRepository;




    @GetMapping("/quotes")
    public List<Quote> getQuotes(@RequestParam("search") Optional<String> searchParam){
        return searchParam.map( param->quoteRepository.getContainingQuote(param) )
                .orElse(quoteRepository.findAll());
    }

    @GetMapping("/quotes/{quoteId}" )
    public ResponseEntity<String> readQuote(@PathVariable("quoteId") Long id) {
        return ResponseEntity.of(quoteRepository.findById(id).map(Quote::getQuote));
    }

    @PostMapping("/quotes")
    public Quote addQuote(@RequestBody String quote) {
        Quote q = new Quote();
        q.setQuote(quote);
        return quoteRepository.save(q);
    }


    @RequestMapping(value="/quotes/{quoteId}", method=RequestMethod.DELETE)
    public void deleteQuote(@PathVariable(value = "quoteId") Long id) {
        quoteRepository.deleteById(id);
    }

    public static void main(String[] args) {
        SpringApplication.run(QuoteController.class, args);
    }
}
