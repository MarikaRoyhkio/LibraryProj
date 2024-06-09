package LibraryProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import LibraryProject.domain.Book;
import LibraryProject.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "index";
		
	}
	
	@GetMapping("/add")
	public String addBookSubmit(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        return "editBook";
    }

    @PostMapping("/edit/{id}")
    public String editBookSubmit(@PathVariable("id") Long id, @ModelAttribute Book book) {
        book.setId(id);
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        bookRepository.delete(book);
        return "redirect:/";
    }

    @GetMapping("/review/{id}")
    public String reviewBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        return "reviewBook";
    }

    @PostMapping("/review/{id}")
    public String reviewBookSubmit(@PathVariable("id") Long id, @RequestParam int rating, @RequestParam(required = false) String review) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        book.setRead(true);
        book.setRating(rating);
        book.setReview(review);
        bookRepository.save(book);
        return "redirect:/";
    }
}