import java.util.ArrayList;

public class RandomOutServer extends RandomOutPOA {
    static ArrayList<String> list = new ArrayList<>();

    @Override
    public void addWords(String word) {
        list.add(word);

    }

    @Override
    public String getLetters(String res) {
        res.split(" ");
        return res;
    }

}

//    Vector<Integer> vector = new Vector<>();
//    //Integer a = (int)(Math.random()*100+1); //[1,100] [a;b) *(b-a)+a
//    Integer amount = (int)(Math.random()*100+1);
//        for (int i = 0; i<amount; i++){
//        Integer a = (int)(Math.random()*100+1);
//        vector.add(a);
//        }
//        return vector;

//        Map map = new Map();
//        for (Integer integer : vector) {
//            key++;
//            map[key - 1] = new KeyVal(key, integer);
//        }
