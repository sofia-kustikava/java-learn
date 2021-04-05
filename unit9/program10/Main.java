//Modify Musics.java by adding a Playable interface. Move the play( )
//declaration from Instrument to Playable. Add Playable to the derived classes by
//including it in the implement s list. Change tune( ) so that it takes a Playable instead of
//an Instrument. 

public class Main {
    static void tune(Playable i) { 
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Playable[] e) {
        for (Playable i : e)
            tune(i);
    }

    public static void main(String[] args) {
        Playable[] orchestra = {
                new Windd(),
                new Percussionn(),
                new Stringedd(),
                new Brasss(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}
