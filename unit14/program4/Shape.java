abstract class Shape {
    public void draw() { System.out.println(this + ".draw()"); }
    public void rotate(){System.out.println(this + ".rotate()");}
    public void highlight(){flag=true;}
    public void highlightOff(){flag=false;}
    public boolean isHighlighted(){return flag;}
    abstract public String toString();
    private boolean flag=false;
}
