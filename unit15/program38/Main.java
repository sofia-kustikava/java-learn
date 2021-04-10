//Create a simple Decorator system by starting with basic coffee, then
//providing decorators of steamed milk, foam, chocolate, caramel and whipped cream.

public class Main {
    private enum CoffeeType {
        MOCHA, CAPPUCCINO, LATTE, MOKA;

        public String toString() {
            return name().toLowerCase();
        }
    }

    private static class Coffee {
        private CoffeeType type;
        private String name;

        public Coffee(CoffeeType type) {
            this.type = type;
            name = this.type.toString();
        }

        public CoffeeType getType() {
            return type;
        }

        public String changeName(String prefix) {
            String old = name;
            name = prefix + " " + name;
            return old;
        }

        public void drink() {
            System.out.println(name + " Bon appetite!");
        }
    }

    private static class CoffeeDecorator extends Coffee {
        protected Coffee myCoffee;

        public CoffeeDecorator(Coffee c) {
            super(c.getType());
            myCoffee = c;
        }

        public String changeName(String prefix) {
            return myCoffee.changeName(prefix);
        }

        public void drink() {
            myCoffee.drink();
        }
    }

    private static class CoffeeDecoratorMilk extends CoffeeDecorator {
        private static final String NAME = "Milk";
        protected final String INGREDIENT = NAME;

        public CoffeeDecoratorMilk(Coffee c) {
            super(c);
            myCoffee.changeName(INGREDIENT);
        }
    }

    private static class CoffeeDecoratorFoam extends CoffeeDecorator {
        private static final String NAME = "Foam";
        protected final String INGREDIENT = NAME;

        public CoffeeDecoratorFoam(Coffee c) {
            super(c);
            myCoffee.changeName(INGREDIENT);
        }
    }

    private static class CoffeeDecoratorChocolate extends CoffeeDecorator {
        private static final String NAME = "Chocolate";
        protected final String INGREDIENT = NAME;

        public CoffeeDecoratorChocolate(Coffee c) {
            super(c);
            myCoffee.changeName(INGREDIENT);
        }
    }

    private static class CoffeeDecoratorCaramel extends CoffeeDecorator {
        private static final String NAME = "Caramel";
        protected final String INGREDIENT = NAME;

        public CoffeeDecoratorCaramel(Coffee c) {
            super(c);
            myCoffee.changeName(INGREDIENT);
        }
    }

    private static class CoffeeDecoratorCream extends CoffeeDecorator {
        private static final String NAME = "Cream";
        protected final String INGREDIENT = NAME;
        protected final String SHAPE;

        public CoffeeDecoratorCream(String shape, Coffee c) {
            super(c);
            SHAPE = shape;
            myCoffee.changeName(INGREDIENT);
        }

        public void draw() {
            myCoffee.changeName(SHAPE);
        }
    }

    public static void main(String[] args) {
        CoffeeDecoratorCream myCoffee = new CoffeeDecoratorCream("Decor for coffee", new CoffeeDecoratorCaramel(new CoffeeDecoratorChocolate(new CoffeeDecoratorFoam(new CoffeeDecoratorMilk(new Coffee(CoffeeType.CAPPUCCINO))))));
        myCoffee.draw();
        myCoffee.drink();
    }
}
