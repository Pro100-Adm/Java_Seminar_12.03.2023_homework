/**
 Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.
 */
import java.util.LinkedList;

 public class task_1 {

    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<Object>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println(rev(list));
    }

    public static LinkedList<Object> rev(LinkedList<Object> input_list){
        LinkedList<Object> temp = new LinkedList<Object>();
        for (int i = input_list.size()-1; i >= 0; i--) {
            temp.add(input_list.get(i));
        }
        return temp;
    }
}