import java.io.*;
import java.util.*;

public class Main2 {
        public static void main(String[] args) throws IOException {
            File file = new File("fail.txt");
            System.out.println(file.createNewFile());
            List numbers = new ArrayList<Integer>();

            try (BufferedWriter bufferedOutputStream = new BufferedWriter(new FileWriter(file))){
                for (int i = 0; i < 30; i++) {
                    Integer number = new Random().nextInt();
                    bufferedOutputStream.write(number.toString()+"\n");
                }
            } catch (IOException e){
                e.printStackTrace();
            }

            try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)))){
                while (scanner.hasNext()){
                    numbers.add(scanner.nextInt());
                }
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }

            Collections.sort(numbers);

            try (BufferedWriter bufferedOutputStream = new BufferedWriter(new FileWriter(file))){
                for (Object number : numbers) {
                    bufferedOutputStream.write(number.toString()+"\n");
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

