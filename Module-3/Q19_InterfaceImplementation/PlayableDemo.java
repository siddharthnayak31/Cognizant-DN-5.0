package Q19_InterfaceImplementation;

interface Playable {
    void play();
}

class Guitar implements Playable {

    public void play() {
        System.out.println("Playing Guitar");
    }
}

class Piano implements Playable {

    public void play() {
        System.out.println("Playing Piano");
    }
}

public class PlayableDemo {

    public static void main(String[] args) {

        Guitar guitar = new Guitar();
        Piano piano = new Piano();

        guitar.play();
        piano.play();
    }
}