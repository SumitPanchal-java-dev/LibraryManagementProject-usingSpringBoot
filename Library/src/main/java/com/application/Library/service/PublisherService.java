package com.application.Library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Library.entity.Publisher;
import com.application.Library.repository.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	PublisherRepository publisherRepo;

	public List<Publisher> finadAllPublisher() {
		return publisherRepo.findAll();
	}

	public Publisher findPublisher(Long id) {
		Publisher publisher;
		publisher = publisherRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not Found"));
		return publisher;
	}

	public void createPublisher(Publisher newpublisher) {
		publisherRepo.save(newpublisher);
	}

	public void updatePublisher(Publisher newpublisher) {
		publisherRepo.save(newpublisher);
	}

	public void deletePublisher(Long id) {
		Publisher publisher;
		publisher = publisherRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not Found"));
		publisherRepo.deleteById(publisher.getId());
	}
}
