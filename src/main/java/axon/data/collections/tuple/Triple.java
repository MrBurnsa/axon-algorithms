package axon.data.collections.tuple;

public final class Triple<A, B, C> {
    public final A first;
    public final B second;
    public final C third;

    public Triple(final A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}