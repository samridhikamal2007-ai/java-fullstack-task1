package com.maincrafts.internship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class InternshipApplication {
	public static void main(String[] args) {
		SpringApplication.run(InternshipApplication.class, args);
	}
}

// ==========================================
// 1. DATABASE ENTITY
// ==========================================
@Entity
@Table(name = "contacts")
class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	@Column(length = 1000)
	private String message;

	public Contact() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

// ==========================================
// 2. DATA TRANSFER OBJECT (VALIDATION)
// ==========================================
class ContactDTO {
	@NotBlank(message = "Name cannot be blank.")
	private String name;

	@NotBlank(message = "Email cannot be blank.")
	@Email(message = "Invalid email format.")
	private String email;

	@NotBlank(message = "Message cannot be empty.")
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

// ==========================================
// 3. REPOSITORY INTERFACE
// ==========================================
interface ContactRepository extends JpaRepository<Contact, Long> {
}

// ==========================================
// 4. SERVICE LAYER
// ==========================================
interface ContactService {
	Contact saveContact(ContactDTO contactDTO);

	List<Contact> getAllContacts();
}

@Service
class ContactServiceImpl implements ContactService {
	private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

	private final ContactRepository repo;

	ContactServiceImpl(ContactRepository repo) {
		this.repo = repo;
	}

	@Override
	public Contact saveContact(ContactDTO dto) {
		logger.info("=========================================");
		logger.info("Task 1 - Name: {}, Email: {}, Message: {}", dto.getName(), dto.getEmail(), dto.getMessage());
		logger.info("=========================================");

		Contact contact = new Contact();
		contact.setName(dto.getName());
		contact.setEmail(dto.getEmail());
		contact.setMessage(dto.getMessage());
		return repo.save(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}
}

// ==========================================
// 5. REST CONTROLLER (ROUTING)
// ==========================================
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
class ContactController {

	private final ContactService contactService;

	ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	@PostMapping("/submit")
	public ResponseEntity<Contact> saveContact(@Valid @RequestBody ContactDTO contactDTO) {
		Contact savedContact = contactService.saveContact(contactDTO);
		return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
	}

	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getAllContacts() {
		return ResponseEntity.ok(contactService.getAllContacts());
	}
}