@FunctionalInterface
public interface Operation<T> {
    T operation(T value1, T value2 );
}
