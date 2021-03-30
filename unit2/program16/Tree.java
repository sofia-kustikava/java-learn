class Tree {
    int height;

    Tree() {
        System.out.println("Caжаем росток");
        height = 0;
    }
    Tree(int initialHeight) {
        height = initialHeight;
        System.out.println("Coздание нового дерева высотой " + height + " м.");
    }
    void info() {
        System.out.println("Дерево высотой " + height + " м.");
    }
    void info(String s) {
        System.out.println(s + ": Дерево высотой " + height + " м.");
    }
}
