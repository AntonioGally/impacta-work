public interface ISomething {
    DoubledLinkedList insertStart(DoubledLinkedList list, int info);

    DoubledLinkedList insertEnd(DoubledLinkedList list, int info);

    DoubledLinkedList insertBetween(DoubledLinkedList list, int info, int position);

    DoubledLinkedList removeStart(DoubledLinkedList list);

    DoubledLinkedList removeEnd(DoubledLinkedList list);

    DoubledLinkedList removeBetween(DoubledLinkedList list, int position);

    void print(DoubledLinkedList list);
    void printStartToEnd(DoubledLinkedList list);
    void printEndToStart(DoubledLinkedList list);
}
