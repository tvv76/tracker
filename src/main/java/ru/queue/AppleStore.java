package ru.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        for (int i = 1; i < count; i++) {
            queue.poll();
        }
        return queue.poll().name();
    }

    public String getFirstUpsetCustomer() {
        for (int i = 1; i <= count; i++) {
            queue.poll();
        }
        return queue.poll().name();
    }
}
/*Вашей задачей будет реализовать 2 метода. Некоторые пояснения:
- поле Queue хранит в себе очередь клиентов, которые пришли в магазин;
- поле count хранит в себе количество доступного к покупке товара;
- метод getLastHappyCustomer() должен вернуть имя последнего счастливого обладателя желаемого товара;
- метод getFirstUpsetCustomer() должен вернуть имя первого клиента, которому сегодня не повезло и ему не хватило товара;
- очередь не может быть пустой;
- для решения вам пригодится метод poll(), а также в обоих методах цикл fori;
- всегда существует последний счастливый обладатель товара и клиент, которому не повезло и товара не хватило. Т.е. при последовательном удалении объектов из очереди не может сложиться ситуации, что при удалении текущего объекта Customer из очереди он не может быть null, проверять это не нужно.
*/
