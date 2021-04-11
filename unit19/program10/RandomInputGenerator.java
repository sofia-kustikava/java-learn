public class RandomInputGenerator implements Generator<Input> {
    public Input next() { return Input.randomSelection(); }
}
