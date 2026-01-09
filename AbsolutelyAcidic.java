import java.io.*;
import java.util.*;

public class AbsolutelyAcidic {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    public static void main(String[] args) throws IOException {
        int num = readInt();
        int[] numList = new int[num];

        for(int i = 0; i < num; i++){
            numList[i] = readInt();
        }

        int maxDiff = 0;

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int n : numList) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        int maxFrequency = 0;
        for(int freq : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, freq);
        }

        List<Integer> highFNum = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if(entry.getValue() == maxFrequency) {
                highFNum.add(entry.getKey());
            }
        }


        if(highFNum.size() >= 2) {
            for(int i = 0; i < highFNum.size(); i++) {
                for(int j = i + 1; j < highFNum.size(); j++) {
                    maxDiff = Math.max(maxDiff, Math.abs(highFNum.get(i) - highFNum.get(j)));
                }
            }
        } else {
            int secMaxFrequency = 0;
            for(int freq : frequencyMap.values()) {
                if(freq < maxFrequency) {
                    secMaxFrequency = Math.max(secMaxFrequency, freq);
                }
            }

            List<Integer> secHighFNum = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                if(entry.getValue() == secMaxFrequency) {
                    secHighFNum.add(entry.getKey());
                }
            }

            int highestReading = highFNum.get(0);
            for(int reading : secHighFNum) {
                maxDiff = Math.max(maxDiff, Math.abs(highestReading - reading));
            }
        }

        System.out.println(maxDiff);
    }
}