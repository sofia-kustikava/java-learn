interface Selector {
    boolean end();
    Object current();
    void next();
    Sequence getSequence();
}
