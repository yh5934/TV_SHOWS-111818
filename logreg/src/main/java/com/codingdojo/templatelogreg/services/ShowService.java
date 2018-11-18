package com.codingdojo.templatelogreg.services;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.codingdojo.templatelogreg.models.Show;
import com.codingdojo.templatelogreg.repositories.ShowRepository;

@Service
public class ShowService {
    // adding the Show repository as a dependency
    private final ShowRepository showRepository;
    
    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    // CRUD METHODS
    
        // CREATE
        public Show createShow(Show b) {
            return showRepository.save(b);
        }
        // END OF CREATE

        // READ
        public List<Show> allShows() {
            return showRepository.findAll();
        }

        public Show findShow(Long id) {
            Optional<Show> optionalShow = showRepository.findById(id);
            if(optionalShow.isPresent()) {
                return optionalShow.get();
            } else {
                return null;
            }
        }
        
//        find title
        public Show findTitle(String title) {
        	return showRepository.findByTitle(title);
        }
        
        // END OF READ

        // UPDATE
        public Show updateShow(Show b){
            return showRepository.save(b);
        }
        // END OF UPDATE

        // DELETE
        public void deleteShow(Long id){
            showRepository.deleteById(id);
        }
        // END OF DELETE
        
    // END OF CRUD METHODS
}