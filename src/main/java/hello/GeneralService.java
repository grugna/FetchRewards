package hello;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GeneralService {

    public Boolean isPyramid(String word) {
        List<Map.Entry<Character, Integer> > chars = getFrequencies(word);

        for (int i=1; i <= chars.size() ;i++) {
            if (i != chars.get(i-1).getValue()) {
                return false;
            }
        }

        return true;
    }

    private List<Map.Entry<Character, Integer>> getFrequencies(String word) {

        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : word.toCharArray()) {
            frequencies.merge(c,
                    1,
                    Integer::sum);
        }

        List<Map.Entry<Character, Integer> > orderedList =
                new LinkedList<Map.Entry<Character, Integer> >(frequencies.entrySet());

        Collections.sort(orderedList, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        return orderedList;
    }

}



