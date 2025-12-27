import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void viewBooks() {
        System.out.println("\n=== AVAILABLE BOOKS ===");
        for (Book b : books) {
            System.out.println(b.getTitle() + " | " + b.getAuthor() +
                    " | Available: " + b.isAvailable());
        }
    }

    public Book searchBook(String keyword) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(keyword) ||
                b.getAuthor().equalsIgnoreCase(keyword)) {
                return b;
            }
        }
        return null;
    }

    public Member getMember(int id) {
        for (Member m : members) {
            if (m.getMemberId() == id) {
                return m;
            }
        }
        return null;
    }

    public void borrowBook(int memberId, String bookTitle) {
        Member member = getMember(memberId);
        Book book = searchBook(bookTitle);

        if (member == null || book == null) {
            System.out.println("Member or Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed.");
            return;
        }

        book.setAvailable(false);
        member.getBorrowedBooks().add(book);
        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(int memberId, String bookTitle) {
        Member member = getMember(memberId);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        for (Book b : member.getBorrowedBooks()) {
            if (b.getTitle().equalsIgnoreCase(bookTitle)) {
                b.setAvailable(true);
                member.getBorrowedBooks().remove(b);
                System.out.println("Book returned successfully.");
                return;
            }
        }

        System.out.println("This book was not borrowed by the member.");
    }
}
