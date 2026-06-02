public class Books {
    int id;
    String name;
    String author;
    String genre;
    int totalCopies;
    int availableCopies;


    //constructor which is default when there is not more information we will use it then

    Books(){
        this.id=0;
        this.name="Unknown name";
        this.author="Unknown author";
        this.genre="Unknown genre";
        this.totalCopies=0;
        this.availableCopies=0;
    }



    // =========================================================
    // CONSTRUCTOR 2 — Parameterized Constructor
    // =========================================================
    // Creates a book with all values provided upfront.
    //
    // IMPORTANT DESIGN DECISION:
    // We take totalCopies as a parameter, but NOT availableCopies.
    // WHY? Because when a book is first added to the library,
    // ALL copies are available. It would be a mistake to let
    // someone accidentally say availableCopies > totalCopies.
    // So we set availableCopies = totalCopies automatically.

    Books(int id, String name, String author, String genre, int totalCopies){
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

}