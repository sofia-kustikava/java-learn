public class RectangularGlyph extends Glyph{
    private int width = 10;
    private int length = 20;

    public RectangularGlyph(int width, int length) {
        this.width = width;
        this.length = length;
        System.out.println("RectangleGlyph.draw(), width = " + this.width);
        System.out.println("RectangleGlyph.draw(), length = " + this.length);
    }

    public void draw() {
        System.out.println("RectangleGlyph.draw(), width = " + width);
        System.out.println("RectangleGlyph.draw(), length = " + length);
    }
}
