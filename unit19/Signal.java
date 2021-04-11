public enum Signal {
    GREEN("You can pass!"),
    YELLOW("Red light coming soon!"),
    RED("You must stop!");

    private String description;
    private Signal(String s){
        this.description=s;
    }
    public String getDescription(){return description;}

    public String toString(){
        String id=name();
        return id;
    }
}
