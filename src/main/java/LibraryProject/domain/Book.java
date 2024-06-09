package LibraryProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String author;
	private String name;
	private int publicationYear;
	private String genre;
	private String coverImageUrl;
	private boolean read;
	private int rating;
	private String review;
	public Long getId() {
		return id;
	}
	public String getAuthor() {
		return author;
	}
	public String getName() {
		return name;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public String getGenre() {
		return genre;
	}
	public String getCoverImageUrl() {
		return coverImageUrl;
	}
	public boolean isRead() {
		return read;
	}
	public int getRating() {
		return rating;
	}
	public String getReview() {
		return review;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", name=" + name + ", publicationYear=" + publicationYear
				+ ", genre=" + genre + ", coverImageUrl=" + coverImageUrl + ", read=" + read + ", rating=" + rating
				+ ", review=" + review + "]";
	}
	
	
}