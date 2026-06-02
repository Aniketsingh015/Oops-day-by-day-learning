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
}
