package problems;

import java.io.*;

/**
 * Problem: <a href="link">
 * problem</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/rdr/Downloads/lineitem.tbl"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            int counter = 0;
            while (line != null && counter <= 10000) {
                StringBuilder insert = new StringBuilder();
                String[] split = line.split("\\|");

                insert.append("(");
                for (int i = 0; i < split.length; i++) {
                    if (i <= 7) {
                        insert.append(split[i]);
                    } else {
                        insert.append("'" + split[i] + "'");
                    }
                    if (i != split.length - 1) {
                        insert.append(", ");
                    }
                }
                insert.append("),");

                sb.append(insert);
                sb.append(System.lineSeparator());
                line = br.readLine();
                System.out.println("");
                counter++;
            }

            String everything = sb.toString();

            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/rdr/Downloads/lineitem_insert.txt"));
            writer.write(everything);

            writer.close();
        } finally {
            br.close();
        }
    }
}
