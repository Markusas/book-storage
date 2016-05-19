package lt.book.storage.runner;


import lt.book.storage.dto.BookDto;
import lt.book.storage.service.BookStorageService;
import lt.book.storage.service.impl.BookStorageServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Runner {


    private BookStorageService service;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Runner() {
        this.service = new BookStorageServiceImpl();
    }

    static private Runner runner = new Runner();

    public static void main(String[] args) throws IOException {
        runner.menu();
    }

    private void menu() throws IOException {
        System.out.println("Menu:");
        System.out.println(" 1 - show's data");
        System.out.println(" 2 - enter data");
        System.out.println(" 3 - update data");
        System.out.println(" 4 - delete data");
        System.out.println(" 5 - exit");
        System.out.println("Eneter the number: ");
        int data = Integer.parseInt(br.readLine());

        switch (data) {
            case 1:
                runner.showBooks();
                break;
            case 2:
                runner.enterBooks();
                break;
            case 3:
                runner.updateEnter();
                break;
            case 4:
                runner.removeBook();
                break;
            case 5:
                System.exit(1);
                break;
            default:
                System.out.println("No such number");
        }
    }

    private void showBooks() throws IOException {
        List<BookDto> enters = service.retriveBooks();

        for (BookDto enter : enters) {
            System.out.println("Book name: " + enter.getBookName() + ", Book author: " + enter.getBookAuthor() + ", Book Id: " + enter.getBookId());
        }
        runner.menu();
    }

    private void enterBooks() throws IOException {

        System.out.println("Enter author name: ");
        String authotName = br.readLine();

        System.out.println("Enter book name: ");
        String bookName = br.readLine();

        System.out.println("Enter isbn: ");
        String isbn = br.readLine();

        BookDto books = new BookDto();

        books.setBookAuthor(authotName);
        books.setBookName(bookName);
        books.setIsbn(isbn);

        service.addOrEdit(books);
        runner.menu();

    }

    private void removeBook() throws IOException {
        System.out.println("Enter id: ");
        String idStr = br.readLine();
        Integer id = Integer.parseInt(idStr);

        service.removeBook(id);
        runner.menu();
    }

    private void updateEnter() throws IOException {
        System.out.println("Enter id: ");
        String idStr = br.readLine();
        Integer id = Integer.parseInt(idStr);
        BookDto byID = service.findByID(id);

        System.out.println("Book name: " + byID.getBookName() + "; Book author: " + byID.getBookAuthor() + "; Book ISBN: " + byID.getIsbn());

        System.out.println("Enter author name for update: ");
        String authotName = br.readLine();

        System.out.println("Enter book name for update: ");
        String bookName = br.readLine();

        System.out.println("Enter isbn for update: ");
        String isbn = br.readLine();

        byID.setBookName(bookName);
        byID.setBookAuthor(authotName);
        byID.setIsbn(isbn);


        service.addOrEdit(byID);
        runner.menu();
    }

}
