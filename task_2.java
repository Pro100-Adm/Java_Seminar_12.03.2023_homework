/**
 Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.
 */
import java.util.LinkedList;

 public class task_2 {

    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<Object>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println(enqueue(list, 4));
        System.out.println(dequeue(list));
        System.out.println(first(list));
        System.out.println(first(list));
    }

    public static LinkedList<Object> enqueue(LinkedList<Object> input_list, Object element){
        input_list.add(element);
        return input_list;
    }

    public static Object dequeue(LinkedList<Object> input_list){
        return input_list.removeFirst();
    }

    public static Object first(LinkedList<Object> input_list){
        return input_list.getFirst();
    }
}