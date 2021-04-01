public enum Paper {

    EURO, RUBLE, DOLLAR;

    public void choose(Paper money) {
        switch (money) {
            case EURO:
                System.out.println("Euro");
                break;
            case RUBLE:
                System.out.println("Ruble");
                break;
            case DOLLAR:
                System.out.println("Dollar");
        }
    }
}
